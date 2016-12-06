package cn.com.chengzi.framework.security.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.chengzi.framework.common.query.PageCalculate;
import cn.com.chengzi.framework.common.query.SimpleQueryCriteria;
import cn.com.chengzi.framework.security.model.SysAuth;
import cn.com.chengzi.framework.security.model.SysRoles;
import cn.com.chengzi.framework.security.model.SysUsers;
import cn.com.chengzi.framework.security.query.SysUsersQureyCriteria;
import cn.com.chengzi.framework.security.service.SysUsersService;
import cn.com.chengzi.framework.security.service.impl.SecurityUserHolder;

//@RestController 使用rest风格，ajax
@Controller
public class SysUsersController {
	@Autowired
	private SysUsersService sysUsersService;
	
	@Autowired
	private SecurityUserHolder securityUserHolderService;
	
	private List<?> folderList;
	
	/**
	 * 根据登陆id获取用户一级菜单
	 * @param userId
	 * @return
	 */
    @RequestMapping(path = "/getSysUserFolder" , method = RequestMethod.POST)
	public @ResponseBody List<?> getSysUserFolder(){        	
    	SimpleQueryCriteria simpleQueryCriteria = new SimpleQueryCriteria();   
    	simpleQueryCriteria.setIntVal1(securityUserHolderService.getCurrentUser().getUser_id());
        
        this.folderList = sysUsersService.getUserFloder(simpleQueryCriteria);
    	return this.folderList;    	    	         
	}
    
    /**
     * 获取角色列表及权限等级
     */
    @RequestMapping(path = "/getSysRoles", method = RequestMethod.POST)
	public @ResponseBody List<SysRoles> getSysRoles(){
		
    	return sysUsersService.getSysRoles();   		    	         
	}
    
    @RequestMapping(path = "/updateRoleById", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> updateRoleById(@RequestBody SysRoles sysRoles){        	
    	Map<String,Object> returnMap = new HashMap<String,Object>(); 
		sysUsersService.updateRoleById(sysRoles);
		
			returnMap.put("status", "1");
			returnMap.put("message", "更新成功");
		
		return (HashMap<String, Object>) returnMap;
    	   	    	         
	}
    
    @RequestMapping(path = "/insertsysRoles", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> insertsysRoles(@RequestBody SysRoles sysRoles){        	
    	Map<String,Object> returnMap = new HashMap<String,Object>(); 
		sysUsersService.insertsysRoles(sysRoles);
		
			returnMap.put("status", "1");
			returnMap.put("message", "插入成功");
		
		return (HashMap<String, Object>) returnMap;
    	   	    	         
	}
    
    @RequestMapping(path = "/deleteRoleById", method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> deleteRoleById(int role_id){        	
    	Map<String,Object> returnMap = new HashMap<String,Object>();
    	
    	sysUsersService.deleteAuthRole(role_id);
		sysUsersService.deleteRoleById(role_id);
		
			returnMap.put("status", "1");
			returnMap.put("message", "删除成功");
		
		return (HashMap<String, Object>) returnMap;
    	   	    	         
	}
    

    @RequestMapping(path = "/insertAuthRole",method = RequestMethod.POST)
    public @ResponseBody HashMap<String,Object> insertAuthRole(int role_id, @RequestParam(value="array[]") Integer[] array){
    	
    	for(int i=0;i<array.length;i++){
    		sysUsersService.insertAuthRole(role_id, array[i]);
    	}

    	return (HashMap<String, Object>) new HashMap<String,Object>().put("message", "真加");
    }
    
    @RequestMapping(path = "/deleteAuthRole",method = RequestMethod.POST)
    public @ResponseBody HashMap<String,Object> deleteAuthRole(int role_id){
    	sysUsersService.deleteAuthRole(role_id);
    	
    	return (HashMap<String, Object>) new HashMap<String,Object>().put("message", "删除");
    }
    
    /**
     * 根据角色ID获取所有权限名信息
     */
    @RequestMapping(path = "/getAuthById" ,method = RequestMethod.POST )
	public @ResponseBody ArrayList<HashMap<String, Object>> getAuthById(int role_id){ 
    	List<SysAuth> sysAuth=sysUsersService.getAuth();
    	ArrayList<HashMap<String, Object>> list=new ArrayList<HashMap<String, Object>>();
    	for (SysAuth sysAuth1 : sysAuth) {
    				
    		List<SysAuth> childAuth=sysUsersService.getChildAuthById(role_id, sysAuth1.getAuthority_id());
    		ArrayList<HashMap<String, Object>> list2=new ArrayList<HashMap<String, Object>>();
        	for (SysAuth childAuth1 : childAuth) {
        		HashMap<String, Object> map2=new HashMap<String, Object>();
        		map2.put("id", childAuth1.getAuthority_id());
            	map2.put("text", childAuth1.getAuthority_name());
            	if(childAuth1.getAuthority_type()==100100) {
					map2.put("iconCls", "icon-man");
            	}
            	list2.add(map2);
    		}
        	
        	HashMap<String, Object> map=new HashMap<String, Object>();
    		map.put("id", sysAuth1.getAuthority_id());
        	map.put("text", sysAuth1.getAuthority_name());
        	map.put("children", list2);
        	list.add(map);    	
		}
    	return list;	         
	}

    /**
     * 获取根权限
     */
    @RequestMapping(path = "/getAuth")
	public @ResponseBody ArrayList<HashMap<String, Object>> getAuth(){ 
    	
    	List<SysAuth> sysAuth=sysUsersService.getAuth();
    	ArrayList<HashMap<String, Object>> list=new ArrayList<HashMap<String, Object>>();
    	for (SysAuth sysAuth1 : sysAuth) {
    		HashMap<String, Object> map=new HashMap<String, Object>();
    		map.put("id", sysAuth1.getAuthority_id());
        	map.put("text", sysAuth1.getAuthority_name());
        	if(sysAuth1.getAuthority_type()==100100) {
				map.put("iconCls", "icon-man");
        	}
        	list.add(map);    	
		}
    	
    	return list;  	    	         
	}
    
    
    @RequestMapping(path = "/getAllAuth")
    public @ResponseBody ArrayList<HashMap<String, Object>> getAllAuth(){
    	
		return getAllAuthById(1);
    	
    }   
    /**
     * 获取全部权限
     */
    @RequestMapping(path = "/getAllAuthById" ,method = RequestMethod.POST )
    public @ResponseBody ArrayList<HashMap<String, Object>> getAllAuthById(int authority_id){
    	
    	HashMap<String, Object> map=new HashMap<String,Object>();
    	
    	ArrayList<HashMap<String, Object>> list=new ArrayList<HashMap<String, Object>>();
    	
    	SysAuth auth = sysUsersService.getAuthById(authority_id);
    	
    	map.put("id",auth.getAuthority_id());
		map.put("text", auth.getAuthority_name());
		map.put("childrenCount", auth.getChildrenCount());
		//map.put("state", "closed");
		map.put("children",getChildAuth(auth));
    	list.add(map);
		return list;
    }
    public ArrayList<HashMap<String, Object>> getChildAuth(SysAuth sysAuth){
    	
    	ArrayList<HashMap<String, Object>> list1=new ArrayList<HashMap<String, Object>>();
    	if(sysAuth.getChildrenCount()!=0){
			Integer[] childrenId=sysUsersService.getChildAuthIdById(sysAuth.getAuthority_id());
			for(int i=0;i<childrenId.length;i++){   
				HashMap<String, Object> map1=new HashMap<String,Object>();
				SysAuth auth=sysUsersService.getAuthById(childrenId[i]);//2
				map1.put("id",auth.getAuthority_id());
				map1.put("text", auth.getAuthority_name());
				map1.put("childrenCount", auth.getChildrenCount());
				//map.put("state", "closed");
				map1.put("children", getChildAuth(auth));
				list1.add(map1);
				
			}
		}
    	//System.out.println("-------------"+list1.toString());
		return list1;    	
    }
    
    /**
     * 根据角色获取全部权限
     */
    @RequestMapping(path = "/getAllAuthByRoleId" ,method = RequestMethod.POST )
    public @ResponseBody ArrayList<HashMap<String, Object>> getAllAuthById(int role_id,int authority_id){
    	
    	HashMap<String, Object> map=new HashMap<String,Object>();
    	
    	ArrayList<HashMap<String, Object>> list=new ArrayList<HashMap<String, Object>>();
    	
    	SysAuth auth = sysUsersService.getAuthById(authority_id);
    	
    	map.put("id",auth.getAuthority_id());
		map.put("text", auth.getAuthority_name());
		map.put("childrenCount", auth.getChildrenCount());
		//map.put("state", "closed");
		map.put("children",getChildAuthByRoleId(role_id,auth));
    	list.add(map);
		return list;
    }
    public ArrayList<HashMap<String, Object>> getChildAuthByRoleId(int role_id,SysAuth sysAuth){
    	
    	ArrayList<HashMap<String, Object>> list1=new ArrayList<HashMap<String, Object>>();
    	if(sysAuth.getChildrenCount()!=0){
			Integer[] childrenId=sysUsersService.getChildAuthIdByRoleId(role_id,sysAuth.getAuthority_id());
			
			for(int i=0;i<childrenId.length;i++){   
				HashMap<String, Object> map1=new HashMap<String,Object>();
				SysAuth auth=sysUsersService.getAuthById(childrenId[i]);
				map1.put("id",auth.getAuthority_id());
				map1.put("text", auth.getAuthority_name());
				map1.put("childrenCount", auth.getChildrenCount());
				//map.put("state", "closed");
				map1.put("children", getChildAuthByRoleId(role_id,auth));
				list1.add(map1);
				
			}
		}
    	//System.out.println("-------------"+list1.toString());
		return list1;    	
    }
    
    /**
     * 根据角色ID获取所有权限ID
     */
    @RequestMapping(path = "/getAuthIdById",method = RequestMethod.POST)
    public @ResponseBody Integer[] getAuthIdById(int role_id){
    	Integer[] arr=sysUsersService.getAuthIdById(role_id);
    	System.out.println("---------------------------------------------"+arr.length);
    	return arr;
    }
    /**
     * 获取子权限
     */
    @RequestMapping(path = "/getChildAuthById" ,method = RequestMethod.POST )
	public @ResponseBody ArrayList<HashMap<String, Object>> getChildAuthByName(int role_id,int authority_id){ 
    	
    	List<SysAuth> sysAuth=sysUsersService.getChildAuthById(role_id,authority_id);
    	
    	ArrayList<HashMap<String, Object>> list=new ArrayList<HashMap<String, Object>>();
    	for (SysAuth sysAuth1 : sysAuth) {
    		HashMap<String, Object> map=new HashMap<String, Object>();
    		map.put("id", sysAuth1.getAuthority_id());
        	map.put("text", sysAuth1.getAuthority_name());
        	list.add(map);
		} 	
    	
    	return  list;   	    	         
	}
    

    
    /**
     * 根据角色ID获取用户信息
     */
    @RequestMapping(path = "/getUsersById" , method = RequestMethod.POST)
	public @ResponseBody HashMap<String, Object> getUsersById(SysUsersQureyCriteria sysUsersQureyCriteria){ 
    
    	Map<String,Object> map = new HashMap<String,Object>();
    	
		int totalCount = sysUsersService.getUsersCnt(sysUsersQureyCriteria);
		
		int pageSize = Integer.valueOf(sysUsersQureyCriteria.getPageSize());
		int pageNumber = Integer.valueOf(sysUsersQureyCriteria.getPageNumber());
		
		PageCalculate pageCalculate = new PageCalculate(totalCount,pageSize,pageNumber);
		
		sysUsersQureyCriteria.setIndex(pageCalculate.getIndex());
		
		List<SysUsers> sysUsersList = sysUsersService.getUsersById(sysUsersQureyCriteria);//分页记录
		map.put("rows", sysUsersList);
		map.put("total", totalCount);	
		
		return (HashMap<String, Object>) map;
     	    	         
	}
    
    /**
     * 根据角色ID获取其它所有用户信息
     */
    @RequestMapping(path = "/sysUsersListByRole" , method = RequestMethod.POST)
	public @ResponseBody HashMap<String,Object> sysUsersListByRole(SysUsersQureyCriteria sysUsersQureyCriteria){        	
    	Map<String,Object> map = new HashMap<String,Object>();
		
		int totalCount = sysUsersService.findSysUsersListCnt(sysUsersQureyCriteria);
		
		int pageSize = Integer.valueOf(sysUsersQureyCriteria.getPageSize());
		int pageNumber = Integer.valueOf(sysUsersQureyCriteria.getPageNumber());
		
		PageCalculate pageCalculate = new PageCalculate(totalCount,pageSize,pageNumber);
		
		sysUsersQureyCriteria.setIndex(pageCalculate.getIndex());
		
		List<SysUsers> sysUsersList = sysUsersService.sysUsersListByRole(sysUsersQureyCriteria);//分页记录
		map.put("rows", sysUsersList);
		map.put("total", totalCount);	
		
		return (HashMap<String, Object>) map;   	    	         
	}
}

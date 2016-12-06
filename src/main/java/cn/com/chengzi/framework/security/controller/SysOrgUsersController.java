package cn.com.chengzi.framework.security.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import cn.com.chengzi.framework.common.query.PageCalculate;
import cn.com.chengzi.framework.security.model.SysOrganizer;
import cn.com.chengzi.framework.security.model.SysUsers;
import cn.com.chengzi.framework.security.query.SysUsersQureyCriteria;
import cn.com.chengzi.framework.security.service.SysOrgUsersService;


@RestController
public class SysOrgUsersController {
	
	@Autowired
	private SysOrgUsersService sysOrgUsersService;
	
	
	@RequestMapping(path = "/getAllOrg")
    public ArrayList<HashMap<String, Object>> getAllOrg(int role_id){
    	
		return getAllOrgById(role_id,1);
    	
    }   
    /**
     * 获取全部组织
     */
    @RequestMapping(path = "/getAllOrgById" ,method = RequestMethod.POST )
    public ArrayList<HashMap<String, Object>> getAllOrgById(int role_id,int organizer_id){
    	
    	HashMap<String, Object> map=new HashMap<String,Object>();
    	
    	ArrayList<HashMap<String, Object>> list=new ArrayList<HashMap<String, Object>>();
    	
    	SysOrganizer org = sysOrgUsersService.getOrgById(organizer_id);
    	
    	map.put("id",org.getOrganizer_id());
		map.put("text", org.getOrganizer_name());
		map.put("childrenCount", org.getChildrenCount());
		//if(org.getChildrenCount()!=0)
			map.put("state", "closed");
		map.put("children",getChildOrg(role_id,org));
    	list.add(map);
		return list;
    }
    
    public ArrayList<HashMap<String, Object>> getChildOrg(int role_id,SysOrganizer sysOrganizer){
    	
    	ArrayList<HashMap<String, Object>> list1=new ArrayList<HashMap<String, Object>>();
    	if(sysOrganizer.getChildrenCount()!=0){
    		if(role_id!=0){
    			ArrayList<HashMap<String, Object>> list2=new ArrayList<HashMap<String, Object>>();
    			list2=(ArrayList<HashMap<String, Object>>) sysUsersListByOrg(role_id,sysOrganizer.getOrganizer_id());
    			System.out.println(role_id+"--------------------------------------"+sysOrganizer.getOrganizer_id());
    			for (HashMap<String, Object> hashMap : list2) {
    				System.out.println("------------------------"+hashMap+"---------------------------------------");
					list1.add(hashMap);
				}
    		}		
			Integer[] childrenId=sysOrgUsersService.getChildOrgIdById(sysOrganizer.getOrganizer_id());
			for(int i=0;i<childrenId.length;i++){   
				HashMap<String, Object> map1=new HashMap<String,Object>();
				SysOrganizer sysOrg=sysOrgUsersService.getOrgById(childrenId[i]);//2
				map1.put("id",sysOrg.getOrganizer_id());
				map1.put("text", sysOrg.getOrganizer_name());
				map1.put("childrenCount", sysOrg.getChildrenCount());
				//if(sysOrg.getChildrenCount()!=0)
					map1.put("state", "closed");
				map1.put("children", getChildOrg(role_id,sysOrg));
				list1.add(map1);
				
			}
		}else{
			if(role_id!=0)
			list1=(ArrayList<HashMap<String, Object>>) sysUsersListByOrg(role_id,sysOrganizer.getOrganizer_id());
		}
    	//System.out.println("-------------"+list1.toString());
		return list1;    	
    }
    

    /**
     * 根据组织ID获取非当前角色的全部成员
     */
    public List<HashMap<String, Object>> sysUsersListByOrg(int role_id,int organizer_id){
    
    	ArrayList<HashMap<String, Object>> list=new ArrayList<HashMap<String, Object>>();
    	
    	List<SysUsers> sysUsers=sysOrgUsersService.sysUsersListByOrg(role_id,organizer_id);
    	
    	for (SysUsers sysUsers1 : sysUsers) {
    		HashMap<String, Object> map=new HashMap<String,Object>();
    		map.put("id", sysUsers1.getUser_id()*100);
        	map.put("text", sysUsers1.getUser_name());
        	map.put("iconCls", "icon-man");
        	list.add(map);
		}

		return list;
    }
    
    
    /**
     * 根据组织ID获取全部成员
     */
    @RequestMapping(path = "/getAllUsersByOrg" ,method = RequestMethod.POST )
    public HashMap<String, Object> getAllUsersByOrg(SysUsersQureyCriteria sysUsersQureyCriteria){
    	
    	Map<String,Object> map = new HashMap<String,Object>();
    	
		int totalCount = sysOrgUsersService.findSysUsersCntByOrg(sysUsersQureyCriteria);
		
		int pageSize = Integer.valueOf(sysUsersQureyCriteria.getPageSize());
		int pageNumber = Integer.valueOf(sysUsersQureyCriteria.getPageNumber());
		
		PageCalculate pageCalculate = new PageCalculate(totalCount,pageSize,pageNumber);
		
		sysUsersQureyCriteria.setIndex(pageCalculate.getIndex());
		
		List<SysUsers> sysUsersList = sysOrgUsersService.getAllUsersByOrg(sysUsersQureyCriteria);//分页记录
		
		map.put("rows", sysUsersList);
		
		map.put("total", totalCount);	
		
		return (HashMap<String, Object>) map;

    }
    
    /**
     * 根据组织ID获取全部成员
     */
    @RequestMapping(path = "/insertUsers" ,method = RequestMethod.POST )
    public void insertUsers(int role_id,@RequestParam(value="array[]") Integer[] array){
    	
    	for (int i = 0; i < array.length; i++) {
			sysOrgUsersService.insertUsersToRole(array[i]/100,role_id);
		}	
    }
    
    /**
     * 根据成员id删除对应角色关联
     */
    @RequestMapping(path = "/deleteUsersById" ,method = RequestMethod.POST )
    public void deleteUsersById(int role_id,int user_id){
    	
    	sysOrgUsersService.deleteUsersById(role_id, user_id);
    }
    
    /**
     * 更新组织成员表
     */
    @RequestMapping(path = "/updateOrgUsersById" ,method = RequestMethod.POST )
    public HashMap<String,Object> updateOrgUsersById(@RequestBody SysUsers sysUsers){
    	Map<String,Object> returnMap = new HashMap<String,Object>();
    	sysOrgUsersService.updateOrgUsersById(sysUsers);
    	returnMap.put("status", "1");
		returnMap.put("message", "更新成功");
		return (HashMap<String, Object>) returnMap;
    }
    
    /**
     * 插入组织成员表
     */
    @RequestMapping(path = "/insertOrgUsers" ,method = RequestMethod.POST )
    public HashMap<String,Object> insertOrgUsers(@RequestBody SysUsers sysUsers){
    	Map<String,Object> returnMap = new HashMap<String,Object>();
    	sysOrgUsersService.insertOrgUsers(sysUsers);
    	returnMap.put("status", "1");
		returnMap.put("message", "插入成功");
		return (HashMap<String, Object>) returnMap;
    }
    
    /**
     * 删除组织成员表
     */
    @RequestMapping(path = "/deleteOrgUsersById" ,method = RequestMethod.POST )
    public HashMap<String,Object> deleteOrgUsersById(int user_id){
    	Map<String,Object> returnMap = new HashMap<String,Object>();
    	sysOrgUsersService.deleteOrgUsersById(user_id);
    	returnMap.put("status", "0");
		returnMap.put("message", "删除成功");
		return (HashMap<String, Object>) returnMap;
    }
    
}

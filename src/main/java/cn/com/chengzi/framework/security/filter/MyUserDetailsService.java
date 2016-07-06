package cn.com.chengzi.framework.security.filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import cn.com.chengzi.framework.security.model.SysUsers;
import cn.com.chengzi.framework.security.service.SysAuthoritiesService;
import cn.com.chengzi.framework.security.service.SysUsersService;

@Transactional
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	SysUsersService sysUsersService;
	
	@Autowired
	private SysAuthoritiesService sysAuthoritiesService;
	
	//登陆验证时，通过username获取用户的所有权限信息，  
    //并返回User放到spring的全局缓存SecurityContextHolder中，以供授权器使用
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		/*Map<String,Object> map = new HashMap<String,Object>(); 
		map.put("userAccount", username);
		List<SysUsers> userList = sysUsersService.findSysUsersListByAccount(map);//根据用户帐号查找用户		
		if(userList == null || userList.size() == 0){
			throw new UsernameNotFoundException("USERNOTFOUND"); 
		}
		SysUsers sysUser = userList.get(0);*/
		User user = null;		
		List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();//存入用户权限（角色）
		
		SysUsers sysUser = sysUsersService.findOneSysUsersByAccount(username);				
		List<?> userAuthoritiesList = sysAuthoritiesService.findUserAuthoritiesByUseraccount(username);//根据用户账号查找用户权限
		if(userAuthoritiesList != null ){
			Iterator<?> ito = userAuthoritiesList.iterator();
			while(ito.hasNext()){
				@SuppressWarnings("unchecked")
				Map<String,Object> userAuthoritiesmap =(Map<String, Object>) ito.next();
				String userAuthority = String.valueOf(userAuthoritiesmap.get("role_id"));
				
				auths.add(new SimpleGrantedAuthority(userAuthority));
			}					
			user = new User(username, sysUser.getUser_password(), true, true, true, true, auths);		
		}
		
		return user;//返回用户信息，会去DaoAuthenticationProvider该类下的additionalAuthenticationChecks方法去较验登陆的用户名和密码
	}

}

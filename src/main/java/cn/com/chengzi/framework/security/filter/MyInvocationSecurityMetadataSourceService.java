package cn.com.chengzi.framework.security.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import cn.com.chengzi.framework.security.service.SysAuthoritiesService;
import cn.com.chengzi.framework.security.util.AntUrlPathMatcher;


/** 
 * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。 
 * 此类在初始化时，应该取到所有资源及其对应角色的定义。 
 *  
 *  加载资源与权限的全部对应关系，并提供一个通过资源获取所有权限的方法
 **/ 
public class MyInvocationSecurityMetadataSourceService implements
		FilterInvocationSecurityMetadataSource , InitializingBean {		
	static Logger log = Logger.getLogger(MyInvocationSecurityMetadataSourceService.class.getName());
	
    private AntUrlPathMatcher antUrlPathMatcher;//IOC注入注入
	
    @Autowired
    private SysAuthoritiesService sysAuthoritiesService;
    
	public static Map<String, Collection<ConfigAttribute>> resourceMap = null;		 
	public static List<?> roleAuthoritiesUrlResources = null; //将所有的角色和url的对应关系缓存起来
	
	//构造方法，tomcat启动时实例化一次
	public MyInvocationSecurityMetadataSourceService(){
		//loadResourceDefine();
	}
	
	//加载所有url和权限（或角色）的对应关系
	/*private void loadResourceDefine(){				
		resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
		Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
		ConfigAttribute ca = new SecurityConfig("ROLE_USER");
		atts.add(ca);
		resourceMap.put("/framework/views/index.jsp",atts);
		
		Collection<ConfigAttribute> attsno = new ArrayList<ConfigAttribute>();
		ConfigAttribute cano = new SecurityConfig("ROLE_NO");
		attsno.add(cano);
		resourceMap.put("/other.jsp",attsno);				
	}*/
	
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {		
		return null;
	}

	//object 是要访问的url，返回这个url对应的所有权限（或角色）
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)throws IllegalArgumentException 
	{			
		//将参数转为url
		FilterInvocation filterInvocation = (FilterInvocation) object;
		String url = filterInvocation.getRequestUrl();						
		//ServletContext servletContext = filterInvocation.getHttpRequest().getSession().getServletContext();		
		int firstQuestionMarkIndex = url.indexOf("?");
		if(firstQuestionMarkIndex != -1){
			url = url.substring(0, firstQuestionMarkIndex);
		}
		
		@SuppressWarnings({ "unchecked", "unused" })
		Map<String, Object> urlAuthorities = 
				(Map<String,Object>)filterInvocation.getHttpRequest().getSession().getServletContext().getAttribute("urlAuthorities");				
		
		if(roleAuthoritiesUrlResources == null){
			log.info("-----------------------开始加载系统权限-----------------------------");
			roleAuthoritiesUrlResources = sysAuthoritiesService.findSysRolesAuthorities();//加载系统权限						
			log.info("-----------------------加载系统权限成功-----------------------------");
		}
						
		Set<String> roles = new HashSet<String>();
		Iterator<?> sysRolesAuthoritiesUrlItor = (Iterator<?>) roleAuthoritiesUrlResources.iterator();
		while(sysRolesAuthoritiesUrlItor.hasNext()){
			@SuppressWarnings("unchecked")
			Map<String,Object> map = (Map<String, Object>) sysRolesAuthoritiesUrlItor.next();
			String authUrl = (String) map.get("authority_url");
			String role = String.valueOf(map.get("role_id"));				
						
			if(antUrlPathMatcher.pathMatchesUrl(authUrl, url)){
				roles.add(role);
			}
		}
				
		Collection<ConfigAttribute> configAttributeList = new ArrayList<ConfigAttribute>();
		for(String role:roles){
			ConfigAttribute configAttribute = new SecurityConfig(role);
			configAttributeList.add(configAttribute);
		}
		return configAttributeList;
	}

	@Override
	public boolean supports(Class<?> clazz) {		
		return FilterInvocation.class.isAssignableFrom(clazz);
	}
	
	//spring 初始化该类时首先执行些方法
	@Override
	public void afterPropertiesSet() throws Exception {
	    System.out.println("MyInvocationSecurityMetadataSourceService 初始化");
	}
	
	//get set
	public AntUrlPathMatcher getAntUrlPathMatcher() {
		return antUrlPathMatcher;
	}
	public void setAntUrlPathMatcher(AntUrlPathMatcher antUrlPathMatcher) {
		this.antUrlPathMatcher = antUrlPathMatcher;
	}
		 
}

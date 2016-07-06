package cn.com.chengzi.framework.security.filter;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

/**
 * 调用授权管理器AccessDecisionManager，这个授权管理器会通过spring的全局缓存SecurityContextHolder获取用户的权限信息，
 * 还会获取被拦截的url和被拦截url所需的全部权限，然后根据所配的策略（有：一票决定，一票否定，少数服从多数等），如果权限足够，则返回，
 * 权限不够则报错并调用权限不足页面
 * 
 * 通过登录用户的权限信息、资源、获取资源所需的权限来根据不同的授权策略来判断用户是否有权限访问资源。
 **/
public class MyAccessDecisionManager implements AccessDecisionManager {

	//检查用户是否够权限访问资源  
    //参数authentication是从spring的全局缓存SecurityContextHolder中拿到的(在用户登陆时根据用户名拿到的用户权限信息)，里面是用户的权限信息  
    //参数object是访问的url  
    //参数configAttributes访问的url所需的权限
	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes) throws AccessDeniedException,
			InsufficientAuthenticationException {
		if(configAttributes == null){ 
			return;
		}
		
		Iterator<ConfigAttribute> ite = configAttributes.iterator();
        while(ite.hasNext()){
        	ConfigAttribute ca = ite.next();
        	String needRole = ((SecurityConfig)ca).getAttribute();
        	for(GrantedAuthority ga : authentication.getAuthorities()){
        		if(needRole.equals(ga.getAuthority())){
        			return;
        		}
        	}
        }
      //注意：执行这里，后台是会抛异常的，但是界面会跳转到所配的access-denied-page页面
        throw new AccessDeniedException("当前用户没有权限！");
	}

	@Override
	public boolean supports(ConfigAttribute attribute) { 
		System.out.println(attribute);
		return true;
	}

	@Override
	public boolean supports(Class<?>clazz) {
		return true;
	}

}

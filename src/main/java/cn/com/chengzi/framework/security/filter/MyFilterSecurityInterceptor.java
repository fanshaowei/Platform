package cn.com.chengzi.framework.security.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation; 
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

/** 
 * 自定义拦截器，访问url时，会通过AbstractSecurityInterceptor拦截器拦截，
 * 其中会调用FilterInvocationSecurityMetadataSource的方法来获取被拦截url所需的全部权限
 * 
 * 首先，登陆后，每次访问资源都会被这个拦截器拦截，会执行doFilter这个方法，这个方法调用了invoke方法，
 * 其中fi断点显示是一个url，最重要的是beforeInvocation这个方法，
 * 它首先会调用MyInvocationSecurityMetadataSource类的getAttributes方法获取被拦截url所需的权限，
 * 在调用MyAccessDecisionManager类decide方法判断用户是否够权限。弄完这一切就会执行下一个拦截器。
 **/
public class MyFilterSecurityInterceptor extends AbstractSecurityInterceptor
    implements Filter{
	
	//配置文件注入
    private FilterInvocationSecurityMetadataSource securityMetadataSource;
	
    public FilterInvocationSecurityMetadataSource getSecurityMetadataSource(){
		return this.securityMetadataSource;
	}
    
    public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource newSource)  
    {   
        this.securityMetadataSource = newSource;   
    } 

    //filter 接口方法实现  	
    //登陆后，每次访问资源都通过这个拦截器拦截
  	@Override
  	public void doFilter(ServletRequest request, ServletResponse response,
  			FilterChain chain) throws IOException, ServletException {
  		FilterInvocation  fi = new FilterInvocation(request,response,chain);
  		invoke(fi);
  	}
  		
    //fi里面有一个被拦截的url  
    //里面调用MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法获取fi对应的所有权限  
    //再调用MyAccessDecisionManager的decide方法来校验用户的权限是否足够
  	public void invoke(FilterInvocation fi) throws IOException,ServletException{
  		InterceptorStatusToken token = super.beforeInvocation(fi);
  		try{
  			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
  		}finally{
  			super.afterInvocation(token, null); 
  		}
  	}
  	
  	@Override
  	public void destroy() {}
  	
  	@Override
  	public void init(FilterConfig arg0) throws ServletException {}
    
    
	//interceptor 接口方法实现
	@Override
	public Class<? extends Object> getSecureObjectClass() {
		return FilterInvocation.class;	
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;
	}		
    
}

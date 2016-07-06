package cn.com.chengzi.framework.common.cors;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.chengzi.framework.common.utils.CollectionUtil;
import cn.com.chengzi.framework.common.utils.StringUtil;


/**
 * 支持CORS跨域
 *  *CorsFilter 将从 web.xml 中读取相关 Filter 初始化参数，并将在处理 HTTP 请求时将这些参数写入对应的 CORS 响应头中，下面大致描述一下这些 CORS 响应头的意义：
 *Access-Control-Allow-Origin：允许访问的客户端域名，例如：http://web.xxx.com，若为 *，则表示从任意域都能访问，即不做任何限制。
 *Access-Control-Allow-Methods：允许访问的方法名，多个方法名用逗号分割，例如：GET,POST,PUT,DELETE,OPTIONS。
 *Access-Control-Allow-Credentials：是否允许请求带有验证信息，若要获取客户端域下的 cookie 时，需要将其设置为 true。
 *Access-Control-Allow-Headers：允许服务端访问的客户端请求头，多个请求头用逗号分割，例如：Content-Type。
 *Access-Control-Expose-Headers：允许客户端访问的服务端响应头，多个响应头用逗号分割。
 *
 * @author fanshaowei
 *
 */
public class CorsFilter implements Filter{
    private String allowOrigin;
    private String allowMethods;
    private String allowCredentials;
    private String allowHeaders;
    private String exposeHeaders;
    
	@Override
	public void destroy() {		
	}
	
	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse  response = (HttpServletResponse) res;		
		if(StringUtil.isNotEmpty(allowOrigin)){
			List<String> allowOriginList = Arrays.asList(allowOrigin.split(","));
			if(CollectionUtil.isNotEmpty(allowOriginList)){
				String currentOrigin = request.getHeader("Origin");
                if (allowOriginList.contains(currentOrigin)) {
                    response.setHeader("Access-Control-Allow-Origin", currentOrigin);
                }
			}
		}
		if(StringUtil.isNotEmpty(allowMethods)){
			response.setHeader("Access-Control-Allow-Methods", allowMethods);
		}
		if(StringUtil.isNotEmpty(allowCredentials)){
			response.setHeader("Access-Control-Allow-Credentials", allowCredentials);
		}
		if(StringUtil.isNotEmpty(allowHeaders)){
			response.setHeader("Access-Control-Allow-Headers", allowHeaders);
		}
		if(StringUtil.isNotEmpty(exposeHeaders)){
			response.setHeader("Access-Control-Expose-Headers", exposeHeaders);
		}
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		allowOrigin = filterConfig.getInitParameter("allowOrigin");
		allowMethods = filterConfig.getInitParameter("allowMethods");
		allowCredentials = filterConfig.getInitParameter("allowCredentials");
		allowHeaders = filterConfig.getInitParameter("allowHeaders");
		exposeHeaders = filterConfig.getInitParameter(exposeHeaders);
	}
    
    
}

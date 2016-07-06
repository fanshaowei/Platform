package cn.com.chengzi.framework.common.generic;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.xml.ws.WebServiceContext;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class GenericWebContextImpl implements GenericWebContext {
    private WebApplicationContext webApplicationContext = null;
    			
	@Resource
	private WebServiceContext contex;
	
	@Override
	public WebApplicationContext getWebApplicationContext() {
		if(this.webApplicationContext != null)
			return this.webApplicationContext;
		
		ServletContext servletContext = (ServletContext)this.contex.getMessageContext().get("javax.xml.ws.servlet.context");
		this.webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		return this.webApplicationContext;
	}

}

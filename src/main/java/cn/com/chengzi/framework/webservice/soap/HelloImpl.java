package cn.com.chengzi.framework.webservice.soap;

import javax.jws.WebService;

import cn.com.chengzi.framework.common.generic.GenericWebContextImpl;

@WebService(endpointInterface="cn.com.chengzi.framework.webservice.soap.Hello")
public class HelloImpl extends GenericWebContextImpl implements Hello{
	
	
	@Override
	public String sayHello() {
		return "HELLO";
	}
    
}

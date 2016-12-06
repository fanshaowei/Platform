package cn.com.chengzi.framework.webservice.soap;

import javax.jws.WebService;

import cn.com.chengzi.framework.common.generic.GenericWebContextImpl;

/**
 * 
 * @author fanshaowei
 *
 *CXF SOAP协议接口例子，访问地址如下：http://localhost:8080/WechatApp/webservice/hello?wsdl
 */
@WebService(endpointInterface="cn.com.chengzi.framework.webservice.soap.Hello")
public class HelloImpl extends GenericWebContextImpl implements Hello{
	
	
	@Override
	public String sayHello() {
		return "HELLO";
	}
    
}

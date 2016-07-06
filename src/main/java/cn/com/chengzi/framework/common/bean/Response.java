package cn.com.chengzi.framework.common.bean;

/**
 * 为定义一个相通的JSON响应结构，其中包括两部分：元数据 与 返回值
 * {
 *     "meta":{
 *         "success":true,
 *         "message":"ok"
 *     },
 *     "data":...
 * }
 * 该类为映射以上JSON响应结构
 * @author fanshaowei
 *
 */
public class Response {
	
    private static final String OK = "ok";
    private static final String ERROR = "error";
    
    private Meta meta;
    private Object data;
    
    public Response success(){
    	this.meta = new Meta(true, OK);
    	return this;
    }
    
    public Response success(Object data){
    	this.meta = new Meta(true,OK);
    	this.data = data;
    	return this;
    }
   
    public Response failure(){
    	this.meta = new Meta(false, ERROR);
    	return this;
    }
    
    public Response failure(String message){
    	this.meta = new Meta(false, message);
    	return this;
    }
    
    public Meta getMeta(){
    	return meta;
    }
    
    public Object getData(){
    	return data;
    }
    
    public class Meta{
    	private boolean success;
    	private String message;
    	
    	public Meta(boolean success, String message){
    		this.success = success;
    		this.message = message;
    	}
    	
    	public boolean isSuccess(){
    		return success;
    	}
    	
    	public String getMessage(){
    		return message;
    	}
    }
}

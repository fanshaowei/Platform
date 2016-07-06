package cn.com.chengzi.framework.common.redis;

import java.util.ResourceBundle;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.telnet.TelnetClient;
import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
/**
 * jedis 实例化工具
 * @author fanshaowei
 *
 */
public class JedisUtils {
	private static final Log logger = LogFactory.getLog(JedisUtils.class);
    protected static final JedisUtils jedisUtil = new JedisUtils();
    protected static boolean jedisUsed = false;
    protected static JedisPool pool;    
    
    static{
    	logger.info("--------------------初始化Redis配置-------------------------");
    	
    	ResourceBundle bundle = ResourceBundle.getBundle("redis");
    	if(bundle == null){
    		throw new IllegalArgumentException("[redis.properties] is not found!");
    	}
    	
    	JedisPoolConfig config = new JedisPoolConfig();
    	
    	config.setMaxTotal(Integer.valueOf(bundle.getString("redis.pool.maxTotal")).intValue());
    	config.setMaxIdle(Integer.valueOf(bundle.getString("redis.pool.maxIdle")).intValue());
    	config.setMaxWaitMillis(Long.valueOf(bundle.getString("redis.pool.maxWaitMillis")).longValue());
    	config.setTestOnBorrow(Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow")).booleanValue());
    	config.setTestOnReturn(Boolean.valueOf(bundle.getString("redis.pool.testOnReturn")).booleanValue());
    	
    	TelnetClient telnet = new TelnetClient();
    	telnet.setConnectTimeout(5000);
    	try{
    		telnet.connect(bundle.getString("redis.ip"), Integer.parseInt(bundle.getString("redis.port")));
    		telnet.disconnect();
    		jedisUsed = true;
    		
    		pool = new JedisPool(config , bundle.getString("redis.ip"));
    		
    		logger.info("--------------------成功连接Redis服务器-------------------------");
    	}catch(Exception localException){
    		
    	}
    }
    
    public static JedisUtils getInstance(){
    	return jedisUtil;
    }
    
    public JedisPool getPool(){
    	return pool;
    }
    
    public Jedis getJedis(){
    	return (Jedis)pool.getResource();
    }
    
    public void returnJedis(Jedis jedis){
    	if(jedis != null){
    		jedis.close();
    	}
    }
    
    public boolean used(){
    	return jedisUsed;
    }
    
}

package cn.com.chengzi.framework.security.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.support.WebApplicationContextUtils;

import redis.clients.jedis.Jedis;

import cn.com.chengzi.framework.common.redis.JedisUtils;
import cn.com.chengzi.framework.security.service.SysUserService;

public class RedisServlet implements ServletContextListener{
	private static final Log logger = LogFactory.getLog(RedisServlet.class);
    
	@Autowired
	StringRedisTemplate redisTemplate;	
	
	@Autowired
	SysUserService sysUserService;
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {	
		JedisUtils jdu = JedisUtils.getInstance();
		if(!jdu.used()){
			logger.error("--------------------未启动redis服务,初始化redis连接失败-------------------------");
			return;
		}
		
		Jedis jedis = null;
		try{
			jedis = jdu.getJedis();
			if(jedis.hlen("hashUser") > 0){
				jedis.del("hashUser");
				logger.info("删除缓存数据成功!");
			}
		}catch(Exception e){
			logger.error("删除缓存数据失败!");
		}finally{
			if(jedis != null)
				jdu.returnJedis(jedis);
		}
	}
	

	@Override
	public void contextInitialized(ServletContextEvent sce) {			
		JedisUtils jdu = JedisUtils.getInstance();
		if(!jdu.used()){
			logger.error("--------------------未启动redis服务,初始化redis连接失败-------------------------");
			return;
		}
		//测试插入缓存数据		
		JdbcTemplate jdbcTemplate = (JdbcTemplate) WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext()).getBean("jdbcTemplate");		
		List<Map<String, Object>> userList = jdbcTemplate.queryForList("select * from sys_user");
		
		Jedis jedis = null;
		try{
			jedis = jdu.getJedis();//获取jedis对象
			
			SimpleDateFormat dfs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			String date1 = dfs.format(new Date());
			
			for(Map<String,Object> mapUser : userList){
				String userId = mapUser.get("userId").toString();			
				jedis.hset("hashUser","user_"+userId,mapUser.toString());				
			}
			
			String date2 = dfs.format(new Date());
			System.out.println(date2 +","+ date1);			
			
			System.out.println(jedis.hget("hashUser", "user_20"));					
			
			logger.info("缓存写入成功!");
		}catch(Exception e){
			logger.error("缓存写入失败!");
			e.printStackTrace();
		}finally{
			jdu.returnJedis(jedis);
		}
	}
    
}

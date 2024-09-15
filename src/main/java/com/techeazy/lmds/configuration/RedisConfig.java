//package com.techeazy.lmds.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
//
//@Configuration
//@EnableRedisRepositories
//public class RedisConfig {
//	
//	@Bean
//	public JedisConnectionFactory connectionFactory() {
//		
//		RedisStandaloneConfiguration config= new RedisStandaloneConfiguration();
//		config.setHostName("localhost");
//		config.setPort(6379);
//		return new JedisConnectionFactory(config);
//		
//		
//	}
//
//}

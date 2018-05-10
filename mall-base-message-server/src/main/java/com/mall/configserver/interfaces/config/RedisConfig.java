package com.mall.actuator.interfaces.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 该配置已被废弃
 */
@Deprecated
//@Configuration
public class RedisConfig {

    @Bean(name = "jedisPoolConfig")
    @ConfigurationProperties(prefix = "redis.pool")
    JedisPoolConfig jedisPoolConfig(){
        return new JedisPoolConfig();
    }

    @Bean(name = "jedisConnectionFactory")
    @RefreshScope  //配置变更，自动更新
    JedisConnectionFactory jedisConnectionFactory(@Qualifier("jedisPoolConfig") JedisPoolConfig jedisPoolConfig,
                                                  @Value("${redis.host}") String host,
                                                  @Value("${redis.port}") int port,
                                                  @Value("${redis.timeout}") int timeout){
        final JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName(host);
        jedisConnectionFactory.setPort(port);
        jedisConnectionFactory.setTimeout(timeout);
        jedisConnectionFactory.setUsePool(true);
        jedisConnectionFactory.setPoolConfig(jedisPoolConfig);
        jedisConnectionFactory.setDatabase(12);   //设置dbindex

        jedisConnectionFactory.afterPropertiesSet();

        return jedisConnectionFactory;
    }

    @Bean
    @RefreshScope
    @Primary
    public JedisPool jedisPool(@Qualifier("jedisPoolConfig") JedisPoolConfig jedisPoolConfig,
                               @Value("${redis.host}") String host,
                               @Value("${redis.port}") int port,
                               @Value("${redis.timeout}") int timeout){
        return new JedisPool(jedisPoolConfig,host,port,timeout);
    }

    @Bean(name = "stringRedisTemplate")
    @Primary
    @RefreshScope
    StringRedisTemplate stringRedisTemplate(@Qualifier("jedisConnectionFactory") JedisConnectionFactory jedisConnectionFactory,
                                            @Qualifier("genericJackson2JsonRedisSerializer") GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer){
        final StringRedisTemplate template = new StringRedisTemplate();

        template.setConnectionFactory(jedisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(genericJackson2JsonRedisSerializer);
        template.setValueSerializer(genericJackson2JsonRedisSerializer);

        return template;
    }

    @Bean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(
            RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setHashValueSerializer(genericJackson2JsonRedisSerializer());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(genericJackson2JsonRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }

    @Bean(name = "genericJackson2JsonRedisSerializer")
    public GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer() {
        return new GenericJackson2JsonRedisSerializer();
    }


}

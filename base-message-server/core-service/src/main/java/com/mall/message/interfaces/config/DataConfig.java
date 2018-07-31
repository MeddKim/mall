package com.mall.message.interfaces.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class DataConfig {

//    @Bean(name = "stringRedisTemplate")
//    @Primary
//    @RefreshScope
//    StringRedisTemplate stringRedisTemplate(RedisConnectionFactory jedisConnectionFactory,
//                                            @Qualifier("genericJackson2JsonRedisSerializer") GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer){
//        final StringRedisTemplate template = new StringRedisTemplate();
//
//        template.setConnectionFactory(jedisConnectionFactory);
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setHashValueSerializer(genericJackson2JsonRedisSerializer);
//        template.setValueSerializer(genericJackson2JsonRedisSerializer);
//
//        return template;
//    }

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

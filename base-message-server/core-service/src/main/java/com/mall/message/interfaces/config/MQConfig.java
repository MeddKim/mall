package com.mall.message.interfaces.config;

import com.mall.core.domain.utils.MQConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class MQConfig {

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }


    /**************************简单配置，可以集中式的管理************************************/
//    @Bean
//    public List<Exchange> exchanges(){
//        return Arrays.asList(new FanoutExchange(MQConstant.MSG_FANOUT_EXCHANGE),
//                new DirectExchange(MQConstant.MSG_DIRECT_EXCHANGE));
//    }
//    @Bean
//    public List<Queue> queues(){
//        return Arrays.asList(new Queue(MQConstant.MSG_FANOUT_QUEUE,true),
//                new Queue(MQConstant.MSG_DIRECT_QUEUE));
//    }
//    @Bean
//    public List<Binding> bindings(){
//        return Arrays.asList(new Binding(MQConstant.MSG_FANOUT_QUEUE,Binding.DestinationType.QUEUE,MQConstant.MSG_FANOUT_EXCHANGE,"",null),
//                new Binding(MQConstant.MSG_DIRECT_QUEUE,Binding.DestinationType.QUEUE,MQConstant.MSG_DIRECT_EXCHANGE,"",null));
//    }
    /*****************************************************************/


    @Bean(name = MQConstant.MSG_FANOUT_EXCHANGE)
    public FanoutExchange msgFantouExchange(){
        return new FanoutExchange(MQConstant.MSG_FANOUT_EXCHANGE);
    }

    @Bean(name = MQConstant.MSG_FANOUT_QUEUE)
    public Queue msgQueue(){
        return new Queue(MQConstant.MSG_FANOUT_QUEUE);
    }

    /**
     * 延迟队列，5分钟后消息发出
     * @return
     */
    @Bean(name = MQConstant.MSG_FANOUT_DELAY_QUEUE)
    public Queue msgDelayQueue(){
        final Map<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", (long) 5 * 60 * 1000L); //单位毫秒
        args.put("x-dead-letter-exchange", MQConstant.MSG_FANOUT_DELAY_QUEUE); //出现dead letter后将dead letter重新发送到指定的exchange
        args.put("x-dead-letter-routing-key", ""); //出现dead letter之后将dead letter重新按照指定的routing-key发送
        return new Queue(MQConstant.MSG_FANOUT_DELAY_QUEUE,true,false,false,args);
    }

    @Bean
    public Binding msgBinding(@Qualifier(MQConstant.MSG_FANOUT_QUEUE) Queue msgQueue,
                              @Qualifier(MQConstant.MSG_FANOUT_EXCHANGE) FanoutExchange msgExchange){
        return BindingBuilder.bind(msgQueue).to(msgExchange);
    }

    @Bean
    public Binding msgDelayBinding(@Qualifier(MQConstant.MSG_FANOUT_DELAY_QUEUE) Queue msgQueue,
                              @Qualifier(MQConstant.MSG_FANOUT_EXCHANGE) FanoutExchange msgExchange){
        return BindingBuilder.bind(msgQueue).to(msgExchange);
    }
}

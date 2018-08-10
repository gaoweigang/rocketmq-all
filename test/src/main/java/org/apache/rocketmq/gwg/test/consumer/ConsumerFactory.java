package org.apache.rocketmq.gwg.test.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;

public class ConsumerFactory {
	
	//private static DefaultMQPushConsumer  consumer = new DefaultMQPushConsumer("ConsumerGroupName");  
	private static DefaultMQPushConsumer  consumer = null;  
      
    private ConsumerFactory(){  
          
    }  
      
    public static DefaultMQPushConsumer  getDefaultMQPushConsumer(){  
        if(consumer == null){  
        	synchronized (ConsumerFactory.class) {
				if(consumer == null){
					consumer = new DefaultMQPushConsumer("gaoweigang");
					consumer.setNamesrvAddr("192.168.22.225:9876");//RocketMQ服务的地址  
					/**
					 * 设置Consumer第一次启动是从队列头部开始消费还是队列尾部开始消费
					 * 如果非第一次启动，那么按上次消费的位置继续消费
					 */
		            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);  
				}
			}
        }  
        return consumer;  
    }  

}

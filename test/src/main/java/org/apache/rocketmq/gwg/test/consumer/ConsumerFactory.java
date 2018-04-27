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
		            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);  
				}
			}
        }  
        return consumer;  
    }  

}

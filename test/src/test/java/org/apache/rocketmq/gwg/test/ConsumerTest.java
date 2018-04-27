package org.apache.rocketmq.gwg.test;

import java.util.List;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.gwg.test.consumer.ConsumerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ConsumerTest {
	 private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerTest.class);  
     
	    public static void main(String[] args) {  
	    	LOGGER.info("===========开始接受消息===============");
	        receiveMsg();  
	    }  
	  
	    // 消费者接受消息  
	    public static void receiveMsg() {  
	        // 获取消息消费者  
	        DefaultMQPushConsumer consumer = ConsumerFactory.getDefaultMQPushConsumer();  
	  
	        // 订阅主题  
	        try {  
	            consumer.subscribe("TopicTest1", "*");  
	            consumer.setConsumerGroup("ConsumerGroupName");//设置消费组  
	            consumer.registerMessageListener(new MessageListenerConcurrently() {  
	  
	                /** 
	                 * 默认msgs里只有一条消息，可以通过设置consumerMessageBatchMaxSize参数来批量接受消息 
	                 */  
	                public ConsumeConcurrentlyStatus consumeMessage(  
	                        List<MessageExt> msgs,  
	                        ConsumeConcurrentlyContext context) {  
	  
	                    LOGGER.info(Thread.currentThread().getName()+" , Receive new Messages： "+msgs.size());  
	                    MessageExt msg = msgs.get(0);  
	                    System.out.println("*******************************");
	                    if (msg.getTopic().equals("TopicTest1")) {  
	                        // 执行TopicTest1的消费逻辑  
	                        if (msg.getTags() != null  
	                                && msg.getTags().equals("TagA")) {  
	                            // 执行TagA的消费  
	                            LOGGER.info(new String(msg.getBody()));  
	                        } else if (msg.getTags() != null  
	                                && msg.getTags().equals("TagB")) {  
	                            // 执行TagB的消费  
	                        } else if (msg.getTags() != null  
	                                && msg.getTags().equals("TagC")) {  
	                            // 执行TagC的消费  
	                        }  
	                    } else if (msg.getTopic().equals("TopicTest2")) {  
	                        // 执行TopicTest2的消费逻辑  
	                    }  
	  
	                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;  
	                }  
	            });  
	            // Consumer对象在使用之前必须要调用start  
	            LOGGER.info("Consumer started .....");
	            consumer.start();  
	  
	        } catch (MQClientException e) {  
	  
	            e.printStackTrace();  
	        }  
	    }  
}

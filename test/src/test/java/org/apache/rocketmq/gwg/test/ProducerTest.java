package org.apache.rocketmq.gwg.test;

import org.apache.log4j.Logger;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.gwg.test.producer.ProducerFactory;
import org.apache.rocketmq.remoting.exception.RemotingException;

public class ProducerTest {
	private static final Logger LOGGER = Logger.getLogger(ProducerTest.class);  
    
    public static void main(String[] args) {  
        sendMsg();  
    }  
      
    //生产者发送消息  
    public static void sendMsg(){  
        //获取消息生产者  
        DefaultMQProducer producer = ProducerFactory.getDefaultMQProducer();  
          
        for(int i = 0; i < 2000 ;i++){  
            Message msg = new Message("TopicTest1",   //topic  
                                      "TagA",         //tag  
                                      "OrderIDOO"+i,  //key  
                                      ("Hello MetaQ"+i).getBytes()); //body  
              
            SendResult sendResult;  
            try {  
                sendResult = producer.send(msg);  
                System.out.println("*******: "+sendResult.getMsgId());
            } catch (MQClientException e) {  
                e.printStackTrace();  
            } catch (RemotingException e) {  
                e.printStackTrace();  
            } catch (MQBrokerException e) {  
                e.printStackTrace();  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
        producer.shutdown();  
    }  
}

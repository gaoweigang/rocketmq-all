package org.apache.rocketmq.gwg.test.producer;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;

public class ProducerFactory {
	// 使用你的账号构建一个客户端实例来访问DefaultMQProducer
	private static DefaultMQProducer producer = null;

	private ProducerFactory() {

	}

	public static DefaultMQProducer getDefaultMQProducer() {
		if (producer == null) {
			synchronized (ProducerFactory.class) {
				if (producer == null) {
					producer = new DefaultMQProducer("ProducerGroupName-gaoweigang");
					producer.setNamesrvAddr("192.168.22.225:9876");// RocketMQ服务的地址
					try {
						producer.start();
					} catch (MQClientException e) {
						e.printStackTrace();
					}
				}
			}

		}
		return producer;

	}
}

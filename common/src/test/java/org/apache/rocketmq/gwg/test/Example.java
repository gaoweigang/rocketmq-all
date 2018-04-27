package org.apache.rocketmq.gwg.test;

import java.io.File;

import org.apache.rocketmq.common.MixAll;
import org.junit.Test;

public class Example {
	
	
	/**
	 * 
	 */
	@Test
	public void testOne(){
		//获取系统属性值，如果获取不到，则返回默认值
	    String rocketmqHome = System.getProperty(MixAll.ROCKETMQ_HOME_PROPERTY, System.getenv(MixAll.ROCKETMQ_HOME_ENV));
	    System.out.println("ROCKET_MQ : "+ rocketmqHome);
	    
	    String kvConfigPath = System.getProperty("user.home") + File.separator + "namesrv" + File.separator + "kvConfig.json";
	    System.out.println("kvConfigPath : "+kvConfigPath);

	}

}

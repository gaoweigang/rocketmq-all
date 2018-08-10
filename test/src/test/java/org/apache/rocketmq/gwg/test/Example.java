package org.apache.rocketmq.gwg.test;

import org.apache.rocketmq.common.MQVersion.Version;

public class Example {
	
	public static final int CURRENT_VERSION = Version.V3_0_0_SNAPSHOT.ordinal();
	
	public static void main(String[] args) {
		
		System.out.println(CURRENT_VERSION);
		
	}
	
}

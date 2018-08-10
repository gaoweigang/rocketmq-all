package org.system.faye.commonline;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.junit.Test;

public class Example {
	
	@Test
	public void testOptionExistsT() throws ParseException {
		String[] args = {"-t"};
		Options options = new Options();//我们想
		options.addOption("t", false, "display current time");
		options.addOption("ipconfig", false, "ip dispaly");
		CommandLineParser parser = new PosixParser();
		CommandLine cmd = parser.parse(options, args);
		if(cmd.hasOption("t")){
			System.out.println("存在选项t....."+cmd.getOptionValue("dir"));
		}else{
			System.out.println("不存在选项t.....");
		}
	}
	
	

}

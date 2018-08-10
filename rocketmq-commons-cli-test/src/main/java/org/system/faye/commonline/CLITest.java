package org.system.faye.commonline;

import java.io.File;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.junit.Test;

public class CLITest {
	@Test
	public void test() throws ParseException {
		// 模拟命令行参数
		String[] args = { "-dir", ".", "-t" };
		testParser(args);
	}

	public void testParser(String[] args) throws ParseException {
		Options options = new Options();
		options.addOption("dir", true, "root folder path.");
		options.addOption("t", false, "file last modify time.");

		CommandLineParser parser = new PosixParser();
		CommandLine cmd = parser.parse(options, args);
		if (cmd.hasOption("dir")) {
			File dir = new File(cmd.getOptionValue("dir"));
			if (dir.exists()) {
				System.out.println(dir.getAbsolutePath());
				if (cmd.hasOption("t")) {
					File[] files = dir.listFiles();
					if (files != null) {
						for (File file : files) {
							System.out.println(file.getName() + " " + file.lastModified());
						}
					}
				} else {
					String[] files = dir.list();
					if (files != null) {
						for (String file : files) {
							System.out.println(file);
						}
					}
				}
			} else {
				System.out.println(dir.getAbsolutePath() + " not exists.");
			}
		} else {
			System.out.println("not has dir option.");
		}
	}

}

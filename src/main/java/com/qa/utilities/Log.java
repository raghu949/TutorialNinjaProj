package com.qa.utilities;

import org.apache.log4j.Logger;

public class Log {
	
	//Initialize log4j logs
	public static Logger Log1=Logger.getLogger(Log.class.getName());
	public static void startTestCase(String sTestCaseName) {
		Log1.info("========================="+sTestCaseName+" TEST START=============");
	}
	public static void endTestCase(String sTestCaseName) {
		Log1.info("=================="+sTestCaseName+" ===========================");
	}
	public static void info(String message) {
		Log1.info(message);
	}
	 public static void warn(String message) {

		    Log1.warn(message);

			}

		 public static void error(String message) {

		    Log1.error(message);

			}

		 public static void fatal(String message) {

		    Log1.fatal(message);

			}

		 public static void debug(String message) {

		    Log1.debug(message);

			}
	

}

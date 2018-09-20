package logging;

import java.io.File;
import java.util.logging.LogManager;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

//import org.apache.*;
public class ProjectLog {

	 private static Logger Log = Logger.getLogger(ProjectLog.class.getName());//

	 
	 
	public static void startTestCase(String sTestCaseName)
	{
		//Configurator.setLevel("logging.ProjectLog", Level.ALL);
		Log.info("******************************************");
		Log.info("******************************************");
		Log.info("*****************"+sTestCaseName+"Started");
		Log.info("******************************************");
		
	}
	public static void endTestCase(String sTestCaseName){

		Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");
		Log.info("XXXXXXXXXXXXXXXXXXXXXXX"+sTestCaseName+" XXXXXXXXXXXXXXXXXXXXXX");

		Log.info("X");

		Log.info("X");

		Log.info("X");

		Log.info("X");

		}
	public static void info(String message) {

		Log.info(message);

		}

 public static void warn(String message) {

    Log.warn(message);
    
	}

 public static void error(String message) {

    Log.error(message);

	}

 public static void fatal(String message) {

    Log.fatal(message);

	}

 public static void debug(String message) {

    Log.debug(message);

	}

}

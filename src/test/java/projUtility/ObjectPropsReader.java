package projUtility;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ObjectPropsReader {
	private static Properties props;
	public ObjectPropsReader(String pathForPropsFile) throws IOException {
		FileReader file = new FileReader(pathForPropsFile);
		props = new Properties();
		props.load(file);
	}
	// get chrome driver location
	public static String get_ChromeDriverLoc() {
		// System.out.println(props.getProperty("chromeWebDriverLoc"));
		return props.getProperty("chromeWebDriverLoc");
	}

	// get base url
	public static String get_baseUrl() {
		return props.getProperty("baseUrl");
	}

	public static String get_EdgeDriverLoc() {
		return props.getProperty("edgeWebDriverLoc");
	}
	public static String get_usersExcelLocation() {
		System.out.println("path::"+props.getProperty("usersExcelLocation"));
		return props.getProperty("usersExcelLocation");
	}
	
}

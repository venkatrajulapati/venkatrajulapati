package com.app.libs.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonUtils {
	
	public static Properties get_propertyFileData(String file_path) throws IOException {
		Properties prop = new Properties();
		File f = new File(file_path);
		FileInputStream iStream = new FileInputStream(f);
		prop.load(iStream);
		return prop;
	}

}

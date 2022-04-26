package pages;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromConfigExample {

		Properties prop;
		public ReadDataFromConfigExample() throws Exception{
			FileInputStream fis = new FileInputStream("./testData2.properties");
			prop = new Properties();
			prop.load(fis);
		}
		public String getAppURL() {
			return prop.getProperty("appURL");
		}
		public String getUserName() {
			return prop.getProperty("adminUserName");
		}
		public String getPassword() {
			return prop.getProperty("adminPassword");
		}
		public String getInvalidPassword() {
			return prop.getProperty("wrongPassword");
		}
		
		
}

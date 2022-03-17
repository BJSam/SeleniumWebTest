package projUtility;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;

public class LaunchBrowser {
	public static WebDriver driver=null;

	public LaunchBrowser() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", ObjectPropsReader.get_ChromeDriverLoc());
		System.setProperty("webdriver.edge.driver", ObjectPropsReader.get_EdgeDriverLoc());
		System.out.println("Select your browser option:\n 1.Chrome \n 2.Edge");
	if(driver == null) {
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		sc.close();
		switch (option) {
		case 1:
			driver = new ChromeDriver();
			break;
		case 2:
			driver = new EdgeDriver();
			break;
		default:
			driver = new ChromeDriver();
		}
	}
		driver.get(ObjectPropsReader.get_baseUrl());
	}
	public void TakeErrorScreanShort(WebDriver driver, String ScreenShortName) throws IOException {
		  TakesScreenshot ts=(TakesScreenshot)driver;		  
			// Call method to capture screenshot
			File source=ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(source, new File("C:\\Users\\sam\\eclipse-workspace\\WebToursTest\\screenshorts\\"+ScreenShortName+".png"));
			System.out.println("Screenshot taken");
}
}


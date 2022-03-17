package pageTests;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.RegistrationPage;
import projUtility.LaunchBrowser;
import projUtility.ObjectPropsReader;
import projUtility.ExcelIO;

@Listeners(projUtility.TestNgLisners.class)
public class MainTests {
	WebDriver driver;

	@BeforeSuite
	public void setUpForTest() throws IOException {
		new ObjectPropsReader("C:\\Users\\sam\\eclipse-workspace\\WebToursTest\\assets\\dataObjects\\selenium_object.properties");
		new LaunchBrowser();
		driver = LaunchBrowser.driver;
	}

	@Test(dataProvider = "usersData")
	public void userRegistrationTest(Object[] user) throws IOException {
		
		RegistrationPage reg = new RegistrationPage();
		reg.UserRegistration(user[0].toString(), user[1].toString(), user[2].toString(), user[3].toString(),
				user[4].toString());
	//	driver.close();
	}

	@DataProvider()
	public Iterator<Object[]> usersData() throws IOException {
		ExcelIO xlIO = new ExcelIO();
		List<Object[]> x = xlIO.getSheetDataAsMap(0);
		// System.out.println(x.get(0));
		return x.iterator();
	}

	@AfterSuite
	public void CleanUp() {
		driver.quit();
	}
}

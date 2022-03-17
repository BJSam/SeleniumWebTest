package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

import projUtility.LaunchBrowser;

public class RegistrationPage {
	WebDriver driver;
public RegistrationPage() {
	driver=LaunchBrowser.driver;
}

public void UserRegistration(String user, String pass, String full_name, String street, String city_zip_state) {
	driver.switchTo().defaultContent();
	 driver.switchTo().frame(1);
	    //  | selectFrame | index=1 |  | 
	 driver.switchTo().frame(1);
	//5 | click | register |  | 
	    driver.findElement(By.cssSelector("a:nth-child(4) > b")).click();
	    //  | clear user field | name=username |  | 
	    driver.findElement(By.name("username")).clear();
	    // | type | name=username | sam | 
	    driver.findElement(By.name("username")).sendKeys(user);
	    // | click | name=lastName |  | 
	    driver.findElement(By.name("lastName")).clear();
	    //  | type | name=lastName | sam | 
	    driver.findElement(By.name("lastName")).sendKeys(full_name.split(" ")[1]);
	    //  | click | name=firstName |  | 
	    driver.findElement(By.name("firstName")).clear();
	    //  | type | name=firstName | sam | 
	    driver.findElement(By.name("firstName")).sendKeys(full_name.split(" ")[0]);
	    //  | click | name=address1 |  | 
	    driver.findElement(By.name("address1")).clear();
	    //  | type | name=address1 | street 2233 | 
	    driver.findElement(By.name("address1")).sendKeys(street);
	    //  | click | name=address2 |  | 
	    driver.findElement(By.name("address2")).clear();
	    //  | type | name=address2 | 588745 | 
	    driver.findElement(By.name("address2")).sendKeys(city_zip_state);
	    //  | click | name=password |  | 
	    driver.findElement(By.name("password")).clear();
	    //  | type | name=password | sam | 
	    driver.findElement(By.name("password")).sendKeys("sam");
	    //  | click | name=passwordConfirm |  | 
	    driver.findElement(By.name("passwordConfirm")).clear();
	    //  | type | name=passwordConfirm | sam | 
	    driver.findElement(By.name("passwordConfirm")).sendKeys("sam");
	    // | click | name=register |  | 
	    driver.findElement(By.name("register")).click();
	   String welcomeMsg= driver.findElement(By.cssSelector("blockquote")).getText();
		    // | assertText | css=b | sam | 
	    Assert.assertTrue(welcomeMsg.contains("Thank you,"));
	    Reporter.log("Conformation message for registration of user::"+user+" and pass::"+pass+"is :::"+welcomeMsg);
	    //  | click | css=img |  | 
	    driver.findElement(By.cssSelector("img")).click();
	    //  selectFrame | relative=parent |  | 
	    driver.switchTo().defaultContent();
	    
	    // | selectFrame | index=0 |  | 
	    driver.switchTo().frame(1);
	    driver.switchTo().frame(0);
	    // | click | css=a:nth-child(7) > img |  | 
	    driver.findElement(By.cssSelector("a:nth-child(7) > img")).click();
}
}

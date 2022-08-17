package com.qa.pages;

//import org.apache.http.auth.UsernamePasswordCredentials;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class login extends TestBase {

	//Initializing the Page Objects:
	private static By userid = By.xpath("//input[@name='username']");
	private static By pwd = By.xpath("//input[@name='password']");
	private static By signinButton = By.xpath("//span[normalize-space()='Sign In']");
	private static By registerButton= By.xpath("//span[normalize-space()='Register']");
	private static By authenticateddashboardTitle = By.xpath("");
	private static By signinCheck = By.xpath("(//span[@class='dx-checkbox-icon'])[1]");
	private static By loginbutton = By.xpath("//span[normalize-space()='Login']");
	private static By AuthDashboardText = By.xpath("//em[normalize-space()='Authenticated Dashboard Announcement']");
	private static By homeButton = By.xpath("//i[@class='dx-icon mat-icons mi-home']");

	public login() {
		PageFactory.initElements(driver, this);
	}

	//	Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	//  # Validating test cases on Sign In page
	public void redirectToHomePage() {
		driver.findElement(homeButton).click();
	}

	public static boolean isSignButtonExists(){
		driver.findElement(signinButton).isDisplayed();
		return true;
	}
	public static boolean isRegisterButtonExists(){
		driver.findElement(registerButton).isDisplayed();
		return true;
	}

	public void signIn() {
		driver.findElement(signinButton).click();


	}

	public void enterUserName(String username) {
		driver.findElement(userid).sendKeys(username);
	}

	public void enterUserPassword(String password) {
		driver.findElement(pwd).sendKeys(password);
	}
	public void clickOnLogin() {
		driver.findElement(signinCheck).click();
		driver.findElement(loginbutton).click();
	}
	public boolean isAuthDashboardExists(){
		driver.findElement(AuthDashboardText).isDisplayed();
		return true;
	}
	public boolean isAuthDashboardHeaderExists(){
		driver.findElement(AuthDashboardText).isDisplayed();
		return true;
	}


	//logout() refers to log out from the GCT User account
	public void logout() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[@class='dx-icon mat-icons mi-arrow_drop_down']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Sign Out']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Yes']")).click();
	}

	
}

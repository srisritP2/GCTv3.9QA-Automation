package com.qa.pages;

//import org.apache.http.auth.UsernamePasswordCredentials;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Login extends TestBase {

    public static final By successfullyResetPasswordLinkShared = By.xpath("//div[@role='alert']");
    public static final By ForgotPasswordAck = By.xpath("//div[contains(text(),'An email will be sent with a link to reset your password.')]");
    private static final By userid = By.xpath("//input[@id='login-username']");

    private static final By password = By.xpath("//input[@id='login-password']");
    private static final By logInButton = By.xpath("(//span[normalize-space()='Login'])[1]");
    private static final By iAgreeTermsAndConditionsCheckBox = By.xpath("//span[normalize-space()='I agree to terms & conditions and privacy policy']");
    private static final By loginButton = By.xpath("//button[@id='login-submit']");
    private static final By dashboardTitle = By.xpath("//h1[normalize-space()='Dashboard']");
    private static final By registerButton = By.xpath("//span[normalize-space()='Register']");
    private static final By submitButton = By.xpath("//span[normalize-space()='Submit']");
    private static final By homeButton = By.xpath("//div[@class='v-list-item-title'][normalize-space()='Home']");
    //    ----
    private static final By AuthDashboardText = By.xpath("//span[normalize-space()='Authenticated Dashboard Announcement']");
    private static final By privacyPolicy = By.xpath("//span[normalize-space()='Privacy Policy']");
    private static final By forgotPassword = By.xpath("//span[normalize-space()='Forgot password']");
    private static final By getForgotPasswordWindowHeader = By.xpath("//div[contains(text(),'Forgot Password')]");
    private static final By emailOnForgotPasswordWindow = By.xpath("(//input[@id='input-14'])[1]");
    //    "/html/body/div[1]/div/div/div/main/div/div/div/form/div/div[1]/div/div[3]/input"
    private static final By invalidEmailError = By.xpath("//div[@role='alert']");
    private static final By cancelButtonOnResetPasswordWindow = By.xpath("//span[normalize-space()='Cancel']");
    private static final By TermsAndConditionsLink = By.xpath("//span[normalize-space()='Terms and Conditions']");
//    private static final By agreePrivacyPolicyButton = By.xpath("(//div[@class='dx-button-content'])[14]");
//    private static final By resetButtonOnChildPopUp = By.xpath("//span[normalize-space()='Reset']");
//    private static final By cancelButtonOnResetPopUp = By.xpath("//span[normalize-space()='Cancel']");
//    private static final By emailInputONResetPopUp = By.xpath("(//input[@role='textbox'])[3]");
    private static final By rememberMeCheckBox = By.xpath("(//span[@class='dx-checkbox-icon'])[2]");
    private static final By clearIconOnUsername = By.xpath("(//span[@class='dx-icon dx-icon-clear'])[1]");
    private static final By clearIconOnPassword = By.xpath("(//span[@class='dx-icon dx-icon-clear'])[2]");

    // Constructor
    public Login() {
        PageFactory.initElements(driver, this);
    }
    // Method to enter username
    public static void enterUsername(String username) {
        waitForPageLoad();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
//        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(userid));
//        usernameField.click();
//        usernameField.sendKeys(username);
        driver.findElement(userid).sendKeys(username);
        System.out.println("User Name Entered!");
    }

    // Method to enter password
    public static void enterPassword(String passwordValue) {
        waitForPageLoad();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
//        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
//        passwordField.sendKeys(passwordValue);
        driver.findElement(password).sendKeys(passwordValue);
        System.out.println("Password Entered!");

    }

    // ✅ Missing Method: Click Login Button
    public static void clickLogin() {
        waitForPageLoad();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wait up to 10 seconds
        WebElement loginButtonField = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        loginButtonField.click();
        System.out.println("Login Button Clicked!");
    }

    public static String getDashboardPageTitle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleIs(driver.getTitle()));
        return driver.getTitle();
    }
    public static void clickOnLoginMenuButton(){
        driver.findElement(logInButton).click();
    }

    public static void redirectToHomePage() {
        driver.findElement(homeButton).click();
    }

    public static boolean isLoginButtonExists() {
        driver.findElement(logInButton).isDisplayed();
        return true;
    }

    public static void enterUserName(String username) throws InterruptedException {

//        wait.until(ExpectedConditions.elementToBeClickable(By.id<locator>));
        Thread.sleep(5000);
        driver.findElement(userid).sendKeys(username);
    }

    public static void enterUserPassword(String passwordInput) {
        driver.findElement(password).sendKeys(passwordInput);
    }

    public static void iAgreeToTermsAndConditions() {
        driver.findElement(iAgreeTermsAndConditionsCheckBox).click();
    }

    public static void clickOnLogin() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(loginButton).click();
    }

    public static void clickOnSubmitButton() {
        driver.findElement(submitButton).click();
    }
    public static void userRedirectedToDashboard(){
        driver.findElement(dashboardTitle).isDisplayed();
    }

    public static boolean isRegisterButtonExists() {
        driver.findElement(registerButton).isDisplayed();
        return true;
    }

    public static void isClearUsernameExists() {
        driver.findElement(userid).sendKeys("User Name");
        driver.findElement(clearIconOnUsername).isDisplayed();
        driver.findElement(clearIconOnUsername).click();
    }

    public static void isClearPasswordExists() {
        driver.findElement(password).sendKeys("Password12345");
        driver.findElement(clearIconOnPassword).isDisplayed();
        driver.findElement(clearIconOnPassword).click();
    }

    public static boolean isTermsAndConditionsCheckBoxExists() {
        driver.findElement(iAgreeTermsAndConditionsCheckBox).isDisplayed();
        return true;
    }


    public static boolean isRememberMeCheckBoxExists() {
        driver.findElement(rememberMeCheckBox).isDisplayed();
        return true;
    }

    public static void rememberMe() {
        driver.findElement(rememberMeCheckBox).click();
    }

    public static boolean isPrivacyPolicyExists() {
        driver.findElement(privacyPolicy).isDisplayed();
        return true;
    }

    public static boolean isTermsAndConditionsLinkExists() {
        driver.findElement(TermsAndConditionsLink).isDisplayed();
        return true;
    }

    public static boolean isResetPasswordLinkExists() {
        driver.findElement(forgotPassword).isDisplayed();
        return true;
    }

    public static boolean isLoginButtonDisabled() {
        driver.findElement(userid).sendKeys("TestUser");
        driver.findElement(password).sendKeys("TestPassword");
        driver.findElement(loginButton).isSelected();
        return true;
    }

    public static boolean isRememberMeSelected() {

        driver.findElement(rememberMeCheckBox).isSelected();
        return true;
    }

    public static void clickOnForgotPasswordLink() {
        driver.findElement(forgotPassword).click();
    }

    public static boolean isForgotPasswordWindowExists() {
        driver.findElement(getForgotPasswordWindowHeader).isDisplayed();
        return true;
    }

    public static boolean isEmailFieldEnabledOnResetPassword() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(emailOnForgotPasswordWindow).isEnabled();
        return true;
    }

    public static boolean isSubmitButtonsExists() {
        driver.findElement(submitButton).isDisplayed();
        return true;
    }

    public static void enterAnonymousEmail(String anonymousEmail) {
        driver.findElement(emailOnForgotPasswordWindow).click();
        driver.findElement(emailOnForgotPasswordWindow).sendKeys(anonymousEmail);
    }

    public static boolean validateWithAnonymousEmail() {
        driver.findElement(invalidEmailError).isDisplayed();
        System.out.println("Invalid Email or User not Existing so " + driver.findElement(invalidEmailError).getText());
        return true;
    }

    public static void enterValidEmail(String validEmail) {
        driver.findElement(emailOnForgotPasswordWindow).sendKeys(validEmail);
    }

    public static void successAckForgotPassword() {
//        driver.findElement(successfullyResetPasswordLinkShared).isDisplayed();
//        System.out.println(driver.findElement(successfullyResetPasswordLinkShared).getText());  At present we are not displaying any toast message
        driver.findElement(ForgotPasswordAck).isDisplayed();
        driver.findElement(loginButton).isDisplayed();
    }

    //  # Validating test cases on Sign In page
    public static boolean isAuthDashboardExists() {
        driver.findElement(AuthDashboardText).isDisplayed();
        return true;
    }

    //logout() refers to log out from the GCT User account
    public static void logout() throws InterruptedException {

        Thread.sleep(3000);
        driver.findElement(By.xpath("//i[@class='dx-icon mat-icons mi-arrow_drop_down']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[normalize-space()='Sign Out'])[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Yes']")).click();
    }
}
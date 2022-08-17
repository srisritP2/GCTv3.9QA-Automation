package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class dashBoard extends TestBase {

    // 1. By Locators: OR
    private static By p2Logo = By.xpath("//img[@class='image']");
    private static By signInButton = By.xpath("//span[normalize-space()='Sign In']");
    private static By registerButton = By.xpath("//span[normalize-space()='Register']");
    private static By dashBoardText = By.xpath("//h1[normalize-space()='Dashboard Announcement Test unauthorized']");
    private static By menuButton = By.xpath("//i[@class='dx-icon mat-icons mi-menu']");

    private static By hWTButton = By.xpath("//span[normalize-space()='Homeowner Ticket']");



    // 2. Constructor of the page class:
    public dashBoard(WebDriver driver) {
        this.driver = driver;
    }



    // 3. page actions: features(behavior) of the page the form of methods:

    public String getDashboardPageTitle() throws InterruptedException {
        Thread.sleep(5000);
        return driver.getTitle();
    }
    public static boolean isP2LogoExist() throws InterruptedException {
        Thread.sleep(5000);
    return driver.findElement(p2Logo).isDisplayed();}
    public static boolean isSigninButtonExist() throws InterruptedException {
        Thread.sleep(5000);
        return driver.findElement(signInButton).isDisplayed();}
    public static boolean isRegisterButtonExist() { return driver.findElement(registerButton).isDisplayed();}
    public static boolean isDashboardTextExist() { return driver.findElement(dashBoardText).isDisplayed();}
    public static boolean isMenuButtonExist() { return driver.findElement(menuButton).isDisplayed();}


    public static String getHomePageOwnerTicketPageTitle() {
//    driver.findElement(menuButton).click();
    driver.findElement(hWTButton).click();
        System.out.println("Clicked on hwt option");

    return driver.getTitle();
    }
    public static boolean isHWToptionIsExist(){
        return  driver.findElement(hWTButton).isDisplayed();}

    }

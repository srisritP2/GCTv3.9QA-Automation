package com.qa.pages;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.awt.*;
import java.awt.event.KeyEvent;

public class aSmokeTesting {

        public static void main(String[] args) throws InterruptedException, AWTException {
            // TODO Auto-generated method stub
            WebDriver driver;
            System.setProperty("webdriver.chrome.driver", "E:\\Automation\\EclipseWorkSpace\\ARefJars\\drivers\\chromedriver.exe");
            driver = new ChromeDriver(); //launch chrome
            driver.get("https://geocalltest.progressivepartnering.com/ui/dashboard");
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            System.out.println("Browser launcher successfully");
            Thread.sleep(5000);

            String DahsboardTitle = driver.getTitle();
            System.out.println("Title:" + DahsboardTitle);


//            driver.findElement(By.xpath("//span[normalize-space()='Sign In']")).click();
//            driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
//            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("P2GcTest!2");
//            driver.findElement(By.xpath("(//span[@class='dx-checkbox-icon'])[1]")).click();
//            driver.findElement(By.xpath("//span[normalize-space()='Login']")).click();
//            System.out.println("GC Admin Logged in successfully");
//            Thread.sleep(5000);
//            driver.findElement(By.xpath("//span[normalize-space()='Ticket Search']")).click();
//            System.out.println("ts click");
//            driver.findElement(By.xpath("//dx-text-box[@class='ng-untouched ng-pristine ng-valid dx-show-invalid-badge dx-textbox dx-texteditor dx-show-clear-button dx-editor-outlined dx-texteditor-empty dx-widget']//input[@role='textbox']")).sendKeys("20222080001");
//
//            System.out.println("tno entered");
//            Thread.sleep(5000);
//            driver.findElement(By.xpath("//span[normalize-space()='Search']")).click();
//            Thread.sleep(10000);
//            System.out.println("ts button clicked");

            //logout
//        driver.findElement(By.xpath("//i[@class='dx-icon mat-icons mi-arrow_drop_down']")).click();
//        driver.findElement(By.xpath("//span[normalize-space()='Sign Out']")).click();
//        driver.findElement(By.xpath("//span[normalize-space()='Yes']")).click();


//
//            String ErrorMsgs = String.valueOf(driver.findElement(By.xpath("//div[@class='dx-overlay-wrapper dx-popup-wrapper dx-overlay-modal dx-overlay-shader']//div[@class='div-card']//div[1]")));
//            System.out.println("Error messages:"+ErrorMsgs);

//            driver.findElement(By.xpath(""))

            Thread.sleep(2000);
//            driver.findElement(By.xpath("//i[@class='dx-icon mat-icons mi-menu']")).click();
            driver.findElement(By.xpath("//span[normalize-space()='Homeowner Ticket']")).click();
            System.out.println("Alert 01");
            String HOTTitle = driver.getTitle();
            System.out.println(HOTTitle);


            //            driver.findElement(By.xpath("//div[normalize-space()='Welcome!']")).isDisplayed();

            Thread.sleep(2000);
            driver.findElement(By.xpath("/html[1]/body[1]/gc-core-app-root[1]/gc-core-root[1]/dx-drawer[1]/div[1]/div[2]/div[2]/div[1]/dx-scroll-view[1]/div[1]/div[1]/div[1]/div[2]/div[1]/gc-core-ticket-homeowner[1]/div[1]/div[1]/div[1]/dx-box[1]/div[1]/dxi-item[1]/dx-scroll-view[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/gc-core-client-ui-loop[1]/div[1]/dx-responsive-box[1]/div[1]/div[2]/dxi-item[1]/span[2]/gc-core-client-ui-loop[1]/div[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[2]/dxi-item[1]/dx-button[1]/div[1]/span[1]")).isDisplayed();
            driver.findElement(By.xpath("/html[1]/body[1]/gc-core-app-root[1]/gc-core-root[1]/dx-drawer[1]/div[1]/div[2]/div[2]/div[1]/dx-scroll-view[1]/div[1]/div[1]/div[1]/div[2]/div[1]/gc-core-ticket-homeowner[1]/div[1]/div[1]/div[1]/dx-box[1]/div[1]/dxi-item[1]/dx-scroll-view[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/gc-core-client-ui-loop[1]/div[1]/dx-responsive-box[1]/div[1]/div[2]/dxi-item[1]/span[2]/gc-core-client-ui-loop[1]/div[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[2]/dxi-item[1]/dx-button[1]/div[1]/span[1]")).click();
            driver.findElement(By.xpath("//dx-toolbar[@class='toolbar-resizing dx-toolbar dx-widget dx-visibility-change-handler dx-collection']")).isDisplayed();
            System.out.println("First, we need some information about you.\n" +
                    "Please enter your first and last name.\n");
            driver.findElement(By.xpath("(//input[@role='textbox'])[1]")).sendKeys("Srisri");
            driver.findElement(By.xpath("(//input[@role='textbox'])[2]")).sendKeys("Sherwin");
            driver.findElement(By.xpath("(//input[@role='textbox'])[3]")).sendKeys("502 Blue Ridge");
            driver.findElement(By.xpath("(//input[@role='textbox'])[4]")).sendKeys("Nashville");
//            driver.findElement(By.xpath("(//div[@class='dx-dropdowneditor-icon'])[1]")).click();

            driver.findElement(By.xpath("(//input[@role='combobox'])[1]")).click();
            driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]")).click();

            driver.findElement(By.xpath("(//input[@role='textbox'])[5]")).sendKeys("12345");
            driver.findElement(By.xpath("(//input[@role='textbox'])[6]")).sendKeys("srisri@p2.com");
//            WebElement element = driver.findElement(By.xpath("(//input[@role='textbox'])[7]"));
//            element.click();
//            element.sendKeys(String.valueOf("9493034647"));
            Thread.sleep(1000);
            System.out.println("Before phno");
            driver.findElement(By.xpath("(//input[@role='textbox'])[7]")).click();
            System.out.println("After phno click");
            driver.findElement(By.xpath("(//input[@role='textbox'])[7]")).sendKeys("9493034647");
            System.out.println("After phno enter");

            driver.findElement(By.xpath("(//span[contains(text(),'Next')])[2]")).click();
            driver.findElement(By.xpath("(//span[contains(text(),'Next')])[3]")).click();
//            driver.findElement(By.xpath("/html[1]/body[1]/gc-core-app-root[1]/gc-core-root[1]/dx-drawer[1]/div[1]/div[2]/div[2]/div[1]/dx-scroll-view[1]/div[1]/div[1]/div[1]/div[2]/div[1]/gc-core-ticket-homeowner[1]/div[1]/div[1]/div[4]/dx-box[1]/div[1]/dxi-item[1]/dx-scroll-view[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/gc-core-client-ui-loop[1]/div[1]/dx-responsive-box[1]/div[1]/div[38]/dxi-item[1]/span[2]/gc-core-client-ui-loop[1]/div[1]/dx-responsive-box[1]/div[1]/div[1]/div[1]/div[2]/dxi-item[1]/dx-button[1]/div[1]")).click();

            driver.findElement(By.xpath("(//span[contains(text(),'Next')])[4]")).click();
            driver.findElement(By.xpath("(//span[contains(text(),'Next')])[5]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("(//span[contains(text(),'Next')])[6]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("(//input[@role='textbox'])[13]")).sendKeys("Xray location");


            driver.findElement(By.xpath("(//span[contains(text(),'Next')])[7]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("(//textarea[@role='textbox'])[1]")).sendKeys("Jr House then 1st left and right corner");
            driver.findElement(By.xpath("(//span[contains(text(),'Next')])[8]")).click();
            driver.findElement(By.xpath("(//span[contains(text(),'Next')])[9]")).click();
            driver.findElement(By.xpath("(//textarea[@role='textbox'])[2]")).sendKeys("2");

            Thread.sleep(1000);

            driver.findElement(By.xpath("(//textarea[@role='textbox'])[3]")).sendKeys("Work Type! My garden");
            driver.findElement(By.xpath("(//span[contains(text(),'Next')])[10]")).click();
            driver.findElement(By.xpath("(//span[contains(text(),'Next')])[11]")).click();
            driver.findElement(By.xpath("(//span[contains(text(),'Next')])[12]")).click();
            driver.findElement(By.xpath("(//span[contains(text(),'No')])[4]")).click();
            driver.findElement(By.xpath("(//span[contains(text(),'No')])[5]")).click();
            driver.findElement(By.xpath("(//span[contains(text(),'Next')])[13]")).click();
            System.out.println("Alert 1");
            driver.findElement(By.xpath("(//input[@role='textbox'])[24]")).sendKeys("TN");

            WebElement scrollbar = driver.findElement(By.xpath("/html[1]/body[1]/gc-core-app-root[1]/gc-core-root[1]/dx-drawer[1]/div[1]/div[2]/div[2]/div[1]/dx-scroll-view[1]/div[1]/div[1]/div[1]/div[2]/div[1]/gc-core-ticket-homeowner[1]/div[1]/div[1]/div[14]/dx-box[1]/div[1]/dxi-item[1]/dx-scroll-view[1]/div[1]/div[1]/div[2]"));
            scrollbar.click();

            System.out.println("Scroll is enabled"+scrollbar.isEnabled());

//            JavascriptExecutor js = (JavascriptExecutor) driver;
//            js.executeScript("scroll(0,400)");

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

//            js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//            js.executeScript("window.scrollBy(0,250)", "");

            System.out.println("Alert 2");

            Thread.sleep(3000);
            driver.findElement(By.xpath("/html/body/gc-core-app-root/gc-core-root/dx-drawer/div/div[2]/div[2]/div/dx-scroll-view/div[1]/div/div[1]/div[2]/div/gc-core-ticket-homeowner/div/div/div[14]/dx-box/div/dxi-item/dx-scroll-view/div[1]/div/div[1]/div[2]/div/div/gc-core-client-ui-loop/div/dx-responsive-box/div/div[192]/dxi-item/dx-text-area/div/div[1]/textarea")).click();

            Thread.sleep(3000);
            System.out.println("Alert 3");
            driver.findElement(By.xpath("/html/body/gc-core-app-root/gc-core-root/dx-drawer/div/div[2]/div[2]/div/dx-scroll-view/div[1]/div/div[1]/div[2]/div/gc-core-ticket-homeowner/div/div/div[14]/dx-box/div/dxi-item/dx-scroll-view/div[1]/div/div[1]/div[2]/div/div/gc-core-client-ui-loop/div/dx-responsive-box/div/div[192]/dxi-item/dx-text-area/div/div[1]/textarea")).sendKeys("My Work Type");
            System.out.println("Alert 4");

            driver.findElement(By.xpath("/html/body/gc-core-app-root/gc-core-root/dx-drawer/div/div[2]/div[2]/div/dx-scroll-view/div[1]/div/div[1]/div[2]/div/gc-core-ticket-homeowner/div/div/div[14]/dx-box/div/dxi-item/dx-scroll-view/div[1]/div/div[1]/div[2]/div/div/gc-core-client-ui-loop/div/dx-responsive-box/div/div[201]/dxi-item/span[2]/gc-core-client-ui-loop/div/dx-responsive-box/div/div/div/div[6]/dxi-item/dx-button/div/span")).click();
            driver.switchTo();
            Thread.sleep(5000);
            driver.findElement(By.xpath("/html/body/div/div/div[2]/div/dx-button")).click();

            System.out.println("Acknowledgement accepted");


//        driver.quit();



        }

    }


package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static com.qa.base.TestBase.driver;

public class ticketSearch {

    public ticketSearch() {
        PageFactory.initElements(driver, this);
    }

    public static String getTicketSearchPageTitle() {
        System.out.println("Page title"+driver.getTitle());
        return driver.getTitle();
    }
    public void navigateToTicketSearch() throws InterruptedException {
        System.out.println("Page Title"+driver.getTitle());
        Thread.sleep(3000);
        driver.findElement(By.xpath("//span[normalize-space()='Ticket Search']")).click();
//        System.out.println("Page Title"+driver.getTitle());
    }

    public void validateTicketSearchPageTitle() {
        driver.findElement(By.xpath("//div[@class='content-block adjust-nav-second']")).isDisplayed();
    }

    public void enterTicketNumberInSearch(String tNumber) throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//dx-text-box[@class='ng-untouched ng-pristine ng-valid dx-show-invalid-badge dx-textbox dx-texteditor dx-show-clear-button dx-editor-outlined dx-texteditor-empty dx-widget']//input[@role='textbox']")).sendKeys(tNumber);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[normalize-space()='Search']")).click();
        driver.findElement(By.xpath("/html/body/gc-core-app-root/gc-core-root/dx-drawer/div/div[2]/div[2]/div/dx-scroll-view/div[1]/div/div[1]/div[2]/div/gc-core-ticket-search/div/dx-drawer/div/div[2]/div[2]/gc-core-ticket-detail/dx-scroll-view/div[1]/div/div[1]/div[2]/div/div[1]")).isDisplayed();


    }
}




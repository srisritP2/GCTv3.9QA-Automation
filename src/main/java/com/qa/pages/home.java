package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class home extends TestBase {

    //Initializing the Page Objects:
    public home()
    {
        PageFactory.initElements(driver, this);
    }

    //Actions:
    public String validateLoginPageTitle()
    {
        return driver.getTitle();
    }

}



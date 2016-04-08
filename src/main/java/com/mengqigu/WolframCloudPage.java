package com.mengqigu;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class WolframCloudPage{
    WebDriver driver;
    String baseUrl = "https://www.wolframcloud.com/";

    @FindBy(css="span.productName")
    WebElement webDeveloperButton;

    @FindBy(tagName="iframe")
    WebElement webAppIframe;

    public WolframCloudPage(WebDriver driver){
        this.driver = driver;
        driver.get(baseUrl);
        PageFactory.initElements(driver, this);
        driver.switchTo().frame(webAppIframe);
    }

    public void clickWolframDevelopmentPlatformButton(){
        webDeveloperButton.click();
    }

    public boolean isPageOpened(){
        return driver.getTitle().contains("Wolfram Cloud");
    }
}

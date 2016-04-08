package com.mengqigu;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class DevelopmentPlatformHome{
    WebDriver driver;

    @FindBy(css="div.newNotebookBtn-dropdown")
    WebElement droupdownMenu;

    @FindBy(id="nb")
    WebElement nbButton;

    public DevelopmentPlatformHome(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectNbFromDropDown(){
        droupdownMenu.click();
        nbButton.click();
    }

    public void switchToPopUpNoteBook(){
        Set<String> handles = driver.getWindowHandles(); // get all window handles
        Iterator<String> iterator = handles.iterator();
        String subWindowHandler = null;
        while (iterator.hasNext()){
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);
    }

    public boolean isPageOpened(){
        return driver.getTitle().contains("Home - Wolfram Development Platform");
    }
}

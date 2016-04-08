package com.mengqigu;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class NoteBookPage{
    WebDriver driver;

    @FindBy(xpath="//div[@id='renameButton']/div/div")
    WebElement renameInput;

    @FindBy(id="toolbarRenameInputField")
    WebElement renameInputField;

    public NoteBookPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickRename(){
        renameInput.click();
    }

    public boolean isSuffixNb(){
        return renameInputField.getAttribute("value").contains(".nb");
    }

    public boolean isPageOpened(){
        return driver.getTitle().contains("Wolfram Development Platform");
    }

    public boolean isNoteBookUnamed(){
        return driver.getTitle().contains("(unnamed) - Wolfram Development Platform");
    }

}

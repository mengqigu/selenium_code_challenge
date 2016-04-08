package com.mengqigu;

import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class SignInPage{
    WebDriver driver;

    @FindBy(id="email")
    WebElement emailInputField;

    @FindBy(id="password")
    WebElement passwordInputField;

    @FindBy(id="signIn")
    WebElement signInButton;

    public SignInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setEmailInput(String email){
        emailInputField.clear();
        emailInputField.sendKeys(email);
    }

    public void setPassword(String password){
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }

    public void clickSignIn(){
        signInButton.click();
    }

    public void signIn(String email, String password){
        this.setEmailInput(email);
        this.setPassword(password);
        this.clickSignIn();
    }

    public boolean isPageOpened(){
        return driver.getTitle().contains("Wolfram Cloud");
    }
}

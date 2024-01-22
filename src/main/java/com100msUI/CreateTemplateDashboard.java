package com100msUI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.Iterator;
import java.util.Set;

public class CreateTemplateDashboard extends BasePage {

    WebDriver driver;
    public CreateTemplateDashboard(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void getDashboard() {
        driver.get("https://dashboard.100ms.live/");
    }
    @FindBy(xpath = "//button[normalize-space()='Login with email instead->']")
    WebElement login;
    @FindBy(css = "[name='email']")
    WebElement emaill;

    @FindBy(xpath = "//div[@class='form-group']//input[@id='password']")
    WebElement pwd;

    @FindBy(xpath = "//form/div[5]/button")
    WebElement submit;
    @FindBy(xpath = "//div[@class='hms-ui-c-dhzjXW hms-ui-c-dhzjXW-knmidH-justify-between hms-ui-c-dhzjXW-jroWjL-align-center']//button[@class='hms-ui-c-XwnTY hms-ui-c-XwnTY-kUuGdv-variant-primary hms-ui-c-XwnTY-iuKECt-css']")
    WebElement cretaeTemplate;
    @FindBy(xpath ="//div[@class='hms-ui-c-PJLV hms-ui-c-PJLV-ihZBADG-css']/div[3]")
    WebElement selectMeetingType;

    @FindBy(xpath = "//button[@class='hms-ui-c-XwnTY hms-ui-c-XwnTY-kUuGdv-variant-primary hms-ui-c-XwnTY-iidqxxJ-css']")
    WebElement configureMeeting;

    @FindBy(xpath = "//button[@class='hms-ui-c-XwnTY hms-ui-c-XwnTY-kUuGdv-variant-primary hms-ui-c-XwnTY-iidqxxJ-css']")
    WebElement experience;

    @FindBy(xpath = "//button[@class='hms-ui-c-XwnTY hms-ui-c-XwnTY-kUuGdv-variant-primary hms-ui-c-XwnTY-ijGGRxo-css']")
    WebElement joinAsHost;

    @FindBy(xpath = "//form/div")
    WebElement enterName;

    @FindBy(xpath = "//form/button")
    WebElement joinRoom;

    public void clickWithUserAndPassword(){
        login.click();
}
public void login(String email,String password) throws InterruptedException {
        emaill.click();
        emaill.sendKeys(email);
        pwd.click();
        pwd.sendKeys(password);
        Thread.sleep(70000);
        submit.click();

    }
    public void createTemplateForUser(){
        waitForElementToClickable(cretaeTemplate);
        cretaeTemplate.click();
        waitForElementToClickable(selectMeetingType);
        selectMeetingType.click();
        waitForElementToClickable(configureMeeting);
        configureMeeting.click();
        waitForElementToClickable(experience);
        experience.click();
        waitForElementToClickable(joinAsHost);
        joinAsHost.click();

    }

    public void switchToNewWindows(){
        driver.getWindowHandles();
        Set<String> window= driver.getWindowHandles();;
        Iterator<String> winIT= window.iterator();
        while(winIT.hasNext()){
        String newWindow=winIT.next();
       driver.switchTo().window(newWindow);


        }
    }
        public void enterDetailsAndJoinRoom(){
            waitForElementToClickable(enterName);
            enterName.click();
            enterName.sendKeys("pramod Kumar");

            waitForElementToClickable(joinRoom);
            joinRoom.click();
        }
    }



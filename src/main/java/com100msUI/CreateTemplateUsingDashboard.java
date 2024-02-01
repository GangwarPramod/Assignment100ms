package com100msUI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.Iterator;
import java.util.Set;

public class CreateTemplateUsingDashboard extends BasePage {

    WebDriver driver;

    public CreateTemplateUsingDashboard(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void doLogininGitHub() {
        driver.get("https://github.com/login");
    }

    @FindBy(xpath = "//input[@id='login_field']")
    WebElement usernameGit;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordGit;
    @FindBy(xpath = "//input[@name='commit']")
    WebElement submitGit;
    @FindBy(xpath = "//div[1]//div[1]//div[1]//div[1]//div[2]//div[1]//div[2]//div[1]//button[1]")
    WebElement loginWithGithublink;

    @FindBy(xpath = "//div[@class='hms-ui-c-dhzjXW hms-ui-c-dhzjXW-knmidH-justify-between hms-ui-c-dhzjXW-jroWjL-align-center']//button[@class='hms-ui-c-XwnTY hms-ui-c-XwnTY-kUuGdv-variant-primary hms-ui-c-XwnTY-iuKECt-css']")
    WebElement cretaeTemplate;
    @FindBy(xpath = "//div[@class='hms-ui-c-PJLV hms-ui-c-PJLV-ihZBADG-css']/div[3]")
    WebElement selectMeetingType;

    @FindBy(xpath = "//button[@class='hms-ui-c-XwnTY hms-ui-c-XwnTY-kUuGdv-variant-primary hms-ui-c-XwnTY-iidqxxJ-css']")
    WebElement configureMeeting;

    @FindBy(xpath = "//button[@class='hms-ui-c-XwnTY hms-ui-c-XwnTY-kUuGdv-variant-primary hms-ui-c-XwnTY-iidqxxJ-css']")
    WebElement experience;

    @FindBy(xpath = "//button[@class='hms-ui-c-XwnTY hms-ui-c-XwnTY-kUuGdv-variant-primary hms-ui-c-XwnTY-ijGGRxo-css']")
    WebElement joinAsHost;

    @FindBy(xpath = "//div[@class='hms-ui-c-dhzjXW hms-ui-c-dhzjXW-jroWjL-align-center hms-ui-c-dhzjXW-ibldsHs-css']")
    WebElement findJoineeName;
    @FindBy(xpath = "//input[@id='name']")
    WebElement enterDetails;

    @FindBy(xpath = "//form/button")
    WebElement joinRoom;

    public void getDashboard() {
        driver.get("https://dashboard.100ms.live/");
    }

    public void clickWithUserAndPassword() {
        loginWithGithublink.click();
    }

    public void login(String email, String password) {
        usernameGit.sendKeys(email);
        passwordGit.sendKeys(password);
        submitGit.click();

    }

    public void createTemplateForUser() {
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

    public void switchToNewWindows() {
         driver.getWindowHandles();
         Set<String> window = driver.getWindowHandles();
          Iterator<String> winIT = window.iterator();
          while (winIT.hasNext()) {
            String newWindow = winIT.next();
            driver.switchTo().window(newWindow);


        }
    }

    public void enterDetailsAndJoinRoom() {
        waitForElementToClickable(findJoineeName);
        findJoineeName.click();
        enterDetails.sendKeys("pramod Kumar");
        waitForElementToClickable(joinRoom);
        joinRoom.click();
        /**
         * Opening the link in tab.
         */
        String url=driver.getCurrentUrl();
        driver.switchTo().newWindow(WindowType.TAB).navigate().to(url);
        waitForElementToClickable(findJoineeName);
        findJoineeName.click();
        enterDetails.sendKeys("Aman Kumar");
        waitForElementToActive(joinRoom);
        joinRoom.click();

    }

    }




package api;


import com100msUI.CreateTemplateUsingDashboard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Objects;

public class BasePageTest {
public static WebDriver driver;
    public static void initializeDriver(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("use-fake-device-for-media-stream");
        options.addArguments("use-fake-ui-for-media-stream");
         driver=new ChromeDriver(options);
         driver.manage().window().maximize();
    }

    public void CreateTemplateAndJoinMeetRoomE2EFlow() throws InterruptedException {
        initializeDriver();
        CreateTemplateUsingDashboard createTemplateUsingDashboard=new CreateTemplateUsingDashboard(driver);
        createTemplateUsingDashboard.doLogininGitHub();
        createTemplateUsingDashboard.login("kumarpra369@gmail.com","Advika@321123");
        createTemplateUsingDashboard.getDashboard();
        createTemplateUsingDashboard.clickWithUserAndPassword();
        createTemplateUsingDashboard.createTemplateForUser();
        createTemplateUsingDashboard.switchToNewWindows();
        createTemplateUsingDashboard.enterDetailsAndJoinRoom();

    }
    public static void openMeeting(String url){
        if (Objects.isNull(driver)){
            initializeDriver();
        }
        driver.get(url);
    }

}

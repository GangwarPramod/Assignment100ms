package api;


import com100msUI.CreateTemplateUsingDashboard;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;


import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class BasePageTest {
public static WebDriver driver;
    public static void initializeDriver(){

           FirefoxOptions options =new FirefoxOptions();
//         ChromeOptions options=new ChromeOptions();
//         options.addArguments("use-fake-device-for-media-stream");
//         options.addArguments("use-fake-ui-for-media-stream");
//
        options.addPreference("media.navigator.permission.disabled", true);
         driver=new FirefoxDriver(options);
         driver.manage().window().maximize();
    }

    public void CreateTemplateAndJoinMeetRoomE2EFlow() throws InterruptedException {
        initializeDriver();
        CreateTemplateUsingDashboard createTemplateUsingDashboard=new CreateTemplateUsingDashboard(driver);
        createTemplateUsingDashboard.doLogininGitHub();
        createTemplateUsingDashboard.login("kumarpra369@gmail.com","Advika@321123");
        createTemplateUsingDashboard.getDashboard();
        createTemplateUsingDashboard.clickWithUserAndPassword();
        Thread.sleep(5000);
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
    public void getMeetScreenShot() throws IOException {
        File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("user.dir"));

    }
    @AfterClass
    public void closeDriver(){
     driver.quit();
  }
}

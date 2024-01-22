package api;

import com100msUI.CreateTemplateDashboard;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

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

    public void launchDashboard() throws InterruptedException {
        initializeDriver();
        CreateTemplateDashboard dashboardPage=new CreateTemplateDashboard(driver);
        dashboardPage.getDashboard();
        dashboardPage.clickWithUserAndPassword();
        dashboardPage.login("kumarpra369@gmail.com","Mahakal@321");
        dashboardPage.createTemplateForUser();
        dashboardPage.switchToNewWindows();
        dashboardPage.enterDetailsAndJoinRoom();

    }
    public static void openMeeting(String url){
        if (Objects.isNull(driver)){
            initializeDriver();
        }
        driver.get(url);
    }

}

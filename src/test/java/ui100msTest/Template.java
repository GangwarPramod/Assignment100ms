package ui100msTest;

import api.BasePageTest;
import org.testng.annotations.Test;



public class Template extends BasePageTest {

    @Test(description = "description create a new template and check user is able to login")
    public void createAndvalidatetemplate() throws InterruptedException {
        launchDashboard();

    }
}

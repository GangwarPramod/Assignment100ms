package ui100msTest;

import api.BasePageTest;
import org.testng.annotations.Test;

import java.io.IOException;


public class Template extends BasePageTest {

    @Test(description = "Created end to end flow for template creation and meeting room join")
    public void createAndvalidatetemplate() throws InterruptedException, IOException {
        CreateTemplateAndJoinMeetRoomE2EFlow();
        Thread.sleep(3000);
        getMeetScreenShot();
    }
}

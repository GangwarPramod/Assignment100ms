package ui100msTest;

import api.BasePageTest;
import org.testng.annotations.Test;



public class Template extends BasePageTest {

    @Test(description = "Created end to end flow for template creation and meeting room join")
    public void createAndvalidatetemplate() throws InterruptedException {
        CreateTemplateAndJoinMeetRoomE2EFlow();

    }
}

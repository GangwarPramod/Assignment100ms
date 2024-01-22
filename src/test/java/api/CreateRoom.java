package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.util.GenerateToken;
import constant100ms.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Value;
import org.testng.annotations.Test;

public class CreateRoom extends BaseApiTest {


    @Test
    public void createRoom() throws JsonProcessingException {
        String room_id = createRoomAndGetRoomId(Constants.templateID.TEMPLATEID_ACTIVEROOM.getTemplateid(), Constants.templateID.TEMPLATEID_ACTIVEROOM.toString() + 1, "testRoom");
        System.out.println(room_id);


    }

    @Test
    public void getRoomId() {
        Response response = RestAssured.given().relaxedHTTPSValidation().headers("Authorization", "Bearer " + token)
                .log().all().get("https://api.100ms.live/v2/rooms");
        response.prettyPrint();
    }


    @Getter
    @Value
    static class Request {
        String template_id;
        String name;
        String description;
    }
}

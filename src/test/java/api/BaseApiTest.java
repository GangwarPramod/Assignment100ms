package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.util.GenerateToken;
import com100msDTO.StartRecordingPojo;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;




public class BaseApiTest {
    static String token = GenerateToken.generateManagementToken();
    public RequestSpecification reqSpecBuilders() {
        RequestSpecification request = new RequestSpecBuilder().setRelaxedHTTPSValidation().setContentType(ContentType.JSON)
                .setBaseUri("https://api.100ms.live/")
                .addHeader("Authorization", "Bearer " + token)
                .log(LogDetail.ALL).build();

        return request;
    }

    public ResponseSpecification resSpecBuilder() {
        ResponseSpecification response = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
        return response;
    }

    public static String getRoomID(Response res) {
        JsonPath js = res.jsonPath();
        return js.get("id");
    }

    public String createRoomAndGetRoomId(String templateId, String roomName, String decription) throws JsonProcessingException {

        return getRoomID(RestAssured.given().spec(reqSpecBuilders())
                .body(new ObjectMapper().writeValueAsString(new CreateRoom.Request(templateId, roomName, decription))).post("/v2/rooms"));

    }

    public Response getStartRecoringSession(StartRecordingPojo reqBody, String room_id) {
        return RestAssured.given().spec(reqSpecBuilders())
                .body(reqBody)
                .pathParam("room_id", room_id)
                .post("/v2/recordings/room/{room_id}/start");
    }
public Response stopRecording(String room_id) {
    return RestAssured.given().spec(reqSpecBuilders()).pathParam("room_id", room_id)
            .post("v2/recordings/room/{room_id}/stop");
}
    public Response stopRecordingByRecordingID(String recording_id){
        return  RestAssured.given().spec(reqSpecBuilders()).pathParam("recording_id",recording_id)
                .post("v2/recordings/room/{recording_id}/stop");

    }
    public Response endActiveRoom(String room_id){
        String requestBody="{\n" +
                "    \"reason\": \"The session has ended\",\n" +
                "    \"lock\": false\n" +
                "}";
        return RestAssured.given().spec(reqSpecBuilders()).pathParam("room_id",room_id).body(requestBody)
                .post("/v2/active-rooms/{room_id/end-room");
    }
    public Response getRecordingStatus(String recording_id) {
        return RestAssured.given().spec(reqSpecBuilders()).pathParam("recording_id",recording_id)
                .get("/v2/recordings/{recording_id}");
    }
    public Response disableRoomOrEnabled(String room_id){
        String request="{\n" +
                "    \"enabled\": false\n" +
                "}";
return RestAssured.given().spec(reqSpecBuilders()).pathParam("room_id",room_id)
        .body(request).post("/v2/rooms/{room_id}");
    }

}


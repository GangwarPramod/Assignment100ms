package com100msApiTest;

import api.BasePageTest;
import api.BaseApiTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.util.*;
import com100msDTO.StartRecordingPojo;
import constant100ms.Constants;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.Random;


public class RecordingTest extends BaseApiTest {
    Random random = new Random();
    @Test
    public void validateStartRecordingSuccess() throws JsonProcessingException {
        String room_id = createRoomAndGetRoomId(Constants.templateID.TEMPLATEID_ACTIVEROOM.getTemplateid(),"new-roomm-"+random.nextInt(), "testRoom");
        StartRecordingPojo reqBody = RequestPayload
                .getRequest(room_id, Constants.SubDomain.SUB_DOMAIN_USED_WITH_ROLES,Constants.MeetingUrlParam.SKIP_PREVIEW_HEADFUL);
        Response response = getStartRecoringSession(reqBody, room_id);
        response.prettyPrint();
        Assertions.assertThat(response.jsonPath().getString("status")).isEqualTo("starting");
        JsonPath js=response.jsonPath();
        String meetingUrl= js.get("meeting_url");
        BasePageTest.openMeeting(meetingUrl);
        Response errorResponse=getStartRecoringSession(reqBody, room_id);
        Assertions.assertThat(errorResponse.getStatusCode()).isNotEqualTo(200);
        Assertions.assertThat(errorResponse.jsonPath().getString("message")).isEqualTo("beam already started");


    }
    @Test
    public void validateStartRecordingStausAfterUserEndsTheActiveRoom() {
        String room_id = null;
        try {
            room_id = createRoomAndGetRoomId(Constants.templateID.TEMPLATEID_ACTIVEROOM.getTemplateid(),"new-roomm-"+random.nextInt(), "testRoom");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        StartRecordingPojo reqBody = RequestPayload
                .getRequest(room_id, Constants.SubDomain.SUB_DOMAIN_USED_WITH_ROLES,Constants.MeetingUrlParam.SKIP_PREVIEW);
        Response response = getStartRecoringSession(reqBody, room_id);
        endActiveRoom(room_id);

    }

    @Test
    public void validateStopRecordingUsingRoomID() {
        String room_id = null;
        try {
            room_id = createRoomAndGetRoomId(Constants.templateID.TEMPLATEID_ACTIVEROOM.getTemplateid(),"new-roomm-"+random.nextInt(), "testRoom");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        StartRecordingPojo reqBody = RequestPayload
                .getRequest(room_id, Constants.SubDomain.SUB_DOMAIN_USED_WITH_ROLES,Constants.MeetingUrlParam.SKIP_PREVIEW);
        Response response = getStartRecoringSession(reqBody, room_id);
        response.prettyPrint();

        Response StopRecordingResponse = stopRecording(room_id);
        StopRecordingResponse.prettyPrint();
        String meeting_url_session=StopRecordingResponse.getBody().jsonPath().getString("meeting_url");
        Assertions.assertThat(meeting_url_session).isEqualTo(reqBody.getMeeting_url());
        Assertions.assertThat(StopRecordingResponse.jsonPath().getString("status")).isEqualTo("stopping");


    }

    @Test
    public void validateStopRecordingUsingRecordingID() {
        String room_id = null;
        try {
            room_id = createRoomAndGetRoomId(Constants.templateID.TEMPLATEID_ACTIVEROOM.getTemplateid(),"new-roomm-"+random.nextInt(), "testRoom");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        StartRecordingPojo reqBody = RequestPayload
                .getRequest(room_id, Constants.SubDomain.SUB_DOMAIN_USED_WITH_ACTIVE_ROOM,Constants.MeetingUrlParam.SKIP_PREVIEW_HEADFUL);
        Response response = getStartRecoringSession(reqBody, room_id);
        response.prettyPrint();
        String recording_id=response.getBody().jsonPath().get("id");
        Response stopSRecordedSession=stopRecordingByRecordingID(recording_id);
        stopSRecordedSession.prettyPrint();
        String meeting_url_new=stopSRecordedSession.getBody().jsonPath().getString("meeting_url");
        Assertions.assertThat(meeting_url_new).isEqualTo(response.jsonPath().getString("meeting_url"));
        Assertions.assertThat(stopSRecordedSession.jsonPath().getString("status")).isEqualTo("stopping");


    }

    @Test
    public void validateStartRecordingWhenSubDomainIsNotPresent() {

    }



    @Test
    public void validateStartRecordingWhenRoomIsDisabled() {
        String room_id = null;
        try {
            room_id = createRoomAndGetRoomId(Constants.templateID.TEMPLATEID_ACTIVEROOM.getTemplateid(),"new-roomm-"+random.nextInt(), "testRoom");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        Response  room_cuurent_Status=disableRoomOrEnabled(room_id);
        room_cuurent_Status.prettyPrint();
        StartRecordingPojo reqBody = RequestPayload
                .getRequest(room_id, Constants.SubDomain.SUB_DOMAIN_USED_WITH_ROLES,Constants.MeetingUrlParam.SKIP_PREVIEW_HEADFUL);
        Response response = getStartRecoringSession(reqBody, room_id);
        response.prettyPrint();

    }

    @Test
    public void validateStartRecordingWhenTempleteIsDeletedForTheRoom() throws InterruptedException {
        String room_id = null;
        try {
            room_id = createRoomAndGetRoomId(Constants.templateID.INACTIVETEMPLATEID_ROOM.getTemplateid(),"new-roomm-"+random.nextInt(), "testRoom");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        StartRecordingPojo reqBody = RequestPayload
                .getRequest(room_id, Constants.SubDomain.SUB_DOMAIN_USED_WITH_ROLES,Constants.MeetingUrlParam.SKIP_PREVIEW_HEADFUL);
        Response response = getStartRecoringSession(reqBody, room_id);
        response.prettyPrint();
        JsonPath js=response.jsonPath();
        String meetingUrl= js.get("meeting_url");
        BasePageTest.openMeeting(meetingUrl);
        String recording_id=response.getBody().jsonPath().get("id");
        Response recordingCurrentStatus=getRecordingStatus(recording_id);
        Thread.sleep(4000);
        recordingCurrentStatus.prettyPrint();

    }

    @Test
    public void validateStartRecordingWhenUserEnabledTheRoomAfterDisabling() {

    }

    @Test
    public void validateStartRecordingStatusNoRoleIsAppliedonRoomOrTemplate() {

    }

    @Test
    public void validateRecordingStatusAfterPeersLefttheSession() {

    }

    @Test
    public void validateRecordingStatusIfRoomHasNotRoleConfigured() {

    }

    @Test
    public void validateRecordingStatusIfMeetingUrlHasDifferentRoleThenTemplate() {

    }

    @Test
    public void validateRecordingStatusIfUserHasExitedFromBrowser() {

    }

    @Test
    public void validateRecordingStatusWhenMeeting_urlDoesNotOpenInBrowser() {

    }


    @Test
    public void validateStopRecordingWhenRecordingStatusIsFailed() throws InterruptedException {
        String room_id = null;
        try {
            room_id = createRoomAndGetRoomId(Constants.templateID.TEMPLATEID_ACTIVEROOM.getTemplateid(),"new-roomm-"+random.nextInt(), "testRoom");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        StartRecordingPojo reqBody = RequestPayload
                .getRequest(room_id, Constants.SubDomain.SUB_DOMAIN_USED_WITH_ROLES,Constants.MeetingUrlParam.SKIP_PREVIEW);
        Response response = getStartRecoringSession(reqBody, room_id);
        response.prettyPrint();

        Response StopRecordingResponse = stopRecording(room_id);
        String recording_id=StopRecordingResponse.getBody().jsonPath().get("id");
        Response recordingCurrentStatus=getRecordingStatus(recording_id);
        Thread.sleep(4000);
        recordingCurrentStatus.prettyPrint();

    }
}

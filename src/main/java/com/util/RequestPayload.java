package com.util;

import com100msDTO.*;
import constant100ms.Constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class RequestPayload {
    public static StartRecordingPojo getRequest(String roomId, Constants.SubDomain domain,String MeetingUrlParam) {
        StartRecordingPojo.builder()
                .setMeeting_url(Utils.createMeetingUrlWithHostRole(roomId, domain,MeetingUrlParam))
                .setResolution(setRequest())
                .setTranscription(setTranscriptionInfo());
        return StartRecordingPojo.StartRecordingBuilder.build();
    }


    public static ResolutionPojo setRequest() {
        return ResolutionPojo.builder().setHeight(720).setWidth(1280).build();
    }

    public static TranscriptionPojo setTranscriptionInfo() {
        return TranscriptionPojo.builder().setEnabled(true)
                .setSummary(setSummary())
                .setCustom_vocabulary(List.of("100ms", "WebSDK", "Flutter", "Sundar", "Pichai", "DALL-E"))
                .setOutput_modes(List.of("txt", "srt", "json")).build();
    }

    public static SummaryPojo setSummary() {
        return SummaryPojo.builder().setContext("adf").setEnabled(true).
                setSections(setSectionInfo()).setTemperature(0.23)
                .build();
    }

    public static List<SectionsPojo> setSectionInfo() {
        final List<SectionsPojo> sectionsPojos = new ArrayList<>();
        sectionsPojos.add(SectionsPojo.builder().setFormat("Agenda").setTitle("bullets").build());
        sectionsPojos.add(SectionsPojo.builder().setFormat("Key Points").setTitle("bullets").build());
        sectionsPojos.add(SectionsPojo.builder().setFormat("Action Items").setTitle("bullets").build());
        sectionsPojos.add(SectionsPojo.builder().setFormat("Short Summary").setTitle("paragraph").build());
        return Collections.unmodifiableList(sectionsPojos);
    }

}

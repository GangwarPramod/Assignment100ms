package com100msDTO;


import lombok.Getter;

@Getter
public class StartRecordingPojo {
    private final String meeting_url;
    private final ResolutionPojo resolution;
    private final TranscriptionPojo transcription;

    private StartRecordingPojo(String meeting_url, ResolutionPojo resolution, TranscriptionPojo transcription) {
        this.meeting_url = meeting_url;
        this.resolution = resolution;
        this.transcription = transcription;
    }

    public static StartRecordingBuilder builder() {
        return new StartRecordingBuilder();
    }

    public static class StartRecordingBuilder {

        public static StartRecordingPojo build() {
            return new StartRecordingPojo(meeting_url, resolution, transcription);

        }

        public String getMeeting_url() {
            return meeting_url;
        }

        public StartRecordingBuilder setMeeting_url(String meeting_url) {
            StartRecordingBuilder.meeting_url = meeting_url;
            return this;
        }

        public ResolutionPojo getResolution() {
            return resolution;
        }

        public StartRecordingBuilder setResolution(ResolutionPojo resolution) {
            StartRecordingBuilder.resolution = resolution;
            return this;
        }

        public TranscriptionPojo getTranscription() {
            return transcription;
        }

        public void setTranscription(TranscriptionPojo transcription) {
            StartRecordingBuilder.transcription = transcription;
        }

        private static String meeting_url;
        private static ResolutionPojo resolution;
        private static TranscriptionPojo transcription;

    }

}

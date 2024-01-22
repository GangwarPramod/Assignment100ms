package com100msDTO;

import lombok.Getter;

import java.util.List;
@Getter
public class TranscriptionPojo {
    private final boolean enabled;

    public TranscriptionPojo(boolean enabled, List<String> output_modes, List<String> custom_vocabulary, SummaryPojo summary) {
        this.enabled = enabled;
        this.output_modes = output_modes;
        this.custom_vocabulary = custom_vocabulary;
        this.summary = summary;
    }

    private final List<String> output_modes;

    private final List<String>custom_vocabulary;

    private final SummaryPojo summary;

    public static TranscriptionBuilder builder(){
        return new TranscriptionBuilder();
    }
    @Getter
    public static class TranscriptionBuilder{


        public TranscriptionPojo build(){
            return new TranscriptionPojo(enabled,output_modes,custom_vocabulary,summary);
        }
        private boolean enabled;

        public TranscriptionBuilder setEnabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public TranscriptionBuilder setOutput_modes(List<String> output_modes) {
            this.output_modes = output_modes;
            return this;
        }

        public TranscriptionBuilder setCustom_vocabulary(List<String> custom_vocabulary) {
            this.custom_vocabulary = custom_vocabulary;
            return this;
        }

        public TranscriptionBuilder setSummary(SummaryPojo summary) {
            this.summary = summary;
            return this;
        }

        private List<String> output_modes;

        private List<String>custom_vocabulary;

        private SummaryPojo summary;


    }

}

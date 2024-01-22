package com100msDTO;

import lombok.Getter;

import java.util.List;
@Getter
public class SummaryPojo {
    private SummaryPojo(boolean enabled, String context, List<SectionsPojo> sectionsPojos, double temperature) {
        this.enabled = enabled;
        this.context = context;
        this.sectionsPojos = sectionsPojos;
        this.temperature = temperature;
    }

    private final boolean enabled;
    private final String context;
    private static  List<SectionsPojo> sectionsPojos;
    private final double temperature;

    public static SummaryBuilder builder(){
        return new SummaryBuilder();
    }

    @Getter
    public static class SummaryBuilder{

        public  SummaryPojo build(){
            return new SummaryPojo(enabled,context, sectionsPojos, temperature);
        }

        public SummaryBuilder setEnabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public SummaryBuilder setContext(String context) {
            this.context = context;
            return this;
        }

        public SummaryBuilder setSections(List<SectionsPojo> sections) {
            this.sections = sections;
            return this;
        }

        public SummaryBuilder setTemperature(double temperature) {
            this.temperature = temperature;
            return this;
        }

        private boolean enabled;
        private String context;
        private List<SectionsPojo> sections;
        private double temperature;

    }
}

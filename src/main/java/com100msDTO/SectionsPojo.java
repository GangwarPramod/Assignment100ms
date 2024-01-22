package com100msDTO;


public class SectionsPojo {
    private String title;
    private String format;
    private SectionsPojo(String title, String format) {
        this.title = title;
        this.format = format;
    }

    public static SectionsBuilder builder(){
        return new SectionsBuilder();
    }
    public static class SectionsBuilder{
        public  SectionsPojo build(){
            return new SectionsPojo(title,format);
        }
        public String getTitle() {
            return title;
        }

        public SectionsBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public String getFormat() {
            return format;
        }

        public SectionsBuilder setFormat(String format) {
            this.format = format;
            return this;
        }

        private static String title;
        private static String format;
    }
}

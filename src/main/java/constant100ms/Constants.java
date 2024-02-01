package constant100ms;

import lombok.Getter;

public class Constants {

    @Getter
    public enum templateID {

        TEMPLATEID_ACTIVEROOM("65ad1a4bcd666ed1654e2082"),
        TEMPLATEID_INACTIVEROOM("65aac36470fd941909eb9d0e"),
        INACTIVETEMPLATEID_ROOM("65aacaac70fd941909eb9d0f");
        private String templateid;

        templateID(String templateID) {
            this.templateid = templateID;
        }

    }

    @Getter
    public enum SubDomain {
        SUB_DOMAIN_USED_WITH_ACTIVE_ROOM("kumar-videoconf-2034"),
        SUB_DOMAIN_USED_WITH_ROLES("kumar-videoconf-1850"),
        SUB_DOMAIN_USED_WITH_INACTIVE_ROOM("kumar-videoconf-9563");

        private String url;
        SubDomain(String url){this.url=url;}


    }

    public static class MeetingUrlParam{
        public static final String SKIP_PREVIEW="?skip_preview=true";
        public static final String SKIP_PREVIEW_HEADFUL="?skip_preview_headful=true";
        public static final String AUTH_TOKEN="?auth_token=token1234";
        public static final String UI_MODE="?ui_mode=activespeaker";
        public  static final String PEER_NAME ="?name=johndoe";
    }
}


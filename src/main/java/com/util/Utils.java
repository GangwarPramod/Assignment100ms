package com.util;

import constant100ms.Constants;

public class Utils {
    private Utils() {

    }

    public static String createMeetingUrlWithHostRole(String roomId, Constants.SubDomain domain,String MeetingUrlParam) {
        return String.format("https://%s.app.100ms.live/preview/%s/host%s", domain.getUrl(), roomId,MeetingUrlParam);
    }
    public static String createMeetingUrlWithGuestRole(String roomId, Constants.SubDomain domain,String MeetingUrlParam) {
        return String.format("https://%s.app.100ms.live/preview/%s/guest%s", domain.getUrl(), roomId,MeetingUrlParam);
    }
}

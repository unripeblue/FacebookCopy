package kr.co.tjeit.facebookcopy.data;

import java.util.Calendar;

/**
 * Created by the on 2017-08-08.
 */

public class NotifyData {

    private String imagePath;
    private String notificationText;
    private int notificatlionType; // 1:~~가 댓글을 남겼습니다. 2:~~가 글을 좋아합니다 식
    private int minuteAgo;
//    private CalendarcreateAt; -> 실제로는 이쪽이 더 적합함.
    // 2분 이내 : 방금 전, 2~59분 : 00분 전, 60~119분 : 1시간 전.... 등등

    public NotifyData() {

    }

    public NotifyData(String imagePath, String notificationText, int notificatlionType, int minuteAgo) {
        this.imagePath = imagePath;
        this.notificationText = notificationText;
        this.notificatlionType = notificatlionType;
        this.minuteAgo = minuteAgo;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    public int getNotificatlionType() {
        return notificatlionType;
    }

    public void setNotificatlionType(int notificatlionType) {
        this.notificatlionType = notificatlionType;
    }

    public int getMinuteAgo() {
        return minuteAgo;
    }

    public void setMinuteAgo(int minuteAgo) {
        this.minuteAgo = minuteAgo;
    }
}

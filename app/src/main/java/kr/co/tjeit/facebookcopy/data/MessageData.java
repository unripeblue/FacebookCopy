package kr.co.tjeit.facebookcopy.data;

import java.util.Calendar;

/**
 * Created by the on 2017-08-08.
 */

public class MessageData {
    private int sendUserId;
    private String content;
    private Calendar sendTime;

    public MessageData() {

    }

    public MessageData(int sendUserId, String content, Calendar sendTime) {
        this.sendUserId = sendUserId;
        this.content = content;
        this.sendTime = sendTime;
    }

    public int getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(int sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Calendar getSendTime() {
        return sendTime;
    }

    public void setSendTime(Calendar sendTime) {
        this.sendTime = sendTime;
    }
}

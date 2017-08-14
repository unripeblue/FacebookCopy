package kr.co.tjeit.facebookcopy.util;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjeit.facebookcopy.data.MessageData;
import kr.co.tjeit.facebookcopy.data.NewSpeedData;
import kr.co.tjeit.facebookcopy.data.NotifyData;
import kr.co.tjeit.facebookcopy.data.ReplyData;
import kr.co.tjeit.facebookcopy.data.RequestData;

/**
 * Created by the on 2017-08-08.
 */

public class GlobalDatas {
    public static int loginUserId = 10;
    public static String loginUserName = "ㅇㅇㅇ";

    public static List<RequestData> requestDatas = new ArrayList<>();
    public static List<NotifyData> notifyDatas = new ArrayList<>();
    public static List<NewSpeedData> newSpeedDatas = new ArrayList<>();
    public static List<MessageData> messageDatas = new ArrayList<>();
    public static List<ReplyData> replyDatas = new ArrayList<>();

    public static void initDatas() {
        requestDatas.clear();
        requestDatas.add(new RequestData("", 7, "고동윤"));
        requestDatas.add(new RequestData("", 1, "권성민"));
        requestDatas.add(new RequestData("", 10, "김현철"));
        requestDatas.add(new RequestData("", 15, "박석영"));
        requestDatas.add(new RequestData("", 8, "박수현"));
        requestDatas.add(new RequestData("", 6, "박영주"));
        requestDatas.add(new RequestData("", 4, "손익상"));
        requestDatas.add(new RequestData("", 9, "이승헌"));
        requestDatas.add(new RequestData("", 10, "이요한"));
        requestDatas.add(new RequestData("", 12, "최종환"));
        requestDatas.add(new RequestData("", 13, "한상열"));

        notifyDatas.clear();
        notifyDatas.add(new NotifyData("","10명이 내 글을 좋아합니다.", 1, 1));
        notifyDatas.add(new NotifyData("","~~가 내 글에 댓글을 남겼습니다.", 2, 40));
        notifyDatas.add(new NotifyData("","~~가 회원님을 팔로우 합니다.", 3, 70));
        notifyDatas.add(new NotifyData("","~~가 내 댓글을 좋아합니다.", 4, 230));
        notifyDatas.add(new NotifyData("","~~가 친구 요청을 수락했습니다.", 5, 600));

        newSpeedDatas.clear();
        newSpeedDatas.add(new NewSpeedData("http://naver.com", "", 2, "네이버로 링크를 걸어주는 뉴스피드입니다.", 12));
        newSpeedDatas.add(new NewSpeedData("http://google.com", "", 10, "구글로 링크를 걸어주는 뉴스피드입니다.", 5));
        newSpeedDatas.add(new NewSpeedData("", "", 45, "일기처럼 글만 적힌 뉴스피드", 125));
        newSpeedDatas.add(new NewSpeedData("", "", 230, "사진 올린 뉴스피드", 2453));
        newSpeedDatas.add(new NewSpeedData("", "", 800, "동영상 뉴스피드", 121371));

    }
}

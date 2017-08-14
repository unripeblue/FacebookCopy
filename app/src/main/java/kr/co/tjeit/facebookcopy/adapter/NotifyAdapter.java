package kr.co.tjeit.facebookcopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.data.NotifyData;
import kr.co.tjeit.facebookcopy.data.RequestData;

/**
 * Created by the on 2017-08-08.
 */

public class NotifyAdapter extends ArrayAdapter<NotifyData>{
    Context mContext;
    List<NotifyData> mList;
    LayoutInflater inf;

    public NotifyAdapter (Context context, List<NotifyData> list) {
        super(context, R.layout.nofity_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row == null) {
            row = inf.inflate(R.layout.nofity_list_item, null);
        }

        NotifyData data = mList.get(position);

        TextView uploadTxt = (TextView) row.findViewById(R.id.uploadTxt);
        TextView timeAgoTxt = (TextView) row.findViewById(R.id.timeAgoTxt);

        uploadTxt.setText(data.getNotificationText());
        String timeStr = "";



        if (data.getMinuteAgo() <= 2) {
            timeStr = "방금 전";
        }
        else if (data.getMinuteAgo() < 41) {
            timeStr = String.format(Locale.KOREA, "%d분 전", data.getMinuteAgo());
        }
        else if (data.getMinuteAgo() <= 90) {
            timeStr = "한시간 전";
        }
        else if (data.getMinuteAgo() <= 510) {
            int hour = (data.getMinuteAgo()+29) / 60;
            timeStr = String.format(Locale.KOREA, "%d시간 전", hour);
            // 91 ~ 150 : 2
            // 151 ~ 210 : 3
            // 211 ~ 270 : 4
            // 271 ~ 330 : 5
            // 331 ~ 390 : 6
            // 391 ~ 450 : 7
            // 451 ~ 510 : 8
        }
        else {
            timeStr = "오래 전";
        }


        timeAgoTxt.setText(timeStr);



        return row;
    }


}

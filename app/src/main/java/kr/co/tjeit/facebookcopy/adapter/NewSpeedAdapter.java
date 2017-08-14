package kr.co.tjeit.facebookcopy.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Time;
import java.util.List;
import java.util.Locale;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.ReplyListActivity;
import kr.co.tjeit.facebookcopy.SignupActivity;
import kr.co.tjeit.facebookcopy.data.NewSpeedData;
import kr.co.tjeit.facebookcopy.data.NotifyData;
import kr.co.tjeit.facebookcopy.util.TimeAgoUtil;

/**
 * Created by the on 2017-08-08.
 */

public class NewSpeedAdapter extends ArrayAdapter<NewSpeedData>{
    Context mContext;
    List<NewSpeedData> mList;
    LayoutInflater inf;

    public NewSpeedAdapter (Context context, List<NewSpeedData> list) {
        super(context, R.layout.new_speed_list_item, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row==null) {
            row = inf.inflate(R.layout.new_speed_list_item, null);
        }

        NewSpeedData data = mList.get(position);

        Button likeBtn = (Button) row.findViewById(R.id.likeBtn);
        Button replyBtn = (Button) row.findViewById(R.id.replyBtn);
        TextView contentTxt = (TextView) row.findViewById(R.id.contentTxt);
        TextView timeAgoTxt = (TextView) row.findViewById(R.id.timeAgoTxt);
        TextView likeTxt = (TextView) row.findViewById(R.id.likeTxt);
        TextView urlTxt = (TextView) row.findViewById(R.id.urlTxt);
        LinearLayout previewLayout = (LinearLayout) row.findViewById(R.id.previewLayout);

        contentTxt.setText(data.getContentText());

        String minuteStr = TimeAgoUtil.getTimeAgoString(data.getMinuteAgo());
        timeAgoTxt.setText(minuteStr);

        String likeCountStr = String.format(Locale.KOREA, "%d개", data.getLikeCount());
        likeTxt.setText(likeCountStr);


        urlTxt.setText(data.getLinkUrl());
        // Adapter의 getView에서 if를 통해 작업할때는 반드시 else의 경우도 작업해주자.
        // 왜? Adapter를 활용하는 View는 재활용이 기본 옵션이라서

        if (data.getLinkUrl().length()==0) {
            previewLayout.setVisibility(View.GONE);
        }
        else {
            previewLayout.setVisibility(View.VISIBLE);
        }





        likeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "좋아요 버튼을 눌렀습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        replyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReplyListActivity.class);
                mContext.startActivity(intent);
            }
        });


        return row;
    }


}

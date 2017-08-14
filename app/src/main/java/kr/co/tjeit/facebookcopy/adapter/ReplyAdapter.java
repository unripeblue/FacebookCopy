package kr.co.tjeit.facebookcopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.ReplyListActivity;
import kr.co.tjeit.facebookcopy.data.MessageData;
import kr.co.tjeit.facebookcopy.data.ReplyData;
import kr.co.tjeit.facebookcopy.util.GlobalDatas;

/**
 * Created by the on 2017-08-09.
 */

public class ReplyAdapter extends ArrayAdapter<ReplyData> {


    Context mContext;
    List<ReplyData> mList;
    LayoutInflater inf;
    public ReplyAdapter (Context context, List<ReplyData> list) {
        super(context, R.layout.reply_list_item, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row==null) {
            row = inf.inflate(R.layout.reply_list_item, null);
        }

        final ReplyData data = mList.get(position);

        LinearLayout replyLout = (LinearLayout) row.findViewById(R.id.replyLout);
        LinearLayout replyReLout = (LinearLayout) row.findViewById(R.id.replyReLout);
        TextView replyUserNameTxt = (TextView) row.findViewById(R.id.replyUserNameTxt);
        TextView replyContentTxt = (TextView) row.findViewById(R.id.replyContentTxt);
        TextView rorNameTxt = (TextView) row.findViewById(R.id.rorNameTxt);
        TextView rorContentTxt = (TextView) row.findViewById(R.id.rorContentTxt);

        if (data.getParentReplyId() == 0) {
            //댓글
            replyLout.setVisibility(View.VISIBLE);
            replyReLout.setVisibility(View.GONE);
            replyUserNameTxt.setText(data.getWriterName());
            replyContentTxt.setText(data.getReplyContent());

            TextView makeRorTxt1 = (TextView) row.findViewById(R.id.makeRorTxt1);
            makeRorTxt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int originalReplyNum = data.getReplyId();
                    Log.d("original", originalReplyNum+"");
                    ((ReplyListActivity) mContext).replyEdt.setTag(originalReplyNum);
                }
            });
        }

        else {
            //대댓글
            replyLout.setVisibility(View.GONE);
            replyReLout.setVisibility(View.VISIBLE);
            rorNameTxt.setText(data.getWriterName());
            rorContentTxt.setText(data.getReplyContent());
            TextView makeRorTxt2 = (TextView) row.findViewById(R.id.makeRorTxt2);
            makeRorTxt2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int originalReplyNum = data.getReplyId();
                    Log.d("original", originalReplyNum+"");

                    // Adapter처럼 부속품으로 활용되는 코드에서 Activity에 접근해야 하는 상황이 발생.
                    // 그럴 때 처리하는 방법 => ((액티비티이름) mContext).활용
                    // 액티비티에서는 반드시 public으로 열어줘야 한다.
                    // (안된다면) getter/setter 활용해서 메소드만 열어줘도 된다.
                    ((ReplyListActivity) mContext).replyEdt.setTag(originalReplyNum);
                }
            });
        }


        return row;
    }

}

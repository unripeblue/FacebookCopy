package kr.co.tjeit.facebookcopy.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.data.MessageData;
import kr.co.tjeit.facebookcopy.data.NewSpeedData;

/**
 * Created by the on 2017-08-08.
 */

public class MessageAdapter extends ArrayAdapter<MessageData> {
    Context mContext;
    List<MessageData> mList;
    LayoutInflater inf;
    public MessageAdapter (Context context, List<MessageData> list) {
        super(context, R.layout.message_list_item, list);
        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        if (row==null) {
            row = inf.inflate(R.layout.message_list_item, null);
        }

//        MessageData data = mList.get(position);


        return row;
    }

    @Override
    public int getCount() {
        return 10;
    }
}

package kr.co.tjeit.facebookcopy.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.adapter.NewSpeedAdapter;
import kr.co.tjeit.facebookcopy.util.GlobalDatas;

/**
 * Created by the on 2017-08-04.
 */

public class NewSpeedFragment extends Fragment {

    ListView newspeedListView;
    NewSpeedAdapter newSpeedAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_new_speed, container, false);
        newspeedListView = (ListView) v.findViewById(R.id.newspeedListView);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpEvents();
        setValues();
    }

    private void setUpEvents() {
        newspeedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.naver.com"));
                startActivity(intent);
            }
        });
    }


    private void setValues() {
        newSpeedAdapter = new NewSpeedAdapter(getActivity(), GlobalDatas.newSpeedDatas);
        newspeedListView.setAdapter(newSpeedAdapter);
    }
}

package kr.co.tjeit.facebookcopy.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import kr.co.tjeit.facebookcopy.R;
import kr.co.tjeit.facebookcopy.adapter.NotifyAdapter;
import kr.co.tjeit.facebookcopy.util.GlobalDatas;

/**
 * Created by the on 2017-08-04.
 */

public class NotifyFragment extends Fragment {

    ListView notifyListView;
    NotifyAdapter notifyAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_notify, container, false);
        notifyListView = (ListView) v.findViewById(R.id.notifyListView);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setUpEvents();
        setValues();
    }



    private void setUpEvents() {
        notifyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), position+"번 줄 클릭", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setValues() {
        notifyAdapter = new NotifyAdapter(getActivity(), GlobalDatas.notifyDatas);
        notifyListView.setAdapter(notifyAdapter);
    }

}

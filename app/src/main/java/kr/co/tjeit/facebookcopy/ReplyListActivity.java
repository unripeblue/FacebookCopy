package kr.co.tjeit.facebookcopy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import kr.co.tjeit.facebookcopy.adapter.ReplyAdapter;
import kr.co.tjeit.facebookcopy.data.ReplyData;
import kr.co.tjeit.facebookcopy.util.GlobalDatas;

public class ReplyListActivity extends AppCompatActivity {

    private android.widget.ListView replyListView;
    public android.widget.EditText replyEdt;
    List<ReplyData> replyDatas = new ArrayList<>();
    ReplyAdapter rAdapter;
    private android.widget.Button sendBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_list);
        bindViews();
        setUpEvents();
        setValues();
        addDatas();

    }

    private void addDatas() {
        replyDatas.clear();
        replyDatas.add(new ReplyData(1, 0, "ㄱㄱㄱ", "첫번째 댓글입니다", Calendar.getInstance()));
        replyDatas.add(new ReplyData(2, 1, "ㄴㄴㄴ", "두번째 댓글입니다", Calendar.getInstance()));
        replyDatas.add(new ReplyData(3, 1, "ㄷㄷㄷ", "세번째 댓글입니다", Calendar.getInstance()));
        replyDatas.add(new ReplyData(4, 0, "ㄹㄹㄹ", "네번째 댓글입니다", Calendar.getInstance()));
        replyDatas.add(new ReplyData(5, 1, "ㅁㅁㅁ", "다섯번째 댓글입니다", Calendar.getInstance()));
        rAdapter.notifyDataSetChanged();
    }

    private void setValues() {
        rAdapter = new ReplyAdapter(ReplyListActivity.this, replyDatas);
        replyListView.setAdapter(rAdapter);
    }


    private void setUpEvents() {
        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputString = replyEdt.getText().toString();

                // Adapter에서 EditText에 달아둔 태그를 받아서
                // 숫자로 저장하는 부분
                int parentId = Integer.parseInt(replyEdt.getTag().toString());

                // 파고 들어갈 위치를 찾는 알고리즘.
                int index = replyDatas.size();

                if (parentId != 0) {
                    // 누군가의 대댓글로 들어가야 하는 상황.
                    // index를 적절하게 찾아줘야 한다.
                    for (int i = 0; i < replyDatas.size(); i++) {
                        ReplyData data = replyDatas.get(i);
                        if (parentId == data.getReplyId()) {
                            index = i;
                        } else if (parentId == data.getParentReplyId()) {
                            index = i;
                        }
                    }
                }

                replyDatas.add(index, new ReplyData(replyDatas.size() + 1, parentId, GlobalDatas.loginUserName, inputString, Calendar.getInstance()));
                rAdapter.notifyDataSetChanged();

                //리스트뷰 맨 아래로 스크롤 끌어내리기↓
                replyListView.setSelection(rAdapter.getCount() - 1);

                replyEdt.setText("");
            }
        });
    }


    private void bindViews() {
        this.sendBtn = (Button) findViewById(R.id.sendBtn);
        this.replyListView = (ListView) findViewById(R.id.replyListView);
        this.replyEdt = (EditText) findViewById(R.id.replyEdt);
    }
}

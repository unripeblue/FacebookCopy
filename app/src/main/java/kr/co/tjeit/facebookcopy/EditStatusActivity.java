package kr.co.tjeit.facebookcopy;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class EditStatusActivity extends AppCompatActivity {

    private android.widget.LinearLayout photomovieBtnLout;
    private android.widget.LinearLayout liveBrodcastBtnLout;
    private android.widget.LinearLayout checkinBtnLout;
    private android.widget.LinearLayout feelstickerBtnLout;
    private android.widget.EditText writeEditTxt;
    private android.widget.Button uploadBtn;
    private android.widget.Button cancelBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_status);

        bindviews();
        setUpEvents();
        setValues();
    }

    private void setValues() {

    }

    private void setUpEvents() {
        View.OnClickListener preparingListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditStatusActivity.this, "준비중인 기능입니다.", Toast.LENGTH_SHORT).show();
            }
        };
        photomovieBtnLout.setOnClickListener(preparingListener);
        liveBrodcastBtnLout.setOnClickListener(preparingListener);
        checkinBtnLout.setOnClickListener(preparingListener);
        feelstickerBtnLout.setOnClickListener(preparingListener);

        writeEditTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String inputText = s.toString();
                if (inputText.length() > 0) {
                    uploadBtn.setTextColor(Color.parseColor("#3333FF"));
                }
                else {
                    uploadBtn.setTextColor(Color.parseColor("#A0A0A0"));
                }
            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        uploadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (writeEditTxt.getText().toString().length()==0) {
                    Toast.makeText(EditStatusActivity.this, "게시글을 입력해 주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(EditStatusActivity.this, "글이 등록되었습니다.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditStatusActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void bindviews() {
        this.feelstickerBtnLout = (LinearLayout) findViewById(R.id.feel_stickerBtnLout);
        this.checkinBtnLout = (LinearLayout) findViewById(R.id.checkinBtnLout);
        this.liveBrodcastBtnLout = (LinearLayout) findViewById(R.id.liveBrodcastBtnLout);
        this.photomovieBtnLout = (LinearLayout) findViewById(R.id.photo_movieBtnLout);
        this.writeEditTxt = (EditText) findViewById(R.id.writeEditTxt);
        this.uploadBtn = (Button) findViewById(R.id.uploadBtn);
        this.cancelBtn = (Button) findViewById(R.id.cancelBtn);

    }
}

package kr.co.tjeit.facebookcopy;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class SignupActivity extends AppCompatActivity {

    private android.widget.EditText idEdt;
    private android.widget.Button idcheckBtn;
    private EditText pwEdt;
    private EditText pwOk;
    private Button signUpBtn;
    private boolean signup = false;
    private android.widget.TextView messageTxt;
    private android.widget.ImageView alertImg;
    private TextView birthdayTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);



        bindViews();
        setupEvents();

    }

    private void setupEvents() {
        idcheckBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputId = idEdt.getText().toString();
                if (inputId.equals("user")) {
                    Toast.makeText(SignupActivity.this, "이미 사용중인 아이디입니다.", Toast.LENGTH_SHORT).show();
                }
                else if (inputId.length() == 0) {
                    Toast.makeText(SignupActivity.this, "아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }
                else if (inputId.length() < 8) {
                    Toast.makeText(SignupActivity.this, "ID의 길이가 너무 짧습니다.", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(SignupActivity.this, "사용해도 좋습니다.", Toast.LENGTH_SHORT).show();
                    signup = true;
                }
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputPw = pwEdt.getText().toString();
                String inputCheckPw = pwOk.getText().toString();

                if (inputPw.length() >= 8 && inputPw.equals(inputCheckPw) && signup) {
                    Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        idEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String changedStr = s.toString();
                Log.d("바뀐글자", changedStr);

                signup = false;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        pwEdt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
               checkPwAndChangeMessage();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        pwOk.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                checkPwAndChangeMessage();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        final Calendar tempCal = Calendar.getInstance();

        birthdayTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(SignupActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        birthdayTxt.setText(""+year+month+dayOfMonth);
                    }
                },
                        tempCal.get(Calendar.YEAR),
                        tempCal.get(Calendar.MONTH),
                        tempCal.get(Calendar.DAY_OF_MONTH)).show();

            }
        });

    }

    void checkPwAndChangeMessage() {
        String pw = pwEdt.getText().toString();
        String pwCheck = pwOk.getText().toString();

        if (pw.length() == 0) {
            messageTxt.setText("비밀번호를 입력해주세요");
            messageTxt.setTextColor(Color.parseColor("#FF0000"));
            alertImg.setImageResource(R.drawable.red_alert_icon);
        }
        else if (pw.length() < 8) {
            messageTxt.setText("비밀번호의 길이가 너무 짧습니다.");
            messageTxt.setTextColor(Color.parseColor("#FF0000"));
            alertImg.setImageResource(R.drawable.red_alert_icon);
        }
        else if (!pw.equals(pwCheck)) {
            messageTxt.setText("두 개의 비밀번호가 서로 다릅니다.");
            messageTxt.setTextColor(Color.parseColor("#FF0000"));
            alertImg.setImageResource(R.drawable.red_alert_icon);
        }
        else {
            messageTxt.setText("회원가입이 가능합니다.");
            messageTxt.setTextColor(Color.parseColor("#009900"));
            alertImg.setImageResource(R.drawable.check_icon);
        }
    }


    private void bindViews() {
        this.signUpBtn = (Button) findViewById(R.id.signUpBtn);
        this.alertImg = (ImageView) findViewById(R.id.alertImg);
        this.messageTxt = (TextView) findViewById(R.id.messageTxt);
        this.pwOk = (EditText) findViewById(R.id.pwOk);
        this.pwEdt = (EditText) findViewById(R.id.pwEdt);
        this.idcheckBtn = (Button) findViewById(R.id.idcheckBtn);
        this.idEdt = (EditText) findViewById(R.id.idEdt);
        this.birthdayTxt = (TextView) findViewById(R.id.birthdayTxt);
    }


}

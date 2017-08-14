package kr.co.tjeit.facebookcopy;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    TextView modeTxt;
    EditText idEdt;
    Button loginBtn;
    Button signUpBtn;
    Button facebookLoginBtn;
    EditText pwEdt;
    Button goHompageBtn;
    Button emailquestionBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        bindViews();
        setupEvents();

    }



    void setupEvents() {
        // 버튼들이 눌릴 때 하는 일들을 설정
        // 이벤트 처리 모음
        facebookLoginBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
        signUpBtn.setOnClickListener(this);
        goHompageBtn.setOnClickListener(this);
        emailquestionBtn.setOnClickListener(this);

    }


    void bindViews() {
        facebookLoginBtn = (Button) findViewById(R.id.facebookLoginBtn);
        signUpBtn = (Button) findViewById(R.id.signUpBtn);
        loginBtn = (Button) findViewById(R.id.loginBtn);
        idEdt = (EditText) findViewById(R.id.idEdt);
        pwEdt = (EditText) findViewById(R.id.pwEdt);
        modeTxt = (TextView) findViewById(R.id.modeTxt);
        goHompageBtn = (Button) findViewById(R.id.goHompageBtn);
        emailquestionBtn = (Button) findViewById(R.id.emailquestionBtn);
    }


    @Override
    public void onClick(View v) {
        Intent myIntent;


        if (v.getId() == R.id.loginBtn) {
            String InputId = idEdt.getText().toString();
            String Inputpw = pwEdt.getText().toString();
            if (InputId.equals("user") && Inputpw.equals("1234")) {
                myIntent = new Intent(this, MainActivity.class);
                startActivity(myIntent);
                finish();
            }
            else {
                Toast.makeText(this, "아이디와 비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show();
            }
        }
        else if (v.getId() == R.id.signUpBtn) {
            myIntent = new Intent(this, SignupActivity.class);
            startActivity(myIntent);
            finish();
        }
        else if (v.getId() == R.id.facebookLoginBtn) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("알림");
            dialog.setMessage("준비중인 기능입니다.");
            dialog.setPositiveButton("확인", null);
            dialog.show();
        }
        else if (v.getId() == R.id.goHompageBtn) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("http://www.naver.com"));
            startActivity(intent);
            finish();
        }
        else if (v.getId() == R.id.emailquestionBtn) {
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:contact@tje.co.kr"));
            startActivity(intent);
            finish();
        }
        else {
            Toast.makeText(this, "다른 버튼이 눌림!", Toast.LENGTH_SHORT).show();
        }

    }
}

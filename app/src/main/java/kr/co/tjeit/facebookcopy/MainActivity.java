package kr.co.tjeit.facebookcopy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import kr.co.tjeit.facebookcopy.fragment.MessageFragment;
import kr.co.tjeit.facebookcopy.fragment.NewSpeedFragment;
import kr.co.tjeit.facebookcopy.fragment.NotifyFragment;
import kr.co.tjeit.facebookcopy.fragment.RequestFragment;
import kr.co.tjeit.facebookcopy.fragment.SeeMoreFragment;
import kr.co.tjeit.facebookcopy.util.GlobalDatas;

public class MainActivity extends AppCompatActivity {

    ViewPager mainViewPager;
    private android.widget.LinearLayout newspeedBtnLayout;
    private android.widget.LinearLayout requestBtnLayout;
    private android.widget.LinearLayout messageBtnLayout;
    private android.widget.LinearLayout notifyBtnLayout;
    private android.widget.LinearLayout seemoreBtnLayout;
    private android.widget.TextView titleTxt;
    private LinearLayout topbar;
    private LinearLayout statusLot;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bindViews();
        setUpEvents();
        setValues();

    }

    private void setValues() {
        GlobalDatas.initDatas();
        mainViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
    }

    private void setUpEvents() {

        View.OnClickListener pageChangeListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pageNum = Integer.parseInt(v.getTag().toString());
                mainViewPager.setCurrentItem(pageNum);
            }
        };
        newspeedBtnLayout.setOnClickListener(pageChangeListener);
        requestBtnLayout.setOnClickListener(pageChangeListener);
        messageBtnLayout.setOnClickListener(pageChangeListener);
        notifyBtnLayout.setOnClickListener(pageChangeListener);
        seemoreBtnLayout.setOnClickListener(pageChangeListener);

        statusLot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EditStatusActivity.class);
                startActivity(intent);
            }
        });

        mainViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                // 한 장의 페이지로 자리를 잡았을 때
                if (position == 0) {
                    titleTxt.setText("뉴스피드");
                } else if (position == 1) {
                    titleTxt.setText("요청");
                } else if (position == 2) {
                    titleTxt.setText("메시지");
                } else if (position == 3) {
                    titleTxt.setText("알림");
                } else if (position == 4) {
                    titleTxt.setText("더 보기");
                }
                if (position == 0) {
                    topbar.setVisibility(View.VISIBLE);
                } else {
                    topbar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void bindViews() {
        this.seemoreBtnLayout = (LinearLayout) findViewById(R.id.seemoreBtnLayout);
        this.notifyBtnLayout = (LinearLayout) findViewById(R.id.notifyBtnLayout);
        this.messageBtnLayout = (LinearLayout) findViewById(R.id.messageBtnLayout);
        this.requestBtnLayout = (LinearLayout) findViewById(R.id.requestBtnLayout);
        this.newspeedBtnLayout = (LinearLayout) findViewById(R.id.newspeedBtnLayout);
        this.mainViewPager = (ViewPager) findViewById(R.id.mainViewPager);
        this.titleTxt = (TextView) findViewById(R.id.titleTxt);
        this.topbar = (LinearLayout) findViewById(R.id.topbar);
        this.statusLot = (LinearLayout) findViewById(R.id.statusLot);
    }

    class MyPagerAdapter extends FragmentStatePagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return new NewSpeedFragment();
            } else if (position == 1) {
                return new RequestFragment();
            } else if (position == 2) {
                return new MessageFragment();
            } else if (position == 3) {
                return new NotifyFragment();
            } else {
                return new SeeMoreFragment();
            }
        }


    }
}

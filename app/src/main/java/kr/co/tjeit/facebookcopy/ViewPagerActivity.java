package kr.co.tjeit.facebookcopy;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import kr.co.tjeit.facebookcopy.fragment.NotifyFragment;
import kr.co.tjeit.facebookcopy.fragment.MessageFragment;
import kr.co.tjeit.facebookcopy.fragment.NewSpeedFragment;
import kr.co.tjeit.facebookcopy.fragment.RequestFragment;
import kr.co.tjeit.facebookcopy.fragment.SeeMoreFragment;

/**
 * Created by the on 2017-08-04.
 */

public class ViewPagerActivity extends AppCompatActivity {
    ViewPager mainViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        mainViewPager = (ViewPager) findViewById(R.id.mainViewPager);
        mainViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
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

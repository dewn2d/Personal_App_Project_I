package com.example.dwayne.project_i;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public class CardActivity extends FragmentActivity {

    private int NUM_PAGES = 0;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    CardDbHelper mDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card);

        // Instantiate a ViewPager and a PagerAdapter.
        mPager = (ViewPager) findViewById(R.id.pager);
        mPagerAdapter = new CardAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);
        mDbHelper = new CardDbHelper(this);
    }

    private class CardAdapter extends FragmentStatePagerAdapter {
        public CardAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return CardFragment.create(position, mDbHelper);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }


}

package com.stpan.chitchat.ui.main;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.stpan.chitchat.MyApplication;
import com.stpan.chitchat.R;
import com.stpan.chitchat.injector.components.DaggerActivityComponent;
import com.stpan.chitchat.ui.BaseActivity;
import com.stpan.chitchat.utils.ComponentHolder;
import com.stpan.chitchat.utils.StatusBarCompat;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    @Bind(R.id.dl_act_main)
    DrawerLayout drawerLayout;
    @Bind(R.id.nv_act_main)
    NavigationView navigationView;
    @Bind(R.id.tv_act_fort_awesome1)
    TextView textViewFort1;
    @Bind(R.id.tv_act_fort_awesome2)
    TextView textViewFort2;
    @Bind(R.id.tv_act_fort_awesome3)
    TextView textViewFort3;
    @Bind(R.id.tv_act_fort_detail1)
    TextView textViewDetail1;
    @Bind(R.id.tv_act_fort_detail2)
    TextView textViewDetail2;
    @Bind(R.id.tv_act_fort_detail3)
    TextView textViewDetail3;
    @Bind(R.id.ll_act_fort_awesome)
    LinearLayout llActFortAwesome;
    @Bind(R.id.vp_main)
    ViewPager viewPager;


    private ActionBarDrawerToggle toggle;

    @Inject
    MyApplication myApplication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        StatusBarCompat.setStatusBarBase(this);
        init();
        initViewPager();
    }

    private void init() {
        ButterKnife.bind(this);
        Typeface typeface = myApplication.getTypeface();
        DaggerActivityComponent.builder()
                .chitChatApplicationComponent(ComponentHolder.getApplicationComponent())
                .build().injectMainActivity(this);
        textViewFort1.setTypeface(typeface);
        textViewFort2.setTypeface(typeface);
        textViewFort3.setTypeface(typeface);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                drawerLayout.getChildAt(0).animate()
                        .translationX(navigationView.getMeasuredWidth() * slideOffset)
                        .setDuration(0).start();
            }
        };
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        /*Intent intent = new Intent(MainActivity.this, MessageService.class);
        startService(intent);*/
    }

    private void initViewPager(){
        List<Fragment> list = new ArrayList<>();
        list.add(MessageFragment.newInstance());
        list.add(FriendsFragment.newInstance());
        list.add(DynamicFragment.newInstance());
        MainAdapter adapter = new MainAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:checkOne();break;
                    case 1:checkTwo();break;
                    case 2:checkThree();break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.menu_one:
                System.out.println("one");
                break;
            case R.id.menu_two:
                System.out.println("two");
                break;
            case R.id.menu_three:
                System.out.println("three");
                break;
            case R.id.menu_four:
                System.out.println("four");
                break;
            case R.id.menu_five:
                System.out.println("five");
                break;
            case R.id.menu_six:
                System.out.println("six");
                break;
        }
        return false;
    }

    @OnClick({R.id.tv_act_fort_awesome1, R.id.tv_act_fort_awesome2, R.id.tv_act_fort_awesome3, R.id.tv_act_fort_detail1, R.id.tv_act_fort_detail2, R.id.tv_act_fort_detail3})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_act_fort_awesome1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.tv_act_fort_awesome2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.tv_act_fort_awesome3:
                viewPager.setCurrentItem(2);
                break;
            case R.id.tv_act_fort_detail1:
                viewPager.setCurrentItem(0);
                break;
            case R.id.tv_act_fort_detail2:
                viewPager.setCurrentItem(1);
                break;
            case R.id.tv_act_fort_detail3:
                viewPager.setCurrentItem(2);
                break;
        }
    }

    private void checkOne(){
        textViewFort1.setText(R.string.fa_comments);
        textViewFort1.setTextColor(getResources().getColor(R.color.colorPrimary));
        textViewDetail1.setTextColor(getResources().getColor(R.color.colorPrimary));

        textViewFort2.setText(R.string.fa_heart_o);
        textViewFort2.setTextColor(getResources().getColor(R.color.gray_700));
        textViewDetail2.setTextColor(getResources().getColor(R.color.gray_700));

        textViewFort3.setText(R.string.fa_star_o);
        textViewFort3.setTextColor(getResources().getColor(R.color.gray_700));
        textViewDetail3.setTextColor(getResources().getColor(R.color.gray_700));
    }
    private void checkTwo(){
        textViewFort1.setText(R.string.fa_comments_o);
        textViewFort1.setTextColor(getResources().getColor(R.color.gray_700));
        textViewDetail1.setTextColor(getResources().getColor(R.color.gray_700));

        textViewFort2.setText(R.string.fa_heart);
        textViewFort2.setTextColor(getResources().getColor(R.color.colorPrimary));
        textViewDetail2.setTextColor(getResources().getColor(R.color.colorPrimary));

        textViewFort3.setText(R.string.fa_star_o);
        textViewFort3.setTextColor(getResources().getColor(R.color.gray_700));
        textViewDetail3.setTextColor(getResources().getColor(R.color.gray_700));
    }
    private void checkThree(){
        textViewFort1.setText(R.string.fa_comments_o);
        textViewFort1.setTextColor(getResources().getColor(R.color.gray_700));
        textViewDetail1.setTextColor(getResources().getColor(R.color.gray_700));

        textViewFort2.setText(R.string.fa_heart_o);
        textViewFort2.setTextColor(getResources().getColor(R.color.gray_700));
        textViewDetail2.setTextColor(getResources().getColor(R.color.gray_700));

        textViewFort3.setText(R.string.fa_star);
        textViewFort3.setTextColor(getResources().getColor(R.color.colorPrimary));
        textViewDetail3.setTextColor(getResources().getColor(R.color.colorPrimary));
    }
}

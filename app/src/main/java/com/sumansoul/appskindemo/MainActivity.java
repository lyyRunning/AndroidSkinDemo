package com.sumansoul.appskindemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.SkinAppCompatDelegateImpl;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView activityMainToolbarImgMore;
    private DrawerLayout activityMainDrawerlayout;
    private LinearLayout menuLeftLayout;
    private CardView menuLeftLayoutCdChangeskin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainToolbarImgMore = (ImageView) findViewById(R.id.activity_main_toolbar_img_more);

        activityMainDrawerlayout = (DrawerLayout) findViewById(R.id.activity_main_drawerlayout);
        menuLeftLayout = (LinearLayout) findViewById(R.id.menu_left_layout);
        menuLeftLayoutCdChangeskin = (CardView) findViewById(R.id.menu_left_layout_cd_changeskin);


        activityMainToolbarImgMore.setOnClickListener(this);
        menuLeftLayoutCdChangeskin.setOnClickListener(this);

    }

    @NonNull
    @Override
    public AppCompatDelegate getDelegate() {
        return SkinAppCompatDelegateImpl.get(this, this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_main_toolbar_img_more:
                switchLeftMenu();
                break;
            case R.id.menu_left_layout_cd_changeskin:
                startActivity(new Intent(this,ChangeSkinActivity.class));
                break;
        }
    }


    private void switchLeftMenu(){
        if (activityMainDrawerlayout.isDrawerOpen(menuLeftLayout)) {
            activityMainDrawerlayout.closeDrawer(menuLeftLayout);
        } else {
            activityMainDrawerlayout.openDrawer(menuLeftLayout);
        }
    }
}
package com.sumansoul.appskindemo;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.app.SkinAppCompatDelegateImpl;
import androidx.cardview.widget.CardView;

import skin.support.SkinCompatManager;

/**
 * @ProjectName: AndroidSkinDemo
 * @Package: com.itfitness.androidskindemo
 * @ClassName: ChangeSkinActivity
 * @Description: java类作用描述
 * @Author: LML
 * @CreateDate: 2018/9/19 16:03
 * @UpdateUser: 更新者：
 * @UpdateDate: 2018/9/19 16:03
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */

public class ChangeSkinActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView activityChangeskinToolbarImgBack;
    private CardView activityChangeskinCdBlue;
    private CardView activityChangeskinCdBlack;
    private CardView red;
    private CardView yellow;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeskin);

        activityChangeskinToolbarImgBack = (ImageView) findViewById(R.id.activity_changeskin_toolbar_img_back);
        activityChangeskinCdBlue = (CardView) findViewById(R.id.activity_changeskin_cd_blue);
        activityChangeskinCdBlack = (CardView) findViewById(R.id.activity_changeskin_cd_black);
        red = (CardView) findViewById(R.id.activity_changeskin_cd_red);
        yellow = (CardView) findViewById(R.id.activity_changeskin_cd_yellow);
        activityChangeskinToolbarImgBack.setOnClickListener(this);
        activityChangeskinCdBlue.setOnClickListener(this);
        activityChangeskinCdBlack.setOnClickListener(this);
        red.setOnClickListener(this);
        yellow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_changeskin_toolbar_img_back:
                finish();
                break;
            case R.id.activity_changeskin_cd_blue:
                Toast.makeText(ChangeSkinActivity.this,"切换蓝色",Toast.LENGTH_SHORT).show();
                //设置默认颜色
                SkinCompatManager.getInstance().restoreDefaultTheme();
                break;
            case R.id.activity_changeskin_cd_black:
                Toast.makeText(ChangeSkinActivity.this,"切换暗黑色",Toast.LENGTH_SHORT).show();
                //设置暗黑色
                SkinCompatManager.getInstance().loadSkin("night", null, SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);
                break;
            case R.id.activity_changeskin_cd_red:
                Toast.makeText(ChangeSkinActivity.this,"切换红色",Toast.LENGTH_SHORT).show();
                //设置红色
                SkinCompatManager.getInstance().loadSkin("red", null, SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);
                break;
            case R.id.activity_changeskin_cd_yellow:
                Toast.makeText(ChangeSkinActivity.this,"切换黄色",Toast.LENGTH_SHORT).show();
                //设置黄色
                SkinCompatManager.getInstance().loadSkin("yellow", null, SkinCompatManager.SKIN_LOADER_STRATEGY_BUILD_IN);
                break;

            default:
                break;
        }
    }


    @NonNull
    @Override
    public AppCompatDelegate getDelegate() {
        return SkinAppCompatDelegateImpl.get(this, this);
    }
}

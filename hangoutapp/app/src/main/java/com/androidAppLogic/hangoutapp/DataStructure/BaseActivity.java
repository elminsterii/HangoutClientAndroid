package com.androidAppLogic.hangoutapp.DataStructure;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by yoie7 on 2018/5/3.
 */

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //bind initial layout
        initView();
        initData();
        initListner();
    }

    protected void initView(){
        //bind view content
    }
    protected void initData(){
        //set data
    }
    protected void initListner(){
        //bind listner
    }





}

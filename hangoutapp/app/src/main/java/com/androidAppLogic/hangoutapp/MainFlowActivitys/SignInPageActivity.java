package com.androidAppLogic.hangoutapp.MainFlowActivitys;

import android.os.Bundle;
import com.androidAppLogic.hangoutapp.R;
import com.androidAppLogic.hangoutapp.DataStructure.BaseActivity;

/**
 * Created by yoie7 on 2018/5/3.
 */

public class SignInPageActivity extends BaseActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_page);
    }

    @Override
    protected void initView(){

    }

    @Override
    protected void initData(){

    }

    @Override
    protected void initListner(){

    }


    private class SignInPageLogic{

        public boolean isPwdValid(String pwd){
            boolean result = false;
            return result;
        }

        public boolean signIn(String acount, String pwd){
            boolean result = false;
            return result;
        }
    }
}

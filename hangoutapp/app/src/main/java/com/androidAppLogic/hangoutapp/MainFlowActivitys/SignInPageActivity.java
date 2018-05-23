package com.androidAppLogic.hangoutapp.MainFlowActivitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidAppLogic.hangoutapp.DataStructure.PersonAttributes;
import com.androidAppLogic.hangoutapp.HttpConnect.Task.Abstract.AsyncResponder;
import com.androidAppLogic.hangoutapp.HttpConnect.Task.Implement.DoPersonLogInTask;
import com.androidAppLogic.hangoutapp.MainFlowActivitys.ReigisterFlow.RegisterInterestPageActivity;
import com.androidAppLogic.hangoutapp.MainFlowActivitys.ReigisterFlow.RegisterPrimaryPageActivity;
import com.androidAppLogic.hangoutapp.R;
import com.androidAppLogic.hangoutapp.DataStructure.BaseActivity;
import com.androidAppLogic.hangoutapp.Tool.ParserUtils;

import java.util.HashMap;
import java.util.Map;

import static com.androidAppLogic.hangoutapp.MainFlowActivitys.ReigisterFlow.RegisterPrimaryPageActivity.API_RESPONSE_TAG;

/**
 * Created by yoie7 on 2018/5/3.
 */

public class SignInPageActivity extends BaseActivity{

    private EditText mEditText_Account;
    private EditText mEditText_Password;
    private Button mButton_SignIn;
    private Button mButton_Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_signin_page);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView(){
        super.initView();
        mEditText_Account = (EditText) findViewById(R.id.edit_account);
        mEditText_Password = (EditText) findViewById(R.id.edit_pwd);
        mButton_SignIn = (Button)findViewById(R.id.btn_signin);
        mButton_Register = (Button)findViewById(R.id.btn_register);

    }

    @Override
    protected void initData(){
        super.initData();

    }

    @Override
    protected void initListner(){


        mButton_SignIn.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, RegisterInterestPageActivity.class);
                startActivity(intent);
//                Map<String, Object> registerList = new HashMap<String, Object>();
//                registerList.put(PersonAttributes.ATTRIBUTES_PERSON_ACCOUNT, mEditText_Account.getText().toString());
//                registerList.put(PersonAttributes.ATTRIBUTES_PERSON_PASSWORD, mEditText_Password.getText().toString());
//                DoPersonLogInTask task = new DoPersonLogInTask(mActivity,
//                        new AsyncResponder<String>() {
//                            @Override
//                            public void onSuccess(String strResponse) {
//                                Toast.makeText(SignInPageActivity.this, "doLogin OK", Toast.LENGTH_SHORT).show();
//
//                                boolean result = false;
//                                if (ParserUtils.getValueByTag(API_RESPONSE_TAG, strResponse).contains("0")) {
//                                    result = true;
//                                    Toast.makeText(SignInPageActivity.this, "doLogin OK", Toast.LENGTH_SHORT).show();
//                                } else {
//                                    result = false;
//                                    Toast.makeText(SignInPageActivity.this, "doLogin Failed", Toast.LENGTH_SHORT).show();
//
//                                }
//
//                            }
//                        });
//                task.execute(registerList);

            }
        });

        mButton_Register.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, RegisterPrimaryPageActivity.class);
                startActivity(intent);
            }
        });

    }



}

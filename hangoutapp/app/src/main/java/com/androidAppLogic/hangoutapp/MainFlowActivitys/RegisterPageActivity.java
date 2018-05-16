package com.androidAppLogic.hangoutapp.MainFlowActivitys;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.androidAppLogic.hangoutapp.DataStructure.BaseActivity;
import com.androidAppLogic.hangoutapp.HttpConnect.HttpProxy;
import com.androidAppLogic.hangoutapp.HttpConnect.Task.Abstract.AsyncResponder;
import com.androidAppLogic.hangoutapp.HttpConnect.Task.Implement.DoPersonRegisterTask;
import com.androidAppLogic.hangoutapp.R;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import com.androidAppLogic.hangoutapp.Tool.BitmapAndStringUtils;
import com.androidAppLogic.hangoutapp.Tool.JsonUtils;

/**
 * Created by yoie7 on 2018/5/4.
 */

public class RegisterPageActivity extends BaseActivity {

    //                      Person Attr.
    public static final int AGE_LIMITATION = 18;
    public static final String REGISTER_ATTRIBUTES_PERSON_ACCOUNT = "email";
    public static final String REGISTER_ATTRIBUTES_PERSON_PASSWORD = "userpassword";
    public static final String REGISTER_ATTRIBUTES_PERSON_NAME = "displayname";
    public static final String REGISTER_ATTRIBUTES_PERSON_GENDER = "gender";
    public static final String REGISTER_ATTRIBUTES_PERSON_AGE = "age";
    public static final String REGISTER_ATTRIBUTES_PERSON_LOCATION = "location";
    public static final String REGISTER_ATTRIBUTES_PERSON_INTERESTS = "interests";
    public static final String REGISTER_ATTRIBUTES_PERSON_DESCRIPTION = "description";
    public static final String REGISTER_ATTRIBUTES_PERSON_JOIN_ACTIVITY = "joinactivities";
    public static final String REGISTER_ATTRIBUTES_PERSON_HOLD_ACTIVITY = "holdactivities";
    public static final String REGISTER_ATTRIBUTES_PERSON_GOOD_MEMBER = "goodmember";
    public static final String REGISTER_ATTRIBUTES_PERSON_GOOD_LEADER = "goodleader";
    public static final String REGISTER_ATTRIBUTES_PERSON_NEW_PASSWORD = "newuserpassword";
    public static final String REGISTER_ATTRIBUTES_PERSON_ONLINE = "online";

    //                      Activity Attr.
    public static final String REGISTER_ATTRIBUTES_ACTIVITY_ID = "id";
    public static final String REGISTER_ATTRIBUTES_ACTIVITY_IDS = "ids";
    public static final String REGISTER_ATTRIBUTES_ACTIVITY_PUBLISHER_EMAIL = "publisheremail";
    public static final String REGISTER_ATTRIBUTES_ACTIVITY_PUBLISHER_PASSWORD = "publisheruserpassword";
    public static final String REGISTER_ATTRIBUTES_ACTIVITY_PUBLISH_BEGIN = "publishbegin";
    public static final String REGISTER_ATTRIBUTES_ACTIVITY_PUBLISH_END = "publishend";
    public static final String REGISTER_ATTRIBUTES_ACTIVITY_LARGE_ACTIVITY = "largeactivity";
    public static final String REGISTER_ATTRIBUTES_ACTIVITY_EARLY_BIRD = "earlybird";
    public static final String REGISTER_ATTRIBUTES_ACTIVITY_DISPLAYNAME = "displayname";
    public static final String REGISTER_ATTRIBUTES_ACTIVITY_DATE_BEGIN = "datebegin";
    public static final String REGISTER_ATTRIBUTES_ACTIVITY_DATE_END = "dateend";
    public static final String REGISTER_ATTRIBUTES_ACTIVITY_LOCATION = "location";
    public static final String REGISTER_ATTRIBUTES_ACTIVITY_IMAGE = "image";
    public static final String REGISTER_ATTRIBUTES_ACTIVITY_DESCRIPTION = "description";
    public static final String REGISTER_ATTRIBUTES_ACTIVITY_TAGS = "tags";
    public static final String REGISTER_ATTRIBUTES_ACTIVITY_GOOD_ACTIVITY = "goodactivity";
    public static final String REGISTER_ATTRIBUTES_ACTIVITY_ATTENTION = "attention";
    public static final String REGISTER_ATTRIBUTES_ACTIVITY_ATTENDEES = "attendees";


    public static final String API_RESPONSE_TAG = "statuscode";



    private EditText mEditText_Account;
    private EditText mEditText_Password;
    private EditText mEditText_Name;
    private RadioGroup mRadio_Gender;
    private Spinner mSpinner_Age;
    private Button mButton_Done;

    private String m_strGender = "";
    private String m_strAge = "";
    private Activity mActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_register_page);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView(){
        mEditText_Account = (EditText) findViewById(R.id.edit_account);
        mEditText_Password = (EditText) findViewById(R.id.edit_pwd);
        mEditText_Name = (EditText) findViewById(R.id.edit_name);
        mSpinner_Age = (Spinner) findViewById(R.id.spinner_age);
        mRadio_Gender = (RadioGroup)findViewById(R.id.radioG_gender);
        mButton_Done = (Button)findViewById(R.id.btn_done);

    }

    @Override
    protected void initData(){
        super.initData();
    }

    @Override
    protected void initListner(){


        mRadio_Gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId)
                    {
                        if(checkedId == R.id.radio_gender_male)
                        {
                            m_strGender = "M";
                        }
                        else if(checkedId == R.id.radio_gender_female)
                        {
                            m_strGender = "F";
                        }
                    }
                });



        mSpinner_Age.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                m_strAge = String.valueOf(AGE_LIMITATION + position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mButton_Done.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                Map<String, Object> jsonMap1 = new HashMap<String, Object>();
                jsonMap1.put(REGISTER_ATTRIBUTES_PERSON_ACCOUNT, "yoie1@gmail.com");
                jsonMap1.put(REGISTER_ATTRIBUTES_PERSON_PASSWORD, "12345678");
                jsonMap1.put(REGISTER_ATTRIBUTES_PERSON_NAME, "yyyyy");
                jsonMap1.put(REGISTER_ATTRIBUTES_PERSON_GENDER, "M");

                jsonMap1.put(REGISTER_ATTRIBUTES_PERSON_LOCATION, "12345ggg");
                jsonMap1.put(REGISTER_ATTRIBUTES_PERSON_AGE, 54);
                jsonMap1.put(REGISTER_ATTRIBUTES_PERSON_INTERESTS, "ball");
                jsonMap1.put(REGISTER_ATTRIBUTES_PERSON_NEW_PASSWORD, "wqwqwqdddddddwqw");


                DoPersonRegisterTask task = new DoPersonRegisterTask(mActivity,
                        new AsyncResponder<String>() {
                            @Override
                            public void onSuccess(String strResponse) {
                                Toast.makeText(RegisterPageActivity.this, "doRegister OK", Toast.LENGTH_SHORT).show();

                                boolean result = false;
                                if (JsonUtils.getValueByTag(API_RESPONSE_TAG,strResponse).contains("0")) {
                                    result = true;
                                    Toast.makeText(RegisterPageActivity.this, "doRegister OK", Toast.LENGTH_SHORT).show();
                                }
                                else
                                result =  false;


                            }
                        });
                task.execute(jsonMap1);


            }

        });
    }





}



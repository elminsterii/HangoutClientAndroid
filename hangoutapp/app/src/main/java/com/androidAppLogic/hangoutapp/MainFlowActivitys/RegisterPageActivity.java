package com.androidAppLogic.hangoutapp.MainFlowActivitys;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import com.androidAppLogic.hangoutapp.DataStructure.BaseActivity;
import com.androidAppLogic.hangoutapp.HttpConnect.HttpProxy;
import com.androidAppLogic.hangoutapp.R;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by yoie7 on 2018/5/4.
 */

public class RegisterPageActivity extends BaseActivity {


    public static final int AGE_LIMITATION = 18;
    public static final String REGISTER_ATTRIBUTES_ACCOUNT = "email";
    public static final String REGISTER_ATTRIBUTES_PASSWORD = "password";
    public static final String REGISTER_ATTRIBUTES_NAME = "displayname";
    public static final String REGISTER_ATTRIBUTES_Gender = "gender";
    public static final String REGISTER_ATTRIBUTES_Age = "age";

    private EditText mEditText_Account;
    private EditText mEditText_Password;
    private EditText mEditText_Name;
    private RadioGroup mRadio_Gender;
    private Spinner mSpinner_Age;
    private Button mButton_Done;

    private String m_strGender = "";
    private String m_strAge = "";



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
                /*
                RegisterPageLogic.doRegister(   mEditText_Account.getText().toString(),
                                                mEditText_Password.getText().toString(),
                                                mEditText_Name.getText().toString(),
                                                m_strGender,
                                                m_strAge);
                */
                RegisterPageLogic.doRegister("aaaa",
                        "bbb",
                        "ccc",
                        "ddd",
                        "eee");
            }

        });
    }

    private static class RegisterPageLogic{
        public static boolean doRegister(String strAccount,
                                  String strPwd,
                                  String strName,
                                  String strGender,
                                  String strAge) {
            boolean result = false;

            HttpProxy.HttpPostTask pTask = new HttpProxy.HttpPostTask(new HttpProxy.AsyncResponse() {
                @Override
                public boolean processFinish(boolean output) {
                    return output;
                }
            });
            Map<String, String> jsonMap1 = new HashMap<String, String>();
            jsonMap1.put(REGISTER_ATTRIBUTES_ACCOUNT, strAccount);
            //jsonMap1.put(REGISTER_ATTRIBUTES_PASSWORD, strPwd);
            //jsonMap1.put(REGISTER_ATTRIBUTES_NAME, strName);
            //jsonMap1.put(REGISTER_ATTRIBUTES_Gender, strGender);
            //jsonMap1.put(REGISTER_ATTRIBUTES_Age, strAge);


            pTask.execute(jsonMap1, HttpProxy.HTTP_POST_API_REGISTER);
            try {
                String response  = pTask.get();
                if (response.contains("200 OK "))
                    result = true;
                else
                    result =  false;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            return result;
        }
    }

}



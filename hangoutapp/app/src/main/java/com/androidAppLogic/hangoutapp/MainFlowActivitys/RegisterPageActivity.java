package com.androidAppLogic.hangoutapp.MainFlowActivitys;

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
    public static final String REGISTER_ATTRIBUTES_PASSWORD = "userpassword";
    public static final String REGISTER_ATTRIBUTES_NAME = "displayname";
    public static final String REGISTER_ATTRIBUTES_GENDER = "gender";
    public static final String REGISTER_ATTRIBUTES_AGE = "age";
    public static final String REGISTER_ATTRIBUTES_LOCATION = "location";
    public static final String REGISTER_ATTRIBUTES_INTERESTS = "interests";

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
                //doRegister("Jimmy10545454111@gmail.com","12345","Jimmy44441","Male","32");
                //doQueryPerson("Jimmy10545454111@gmail.com");
                Map<String, Object> jsonMap1 = new HashMap<String, Object>();
                jsonMap1.put(REGISTER_ATTRIBUTES_LOCATION, "12345ggg");
                jsonMap1.put(REGISTER_ATTRIBUTES_AGE, 54);
                jsonMap1.put(REGISTER_ATTRIBUTES_INTERESTS, "ball");

                //doUpdatePerson("Jimmy10545454111@gmail.com",jsonMap1);
                //doQueryPerson("Jimmy10545454111@gmail.com");
                //doLogIn("Jimmy10545454111@gmail.com","12345");
                //doLogOut("Jimmy10545454111@gmail.com","12345");
                doUnRegister("Jimmy10545454111@gmail.com","12345");


            }

        });
    }

    public boolean doRegister(String strAccount,
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
        Map<String, Object> jsonMap1 = new HashMap<String, Object>();
        jsonMap1.put(REGISTER_ATTRIBUTES_ACCOUNT, strAccount);
        jsonMap1.put(REGISTER_ATTRIBUTES_PASSWORD, strPwd);
        jsonMap1.put(REGISTER_ATTRIBUTES_NAME, strName);
        jsonMap1.put(REGISTER_ATTRIBUTES_GENDER, strGender);
        jsonMap1.put(REGISTER_ATTRIBUTES_AGE, 32);


        pTask.execute(jsonMap1, HttpProxy.HTTP_POST_API_REGISTER);
        try {
            String response  = pTask.get();
            /*if (response.contains("200 OK ")) {
                result = true;
                Toast.makeText(RegisterPageActivity.this, "doRegister OK", Toast.LENGTH_SHORT).show();
            }
            else
                result =  false;
                */
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }


    public boolean doUnRegister(String strAccount, String strPwd) {
        boolean result = false;
        HttpProxy.HttpPostTask pTask = new HttpProxy.HttpPostTask(new HttpProxy.AsyncResponse() {
            @Override
            public boolean processFinish(boolean output) {
                return output;
            }
        });
        Map<String, String> jsonMap1 = new HashMap<String, String>();
        jsonMap1.put(REGISTER_ATTRIBUTES_ACCOUNT, strAccount);
        jsonMap1.put(REGISTER_ATTRIBUTES_PASSWORD, strPwd);
        pTask.execute(jsonMap1, HttpProxy.HTTP_POST_API_UNREGISTER);
        try {
            String response  = pTask.get();
            if (response.contains("200 OK ")) {
                result = true;
                Toast.makeText(RegisterPageActivity.this, "doUnRegister OK", Toast.LENGTH_SHORT).show();
            }
            else
                result =  false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean doQueryPerson(String strAccount) {
        boolean result = false;
        HttpProxy.HttpPostTask pTask = new HttpProxy.HttpPostTask(new HttpProxy.AsyncResponse() {
            @Override
            public boolean processFinish(boolean output) {
                return output;
            }
        });
        Map<String, String> jsonMap1 = new HashMap<String, String>();
        jsonMap1.put(REGISTER_ATTRIBUTES_ACCOUNT, strAccount);



        pTask.execute(jsonMap1, HttpProxy.HTTP_POST_API_QUERY_PERSON);
        try {
            String response  = pTask.get();
            if (response.contains("200 OK ")) {
                result = true;
                Toast.makeText(RegisterPageActivity.this, "doQueryPerson OK", Toast.LENGTH_SHORT).show();
            }
            else
                result =  false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean doLogIn(String strAccount, String strPwd) {
        boolean result = false;
        HttpProxy.HttpPostTask pTask = new HttpProxy.HttpPostTask(new HttpProxy.AsyncResponse() {
            @Override
            public boolean processFinish(boolean output) {
                return output;
            }
        });
        Map<String, String> jsonMap1 = new HashMap<String, String>();
        jsonMap1.put(REGISTER_ATTRIBUTES_ACCOUNT, strAccount);
        jsonMap1.put(REGISTER_ATTRIBUTES_PASSWORD, strPwd);
        pTask.execute(jsonMap1, HttpProxy.HTTP_POST_API_LOGIN);
        try {
            String response  = pTask.get();
            if (response.contains("200 OK ")) {
                result = true;
                Toast.makeText(RegisterPageActivity.this, "doLogIn OK", Toast.LENGTH_SHORT).show();
            }
            else
                result =  false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean doLogOut(String strAccount, String strPwd) {
        boolean result = false;
        HttpProxy.HttpPostTask pTask = new HttpProxy.HttpPostTask(new HttpProxy.AsyncResponse() {
            @Override
            public boolean processFinish(boolean output) {
                return output;
            }
        });
        Map<String, String> jsonMap1 = new HashMap<String, String>();
        jsonMap1.put(REGISTER_ATTRIBUTES_ACCOUNT, strAccount);
        jsonMap1.put(REGISTER_ATTRIBUTES_PASSWORD, strPwd);
        pTask.execute(jsonMap1, HttpProxy.HTTP_POST_API_LOGOUT);
        try {
            String response  = pTask.get();
            if (response.contains("200 OK ")) {
                result = true;
                Toast.makeText(RegisterPageActivity.this, "doLogOut OK", Toast.LENGTH_SHORT).show();
            }
            else
                result =  false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean doUpdatePerson(String strAccount,  Map<String, Object> updateList) {
        boolean result = false;
        HttpProxy.HttpPostTask pTask = new HttpProxy.HttpPostTask(new HttpProxy.AsyncResponse() {
            @Override
            public boolean processFinish(boolean output) {
                return output;
            }
        });
        updateList.put(REGISTER_ATTRIBUTES_ACCOUNT, strAccount);



        pTask.execute(updateList, HttpProxy.HTTP_POST_API_UPDATE_PERSON);
        try {
            String response  = pTask.get();
            if (response.contains("200 OK ")) {
                result = true;
                Toast.makeText(RegisterPageActivity.this, "doUpdatePerson OK", Toast.LENGTH_SHORT).show();
            }
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



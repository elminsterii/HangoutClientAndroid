package com.androidAppLogic.hangoutapp.MainFlowActivitys.ReigisterFlow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.androidAppLogic.hangoutapp.Adapter.RadioListAdapter;
import com.androidAppLogic.hangoutapp.DataStructure.BaseActivity;
import com.androidAppLogic.hangoutapp.HttpConnect.Task.Abstract.AsyncResponder;
import com.androidAppLogic.hangoutapp.HttpConnect.Task.Implement.DoPersonRegisterTask;
import com.androidAppLogic.hangoutapp.R;
import com.androidAppLogic.hangoutapp.Tool.ParserUtils;
import com.androidAppLogic.hangoutapp.Tool.SerializableHashMap;

import java.util.ArrayList;
import java.util.HashMap;

import static com.androidAppLogic.hangoutapp.MainFlowActivitys.ReigisterFlow.RegisterPrimaryPageActivity.API_RESPONSE_TAG;

/**
 * Created by yoie7 on 2018/5/21.
 */

public class RegisterInterestPageActivity extends BaseActivity {

    private String[] interests_item = { "SPORT", "MUSIC", "FOOD", "BOOK", "MOVIE",
            "CULTURE", "OUTSIDE", "INDOOR"};
    private HashMap<String, Object> mRegisterList = new HashMap<>();
    private Button mButton_Done;
    private ListView mInterestsListView;

    private RadioListAdapter mRadioListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_register_interest_page);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView(){
        super.initView();
        mButton_Done = (Button)findViewById(R.id.btn_next);
        mInterestsListView = (ListView) findViewById(R.id.interest_list);


    }

    @Override
    protected void initData(){
        super.initData();
//        Bundle bundle = getIntent().getExtras();
//        SerializableHashMap serializableHashMap = (SerializableHashMap) bundle.get("mapList");
//        mRegisterList = serializableHashMap.getObjectItems();
        ArrayList<Boolean> radioStateList = new ArrayList<Boolean>();
        for(int i = 0; i< interests_item.length; i++){
            radioStateList.add(false);
        }
        mRadioListAdapter = new RadioListAdapter(this, interests_item, radioStateList);
        mInterestsListView.setAdapter(mRadioListAdapter);
    }

    @Override
    protected void initListner(){

        mButton_Done.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<Boolean> radioStateList = new ArrayList<Boolean>();
                radioStateList = mRadioListAdapter.getRadioStateList();
                Toast.makeText(RegisterInterestPageActivity.this, "doLogin OK", Toast.LENGTH_SHORT).show();

            }
        });

//        DoPersonRegisterTask task = new DoPersonRegisterTask(mActivity,
//                new AsyncResponder<String>() {
//                    @Override
//                    public void onSuccess(String strResponse) {
//                        Toast.makeText(RegisterInterestPageActivity.this, "doRegister OK", Toast.LENGTH_SHORT).show();
//
//                        boolean result = false;
//                        if (ParserUtils.getValueByTag(API_RESPONSE_TAG,strResponse).contains("0")) {
//                            result = true;
//                            Toast.makeText(RegisterInterestPageActivity.this, "doRegister OK", Toast.LENGTH_SHORT).show();
//                        }
//                        else {
//                            result = false;
//                            Toast.makeText(RegisterInterestPageActivity.this, "doRegister Failed", Toast.LENGTH_SHORT).show();
//
//                        }
//
//                    }
//                });
//        task.execute(mRegisterList);

    }

    @Override
    protected void onResume(){
        super.onResume();

    }
}

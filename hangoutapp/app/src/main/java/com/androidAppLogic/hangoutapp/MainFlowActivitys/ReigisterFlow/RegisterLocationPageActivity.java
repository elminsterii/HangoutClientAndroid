package com.androidAppLogic.hangoutapp.MainFlowActivitys.ReigisterFlow;

import android.os.Bundle;
import com.androidAppLogic.hangoutapp.DataStructure.BaseActivity;
import com.androidAppLogic.hangoutapp.R;
import com.androidAppLogic.hangoutapp.Tool.SerializableHashMap;
import java.util.HashMap;


/**
 * Created by yoie7 on 2018/5/21.
 */

public class RegisterLocationPageActivity extends BaseActivity {

    private HashMap<String, Object> mRegisterList = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_register_location_page);
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView(){
        super.initView();


    }

    @Override
    protected void initData(){
        super.initData();
        Bundle bundle = getIntent().getExtras();
        SerializableHashMap serializableHashMap = (SerializableHashMap) bundle.get("mapList");
        mRegisterList = serializableHashMap.getObjectItems();
    }

    @Override
    protected void initListner(){


    }

    @Override
    protected void onResume(){
        super.onResume();

    }
}

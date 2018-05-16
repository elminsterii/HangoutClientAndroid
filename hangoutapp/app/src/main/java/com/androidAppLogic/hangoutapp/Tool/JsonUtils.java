package com.androidAppLogic.hangoutapp.Tool;

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yoie7 on 2018/4/27.
 */

public class JsonUtils {

    public static String createJsonString(Object value) {
                Gson gson = new Gson();
                String string = gson.toJson(value);
                return string;
     }

    public static String getValueByTag(String tag, String Body){
        String result = null;

        try {
            final JSONObject obj = new JSONObject(Body);
            result =  obj.getString(tag);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;

    }
}

package com.androidAppLogic.hangoutapp.Tool;

import com.androidAppLogic.hangoutapp.DataStructure.PersonAttributes;
import com.google.gson.Gson;

/**
 * Created by yoie7 on 2018/4/27.
 */

public class JsonUtils {

    public static String createJsonString(Object value) {
                Gson gson = new Gson();
                String string = gson.toJson(value);
                return string;
     }


}

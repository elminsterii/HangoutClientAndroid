package com.androidAppLogic.hangoutapp.Tool;

import com.androidAppLogic.hangoutapp.DataStructure.ActivityAttributes;
import com.androidAppLogic.hangoutapp.DataStructure.PersonAttributes;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by yoie7 on 2018/5/16.
 */

public class ParserUtils {

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

    public static PersonAttributes getPersonAttr(String Body){
        PersonAttributes result = new PersonAttributes();

        try {
            final JSONObject obj = new JSONObject(Body);
            Iterator x = obj.keys();
            while (x.hasNext()){
                String key = (String) x.next();
                if(key.contains(PersonAttributes.ATTRIBUTES_PERSON_ACCOUNT))
                    result.setEmail(obj.getString(key));
                else if(key.contains(PersonAttributes.ATTRIBUTES_PERSON_PASSWORD))
                    result.setPassword(obj.getString(key));
                else if(key.contains(PersonAttributes.ATTRIBUTES_PERSON_NAME))
                    result.setName(obj.getString(key));
                else if(key.contains(PersonAttributes.ATTRIBUTES_PERSON_DESCRIPTION))
                    result.setDescription(obj.getString(key));
                else if(key.contains(PersonAttributes.ATTRIBUTES_PERSON_GENDER))
                    result.setGender(obj.getString(key));
                else if(key.contains(PersonAttributes.ATTRIBUTES_PERSON_LOCATION))
                    result.setLocation(obj.getString(key));
                else if(key.contains(PersonAttributes.ATTRIBUTES_PERSON_AGE))
                    result.setAge(obj.getInt(key));
                else if(key.contains(PersonAttributes.ATTRIBUTES_PERSON_GOOD_LEADER))
                    result.setGoodLeader(obj.getInt(key));
                else if(key.contains(PersonAttributes.ATTRIBUTES_PERSON_GOOD_MEMBER))
                    result.setGoodMember(obj.getInt(key));
                else if(key.contains(PersonAttributes.ATTRIBUTES_PERSON_ONLINE))
                    result.setOnLine(obj.getInt(key));
                else if(key.contains(PersonAttributes.ATTRIBUTES_PERSON_INTERESTS))
                    result.setInterests(obj.getJSONArray(key));
                else if(key.contains(PersonAttributes.ATTRIBUTES_PERSON_JOIN_ACTIVITY))
                    result.setInterests(obj.getJSONArray(key));
                else if(key.contains(PersonAttributes.ATTRIBUTES_PERSON_HOLD_ACTIVITY))
                    result.setInterests(obj.getJSONArray(key));
                else if(key.contains(PersonAttributes.ATTRIBUTES_PERSON_SAVE_ACTIVITY))
                    result.setInterests(obj.getJSONArray(key));


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ActivityAttributes getACtivityAttr(String Body){
        ActivityAttributes result = new ActivityAttributes();

        try {
            final JSONObject obj = new JSONObject(Body);
            Iterator x = obj.keys();
            while (x.hasNext()){
                String key = (String) x.next();
                if(key.contains(ActivityAttributes.ATTRIBUTES_ACTIVITY_PUBLISHER_EMAIL))
                    result.setPublisherEmail(obj.getString(key));
                else if(key.contains(ActivityAttributes.ATTRIBUTES_ACTIVITY_PUBLISHER_PASSWORD))
                    result.setPublisherPwd(obj.getString(key));
                else if(key.contains(ActivityAttributes.ATTRIBUTES_ACTIVITY_DISPLAYNAME))
                    result.setName(obj.getString(key));
                else if(key.contains(ActivityAttributes.ATTRIBUTES_ACTIVITY_LOCATION))
                    result.setLocation(obj.getString(key));
                else if(key.contains(ActivityAttributes.ATTRIBUTES_ACTIVITY_DESCRIPTION))
                    result.setDescription(obj.getString(key));
                else if(key.contains(ActivityAttributes.ATTRIBUTES_ACTIVITY_PUBLISH_BEGIN))
                    result.setPublisBegin(obj.getLong(key));
                else if(key.contains(ActivityAttributes.ATTRIBUTES_ACTIVITY_PUBLISH_END))
                    result.setPublisEnd(obj.getLong(key));
                else if(key.contains(ActivityAttributes.ATTRIBUTES_ACTIVITY_DATE_BEGIN))
                    result.setDateBegin(obj.getLong(key));
                else if(key.contains(ActivityAttributes.ATTRIBUTES_ACTIVITY_DATE_END))
                    result.setDateEnd(obj.getLong(key));
                else if(key.contains(ActivityAttributes.ATTRIBUTES_ACTIVITY_LARGE_ACTIVITY))
                    result.setLargeActivity(obj.getBoolean(key));
                else if(key.contains(ActivityAttributes.ATTRIBUTES_ACTIVITY_EARLY_BIRD))
                    result.setEarlyBird(obj.getBoolean(key));
                else if(key.contains(ActivityAttributes.ATTRIBUTES_ACTIVITY_ATTENDEES))
                    result.setAttendees(obj.getJSONArray(key));
                else if(key.contains(ActivityAttributes.ATTRIBUTES_ACTIVITY_ATTENTION))
                    result.setAttention(obj.getInt(key));
                else if(key.contains(ActivityAttributes.ATTRIBUTES_ACTIVITY_GOOD_ACTIVITY))
                    result.setGoodActivity(obj.getInt(key));
                else if(key.contains(ActivityAttributes.ATTRIBUTES_ACTIVITY_TAGS))
                    result.setTags(obj.getJSONArray(key));
                else if(key.contains(ActivityAttributes.ATTRIBUTES_ACTIVITY_ID))
                    result.setId(obj.getInt(key));
                else if(key.contains(ActivityAttributes.ATTRIBUTES_ACTIVITY_STATUS))
                    result.setStatus(obj.getString(key));


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String listStringToString(ArrayList<String> lsString, char splitChar) {
        if(lsString == null || lsString.isEmpty())
            return "";

        StringBuilder strBuilder = new StringBuilder();
        for(String str : lsString) {
            if(str != null && !str.isEmpty())
                strBuilder.append(str).append(splitChar);
        }

        if(strBuilder.length() > 0)
            strBuilder.deleteCharAt(strBuilder.length()-1);

        return strBuilder.toString();
    }

    public static String arrayStringToString(String[] arrString, char splitChar) {
        if(arrString == null || arrString.length <= 0)
            return "";

        StringBuilder strBuilder = new StringBuilder();
        for(String str : arrString) {
            if(str != null && !str.isEmpty())
                strBuilder.append(str).append(splitChar);
        }

        if(strBuilder.length() > 0)
            strBuilder.deleteCharAt(strBuilder.length()-1);

        return strBuilder.toString();
    }


}

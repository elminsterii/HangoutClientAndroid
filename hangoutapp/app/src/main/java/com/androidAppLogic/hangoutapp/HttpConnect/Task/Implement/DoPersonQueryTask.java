package com.androidAppLogic.hangoutapp.HttpConnect.Task.Implement;

import android.app.Activity;

import com.androidAppLogic.hangoutapp.HttpConnect.HttpProxy;
import com.androidAppLogic.hangoutapp.HttpConnect.Task.Abstract.AsyncResponder;
import com.androidAppLogic.hangoutapp.HttpConnect.Task.Abstract.HttpPostAbstractTask;
import com.androidAppLogic.hangoutapp.Tool.JsonUtils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by yoie7 on 2018/5/16.
 */

public class DoPersonQueryTask<Object> extends HttpPostAbstractTask<Object> {
    public DoPersonQueryTask(Activity activity, AsyncResponder<String> responder) {
        super(activity,responder);
    }
    @Override
    protected String access(Activity activity, Object info) {
        {
            boolean result = false;
            URL url = null;
            BufferedReader reader = null;
            StringBuilder stringBuilder;
            String jsonString = JsonUtils.createJsonString(info);

            try
            {
                // create the HttpURLConnection
                url = new URL(String.valueOf(HttpProxy.HTTP_POST_API_PERSON_QUERY_));
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                // 使用甚麼方法做連線
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
                connection.setRequestProperty("Accept", "application/json");
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(HttpProxy.HTTP_POST_TIMEOUT*1000);
                connection.setReadTimeout(10000);
                connection.setDoInput(true);                                                        //允許輸入流，即允許下載
                connection.setDoOutput(true);                                                       //允許輸出流，即允許上傳
                connection.setUseCaches(false);                                                     //設置是否使用緩存
                //connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded"); //设置请求体的类型是文本类型
                connection.setRequestProperty("Content-Length", String.valueOf(jsonString.length()));                              //設定內容長度

                // 是否添加參數(ex : json...等)
                //connection.setDoOutput(true);

                // 設定TimeOut時間
                connection.connect();

                // 伺服器回來的參數

                // output body
                OutputStream os = connection.getOutputStream();
                DataOutputStream writer = new DataOutputStream(os);
                writer.writeBytes(jsonString);
                writer.flush();
                writer.close();
                os.close();


                //response body
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                stringBuilder = new StringBuilder();

                String line = null;
                while ((line = reader.readLine()) != null)
                {
                    stringBuilder.append(line + "\n");
                }
                return stringBuilder.toString();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                // close the reader; this can throw an exception too, so
                // wrap it in another try/catch block.
                if (reader != null)
                {
                    try
                    {
                        reader.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }

            return  null;

        }

    }
}

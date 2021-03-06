package com.androidAppLogic.hangoutapp.HttpConnect;


import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.androidAppLogic.hangoutapp.Tool.JsonUtils;
/**
 * Created by yoie7 on 2018/4/27.
 */

public class HttpProxy {

    public interface AsyncResponse {
        boolean processFinish(boolean output);
    }
    public static final String HTTP_POST_API_REGISTER =   "https://hangouttw.appspot.com/register";
    public static final String HTTP_POST_API_UNREGISTER = "https://hangouttw.appspot.com/unregister";
    public static final String HTTP_POST_API_LOGIN = "https://hangouttw.appspot.com/login";
    public static final String HTTP_POST_API_LOGOUT = "https://hangouttw.appspot.com/logout";
    public static final String HTTP_POST_API_PERSON_QUERY_ = "https://hangouttw.appspot.com/queryperson";
    public static final String HTTP_POST_API_PERSON_UPDATE = "https://hangouttw.appspot.com/updateperson";
    public static final String HTTP_POST_API_ACTIVITY_CREATE = "https://hangouttw.appspot.com/createactivity";
    public static final String HTTP_POST_API_ACTIVITY_DELETE = "https://hangouttw.appspot.com/deleteactivity";
    public static final String HTTP_POST_API_ACTIVITY_QUERY = "https://hangouttw.appspot.com/queryactivity";
    public static final String HTTP_POST_API_ACTIVITY_UPDATE = "https://hangouttw.appspot.com/updateactivity";



    public static final int HTTP_POST_TIMEOUT = 10;
    public static final int HTTP_GET_TIMEOUT = 15;


    private static final String LOG_TAG = "HttpProxy";

    /* interface for use:
                      1.HttpGetTask
                      2.HttpPostTask
                        input:
                        a.arg0[0]: Map<String, String> for Json format
                        b.arg0[1]: Url for different usage
    */

    public static class HttpGetTask extends AsyncTask<String,Void,String> {

        @Override
        public void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        public String doInBackground(String... arg0) {

            URL url = null;
            BufferedReader reader = null;
            StringBuilder stringBuilder;

            try
            {
                // create the HttpURLConnection
                url = new URL(arg0[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                // 使用甚麼方法做連線
                connection.setRequestMethod("GET");

                // 是否添加參數(ex : json...等)
                //connection.setDoOutput(true);

                // 設定TimeOut時間
                connection.setReadTimeout(HTTP_GET_TIMEOUT*1000);
                connection.connect();

                // 伺服器回來的參數
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

            return null;
        }

        @Override
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            if(!"".equals(result) || null != result){

            }
        }
    }


    public static class HttpPostTask extends AsyncTask<Object,Void,String> {


        public AsyncResponse delegate = null;

        public HttpPostTask(AsyncResponse delegate){
            this.delegate = delegate;
        }
        @Override
        public void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        public String doInBackground(Object... arg0) {
            boolean result = false;
            URL url = null;
            BufferedReader reader = null;
            StringBuilder stringBuilder;
            String jsonString = JsonUtils.createJsonString(arg0[0]);
            //jsonString =  "{\"email":"aaaa","gender":"ddd","displayname":"ccc","password":"bbb","age":"32"}";
            //jsonString = "{\"email\":\"Jimmy2@gmail.com\",\"userpassword\":\"12345\",\"gender\":\"Male\",\"age\":32,\"displayname\":\"Jimmy1\"}";
            try
            {
                // create the HttpURLConnection
                url = new URL(String.valueOf(arg0[1]));
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                // 使用甚麼方法做連線
                connection.setRequestMethod("POST");
                connection.setRequestProperty("Content-Type","application/json; charset=UTF-8");
                connection.setRequestProperty("Accept", "application/json");
                connection.setRequestMethod("POST");
                connection.setConnectTimeout(HTTP_POST_TIMEOUT*1000);
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

            return null;
        }

        @Override
        public void onPostExecute(String result) {
            super.onPostExecute(result);
            if(result.contains("200 OK "))
                delegate.processFinish(true);
            else
                delegate.processFinish(false);



        }
    }
}



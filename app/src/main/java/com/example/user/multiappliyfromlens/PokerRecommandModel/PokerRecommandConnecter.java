package com.example.user.multiappliyfromlens.PokerRecommandModel;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class PokerRecommandConnecter
{
    private static final String USER = "fcu";
    private OkHttpClient client = null;
    private Request request = null;
    private String strResponse = null;
    public void sendGET(String strFunction)
    {
        sendGET(strFunction,"");
    }
    public void sendGET(String strFunction,String strMessage) {
        /**建立連線*/
        client = new OkHttpClient().newBuilder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                .build();

        sendReq(combineRequset(strFunction,strMessage));
        /**設置回傳*/
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                /**如果傳送過程有發生錯誤*/
                System.out.println("ERROR");

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                /**取得回傳*/
                strResponse = response.body().string();
                System.out.println("Response : "+strResponse);

            }
        });

    }
    private String combineRequset(String strfunction,String StrMessage)
    {
        String strUrl = "\n"+"https://qqapi.joyland.top"+strfunction+"?user="+USER+"&message="+StrMessage;

        return strUrl;
    }
    private void sendReq(String strUrl)
    {
        /**設置傳送需求*/
        request = new Request.Builder()
                .url(strUrl)
//                .header("Cookie","")//有Cookie需求的話則可用此發送
//                .addHeader("","")//如果API有需要header的則可使用此發送
                .build();
    }

    public String getResponse()
    {
        System.out.println("Outside Response : "+strResponse);
        return strResponse;
    }

}

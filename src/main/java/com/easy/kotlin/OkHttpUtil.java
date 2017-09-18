package com.easy.kotlin;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtil {
    public static String get(String url) {
        String result = null;

        OkHttpClient okhttp = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.MINUTES)
            .readTimeout(10, TimeUnit.MINUTES)
            .writeTimeout(10, TimeUnit.MINUTES)
            .build();

        Request request = new Request.Builder()
            .url(url)
            .build();

        Call call = okhttp.newCall(request);

        try {
            Response response = call.execute();
            result = response.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void getAsync(String url) {
        OkHttpClient okhttp = new OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.MINUTES)
            .readTimeout(10, TimeUnit.MINUTES)
            .writeTimeout(10, TimeUnit.MINUTES)
            .build();

        Request request = new Request.Builder()
            .url(url)
            .build();

        Call call = okhttp.newCall(request);

        call.enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                // TODO
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                // TODO

            }
        });

    }

}

package com.lmcteam.worldcube.email;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.Objects;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class EmailHelper {
    public static void sendEmail(String email, String subject, String content,OnEmailBack onEmailBack) {
        String api = "http://lmcteam.top/api/mail/api.php?address="+email+"&name="+subject+"&certno="+content;
        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder builder = new Request.Builder();
        Request request = builder.url(api).build();
        Call callBack = okHttpClient.newCall(request);
        callBack.enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println("邮件发送失败");
                onEmailBack.onFail();
            }
            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                System.out.println("邮件发送成功");
                MailCallBackBean callBackBean= JSON.parseObject(Objects.requireNonNull(response.body()).string(),MailCallBackBean.class);
                if (callBackBean.getCode().equals("1")) {
                    System.out.println("邮件发送成功");
                    onEmailBack.onSuccess();
                }else {
                    System.out.println("邮件发送失败");
                    onEmailBack.onFail();
                }
            }
        });
    }
    public interface OnEmailBack{
        void onSuccess();
        void onFail();
    }
}

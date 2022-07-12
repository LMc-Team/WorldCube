package com.lmcteam.worldcube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.lmcteam.worldcube.email.EmailHelper;
import com.lmcteam.worldcube.ui.widget.WCubeDialog;
import com.lmcteam.worldcube.util.AssetsUtil;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        AssetsUtil.initialize(this);
        WCubeDialog.initialize(this).showTipDialog("aaaaaaa",true);
    }
    public void onClick(View view) {
        try {
            EmailHelper.sendEmail("1805402441@qq.com", "test", IOUtils.toString(AssetsUtil.getVcodeEmail()), new EmailHelper.OnEmailBack() {
                @Override
                public void onSuccess() {
                    Toast.makeText(MainActivity.this, "邮件发送成功", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFail() {

                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

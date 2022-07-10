package com.lmcteam.worldcube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.lmcteam.worldcube.ui.widget.WCubeDialog;
import com.lmcteam.worldcube.util.AssetsUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AssetsUtil.initialize(this);
        WCubeDialog.initialize(this).showTipDialog("aaaaaaa",false);
    }
}

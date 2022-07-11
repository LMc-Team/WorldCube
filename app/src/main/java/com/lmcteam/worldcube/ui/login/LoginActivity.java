package com.lmcteam.worldcube.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.lmcteam.worldcube.MainActivity;
import com.lmcteam.worldcube.databinding.ActivityLoginBinding;
import com.lmcteam.worldcube.ui.widget.WCubeDialog;
import com.lmcteam.worldcube.util.AssetsUtil;
import com.lmcteam.worldcube.util.LangStringUtil;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LangStringUtil.init(this);
        AssetsUtil.initialize(this);
        WCubeDialog wCubeDialog = WCubeDialog.initialize(this);
        wCubeDialog.showPrivacyPolicyDialog();

        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final TextInputEditText usernameEditText = binding.username;
        final TextInputEditText passwordEditText = binding.password;
        final MaterialButton loginButton = binding.login;

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);

        loginButton.setOnClickListener(v -> {
            WCubeDialog.initialize(LoginActivity.this).showConfirmDialog("将要登录，确定吗？",(x)->{
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            });

        });
    }
}
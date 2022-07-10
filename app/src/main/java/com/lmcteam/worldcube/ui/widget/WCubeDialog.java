package com.lmcteam.worldcube.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.button.MaterialButton;
import com.lmcteam.worldcube.R;

public class WCubeDialog {
    private Context mContext;

    private WCubeDialog(Context mContext, AlertDialog mDialog) {
        this.mContext = mContext;
        this.mDialog = mDialog;
        parentView = LayoutInflater.from(mContext).inflate(R.layout.wcube_dialog_view, null);
        okButton = parentView.findViewById(R.id.dialog_button_ok);
        cancelButton = parentView.findViewById(R.id.dialog_button_cancel);
        title = findViewById(R.id.dialog_textview_title);
        message = findViewById(R.id.dialog_textview_message);
        neutralButton = findViewById(R.id.dialog_button_neutral);
        mDialog.setView(parentView);
    }

    private AlertDialog mDialog;
    private View parentView;
    private TextView title;
    private TextView message;
    private MaterialButton okButton;
    private MaterialButton cancelButton;
    private MaterialButton neutralButton;


    //findViewById(R.id.id)
    public <T extends View> T findViewById(int id) {
        return parentView.findViewById(id);
    }


    public static WCubeDialog initialize(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context); // 创建对话框
        return new WCubeDialog(context, builder.create());
    }

    //方法setOkButton 参数是一个string和一个OnWCubeDialogButtonClickListener
    public WCubeDialog setOkButton(String text, OnWCubeDialogButtonClickListener listener) {
        cancelButton.setText(text);
        okButton.setVisibility(View.VISIBLE);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onBtnClicked(WCubeDialog.this);
            }
        });
        return this;
    }


    //方法setCancelButton 参数是一个string和一个OnWCubeDialogButtonClickListener
    public WCubeDialog setCancelButton(String text, OnWCubeDialogButtonClickListener listener) {
        cancelButton.setText(text);
        cancelButton.setVisibility(View.VISIBLE);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onBtnClicked(WCubeDialog.this);
            }
        });
        return this;
    }


    //setText
    public WCubeDialog setText(String text) {
       message.setText(text);
        return this;
    }

    //setTitle
    public WCubeDialog setTitle(String title) {
        this.title.setText(title);
        return this;
    }

    //setCanCelable
    public WCubeDialog setCanCelable(boolean canCelable) {
        mDialog.setCancelable(canCelable);
        return this;
    }

    //showTipDialog 参数text是一个string,canCelable是一个boolean
    public void showTipDialog(String text, boolean canCelable) {
        if (!mDialog.isShowing())
            setText(text);
        setCanCelable(canCelable);
        setOkButton("Ok", dialog -> Toast.makeText(mContext,"Fuck",Toast.LENGTH_SHORT).show());
        mDialog.show();
    }

    //方法setNeutralButton 参数是一个string和一个OnWCubeDialogButtonClickListener
    public WCubeDialog setNeutralButton(String text, OnWCubeDialogButtonClickListener listener) {
        neutralButton.setText(text);
        neutralButton.setVisibility(View.VISIBLE);
        neutralButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onBtnClicked(WCubeDialog.this);
            }
        });
        return this;
    }


    //方法getDialog 返回一个AlertDialog
    public AlertDialog getDialog() {
        return mDialog;
    }

    public interface OnWCubeDialogButtonClickListener {
        void onBtnClicked(WCubeDialog dialog);
    }

}


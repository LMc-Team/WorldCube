package com.lmcteam.worldcube.ui.widget;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.google.android.material.button.MaterialButton;
import com.lmcteam.worldcube.R;
import com.lmcteam.worldcube.util.AssetsUtil;
import com.lmcteam.worldcube.util.LangStringUtil;
import com.lmcteam.worldcube.util.PathUtil;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;

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

        okButton.setTypeface(AssetsUtil.getTypeface());
        cancelButton.setTypeface(AssetsUtil.getTypeface());
        mDialog.setView(parentView);
    }

    private AlertDialog mDialog;
    private View parentView;
    private WCubeTextView title;
    private WCubeTextView message;
    private MaterialButton okButton;
    private MaterialButton cancelButton;

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
        okButton.setText(text);
        okButton.setVisibility(View.VISIBLE);
        okButton.setOnClickListener(new View.OnClickListener() {
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
        setTitle("提示");
        setOkButton("Ok", dialog -> Toast.makeText(mContext, "Fuck", Toast.LENGTH_SHORT).show());
        mDialog.show();
    }

    public void showConfirmDialog(String text, OnWCubeDialogButtonClickListener listener) {
        if (mDialog.isShowing()) {
            return;
        }
        setText(text);
        setCancelButton(LangStringUtil.getStringById(R.string.dialog_cancel), new OnWCubeDialogButtonClickListener() {
            @Override
            public void onBtnClicked(WCubeDialog dialog) {
                dismiss();
            }
        });
        setOkButton(LangStringUtil.getStringById(R.string.dialog_ok), listener);
        setTitle(LangStringUtil.getStringById(R.string.dialoig_attention));
        mDialog.show();

    }

    public void dismiss() {
        mDialog.dismiss();
    }

    //方法getDialog 返回一个AlertDialog
    public AlertDialog getDialog() {
        return mDialog;
    }

    public interface OnWCubeDialogButtonClickListener {
        void onBtnClicked(WCubeDialog dialog);
    }

    public void showPrivacyPolicyDialog()
    {
        if (!new File(PathUtil.CHECK_1_PATH).exists())
        {
            try {
                showPrivacyDialog0();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
    public void showTermsAndConditionsDialog()
    {
        if (!new File(PathUtil.CHECK_2_PATH).exists())
        {
            try {
                showTermsDialog0();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

    }
    private void showPrivacyDialog0() throws Throwable {
        if (mDialog.isShowing()) {
            return;
        }
        setCanCelable(false);
        setText(IOUtils.toString(AssetsUtil.getPrivacyPolicyStream())+"\n"+IOUtils.toString(AssetsUtil.getTermsOfServiceStream()));
        setCancelButton(LangStringUtil.getStringById(R.string.dialog_disagree), (x)->{System.exit(0);});
        setOkButton(LangStringUtil.getStringById(R.string.dialog_agree), (x)->{
            try {
                new File(PathUtil.CHECK_1_PATH).createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            dismiss();
//            showTermsAndConditionsDialog();
        });

        setTitle(LangStringUtil.getStringById(R.string.dialog_primary)+"&"+LangStringUtil.getStringById(R.string.dialog_terms));
        mDialog.show();
    }

    private void showTermsDialog0() throws Throwable {
        if (mDialog.isShowing()) {
            return;
        }
        setText("");
        setCanCelable(false);
        setText(IOUtils.toString(AssetsUtil.getTermsOfServiceStream()));
        setCancelButton(LangStringUtil.getStringById(R.string.dialog_disagree), (x)->{System.exit(0);});
        setOkButton(LangStringUtil.getStringById(R.string.dialog_agree), (x)->{
            try {
                new File(PathUtil.CHECK_2_PATH).createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            dismiss();
        });
        setTitle(LangStringUtil.getStringById(R.string.dialog_terms));
        mDialog.show();
    }

}


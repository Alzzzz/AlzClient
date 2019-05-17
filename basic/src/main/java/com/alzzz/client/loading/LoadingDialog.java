package com.alzzz.client.loading;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import com.alzzz.client.R;


/**
 * @Description LoadingDialog
 * @Date 2019-05-17
 * @Author sz
 */
public class LoadingDialog extends Dialog {
    Context mContext;
    public LoadingDialog(Context context) {
        super(context);
        this.mContext = context;
        initViews();
    }

    private void initViews() {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.ll_dialog_view, null);
        setContentView(view);
    }

}

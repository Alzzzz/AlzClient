package com.alzzz.client.base;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.alzzz.client.loading.LoadingDialog;

/**
 * @Description BaseActivity
 * @Date 2019-05-15
 * @Author sz
 */
public abstract class BaseActivity extends AppCompatActivity implements IActivity {
    protected LoadingDialog mRequestLoadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());

        getIntentData();
        initView();
        initData();
        bindListener();
    }

    /**
     * @return 根布局样式Layout
     */
    protected abstract int getLayoutId();

    /**
     * 解析Intent内容
     */
    protected void getIntentData(){

    }

    @MainThread
    protected abstract void initData();

    @MainThread
    protected abstract void initView();

    /**
     * 绑定Listener
     */
    public void bindListener() {
    }


    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public void showMessage(@NonNull String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @MainThread
    @Override
    public void showLoading() {
        if (mRequestLoadingDialog == null){
            mRequestLoadingDialog = new LoadingDialog(this);
            mRequestLoadingDialog.setCanceledOnTouchOutside(false);
        }

        if (mRequestLoadingDialog != null
                && !mRequestLoadingDialog.isShowing()){
            mRequestLoadingDialog.show();
        }
    }

    @MainThread
    @Override
    public void hideLoading() {
        if (mRequestLoadingDialog != null
                && mRequestLoadingDialog.isShowing()){
            mRequestLoadingDialog.dismiss();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mRequestLoadingDialog != null){
            mRequestLoadingDialog.dismiss();
            mRequestLoadingDialog = null;
        }
    }
}

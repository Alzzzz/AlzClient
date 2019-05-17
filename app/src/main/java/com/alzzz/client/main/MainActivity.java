package com.alzzz.client.main;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import com.alzzz.client.R;
import com.alzzz.client.base.BaseAlzMVPActivity;

public class MainActivity extends BaseAlzMVPActivity<MainContract.Presenter> implements MainContract.View {
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected MainContract.Presenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initData() {
        mPresenter.getData();
    }

    @Override
    protected void initView() {
        mTextView = findViewById(R.id.tv_main_content);
    }


    @Override
    public void setupData(String result) {
        if (!TextUtils.isEmpty(result)){
            mTextView.setText(result);
        }
    }
}

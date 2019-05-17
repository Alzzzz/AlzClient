package com.alzzz.client.base;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;

/**
 * @Description BaseAlzMVPFragment
 * @Date 2019-05-15
 * @Author sz
 */
public abstract class BaseAlzMVPFragment<P extends IAlzPresenter> extends BaseFragment {
    protected P mPresenter;


    public void bindListener() {
    }

    @Override
    public void onAttach(Context context) {
        //Presenter初始化放在最前端
        initPresenter();
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initLifeCycleObserver(getLifecycle());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.mPresenter = null;
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutRes() {
        return 0;
    }

    public void initPresenter() {
        mPresenter = createPresenter();
    }

    protected abstract P createPresenter();

    private void initLifeCycleObserver(Lifecycle lifecycle) {
        if (mPresenter != null) {
            lifecycle.addObserver(mPresenter);
        }
    }
}

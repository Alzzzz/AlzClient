package com.alzzz.client.base;

import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;

/**
 * @Description BaseAlzMVPActivity
 * @Date 2019-05-15
 * @Author sz
 */
public abstract class BaseAlzMVPActivity<P extends IAlzPresenter> extends BaseActivity {
    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Presenter初始化放在最前端
        initPresenter();
        super.onCreate(savedInstanceState);
        initLifeCycleObserver(getLifecycle());
    }

    /**
     * 初始化生命周期
     * @param lifecycle
     */
    @CallSuper
    @MainThread
    public void initLifeCycleObserver(Lifecycle lifecycle) {
        if (mPresenter != null){
            lifecycle.addObserver(mPresenter);
        }
    }

    private void initPresenter() {
        mPresenter = createPresenter();
    }

    protected abstract P createPresenter();


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null){
            mPresenter = null;
        }
    }
}

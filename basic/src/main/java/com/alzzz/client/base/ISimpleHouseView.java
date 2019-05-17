package com.alzzz.client.base;


import androidx.lifecycle.LifecycleObserver;

public interface ISimpleHouseView extends IAlzView {
    /**
     * 出现错误
     * @param err
     */
    void onError(String err);

    /**
     * 开始loading
     */
    void onLoading();

    /**
     * loading结束，取消loading圈
     */
    void onLoadFinished();

    void addLifecycle(LifecycleObserver lifecycle);

}

package com.alzzz.client.base;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;

/**
 * @Description 基础View接口
 * @Date 2019-05-15
 * @Author sz
 */
public interface IAlzView extends LifecycleOwner {

    /**
     * 获取Activity
     * @return  当前Activity
     */
    Activity getActivity();

    /**
     * 需要弹出的msg信息
     * @param message
     */
    void showMessage(@NonNull String message);

    /**
     * 显示loading
     */
    void showLoading();

    /**
     * 隐藏loading
     */
    void hideLoading();

}

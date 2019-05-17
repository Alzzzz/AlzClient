package com.alzzz.client.base;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;

import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.AutoDisposeConverter;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;


/**
 * @Description BaseAlzPresenter
 * @Date 2019-05-15
 * @Author sz
 */
public abstract class BaseAlzPresenter<V extends IAlzView> implements IAlzPresenter {
    protected V mView;
    LifecycleOwner lifecycleOwner;

    public BaseAlzPresenter(V mView){
        this.mView = mView;
        this.lifecycleOwner = mView;
    }

    /**
     * 强制在每个RxJava使用后调用
     */
    protected <T> AutoDisposeConverter<T> bindLifecycle(){
        if (null == lifecycleOwner) {
            throw new NullPointerException("lifecycleOwner == null");
        }
        return AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(mView.getLifecycle()));
    }

    @Override
    public void onCreate(@NonNull LifecycleOwner owner) {
        Log.d("Presenter Lifecycle", "onCreate");
    }

    @Override
    public void onStart(@NonNull LifecycleOwner owner) {
        Log.d("Presenter Lifecycle", "onStart");
    }

    @Override
    public void onResume(@NonNull LifecycleOwner owner) {
        Log.d("Presenter Lifecycle", "onResume");
    }

    @Override
    public void onPause(@NonNull LifecycleOwner owner) {
        Log.d("Presenter Lifecycle", "onPause");
    }

    @Override
    public void onStop(@NonNull LifecycleOwner owner) {
        Log.d("Presenter Lifecycle", "onStop");
    }

    @Override
    public void onDestroy(@NonNull LifecycleOwner owner) {
        Log.d("Presenter Lifecycle", "onDestroy");
        if (this.mView != null) {
            this.mView = null;
        }
        lifecycleOwner.getLifecycle().removeObserver(this);
    }

    @Override
    public void onLifecycleChanged(@NonNull LifecycleOwner owner, @NonNull Lifecycle.Event event) {
        Log.d("Presenter Lifecycle", "onLifecycleChanged");
    }
}

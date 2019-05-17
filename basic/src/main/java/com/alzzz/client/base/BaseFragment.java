package com.alzzz.client.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alzzz.client.loading.LoadingDialog;

/**
 * @Description BaseFragment
 * @Date 2019-05-15
 * @Author sz
 */
public abstract class BaseFragment extends Fragment implements IFragment {
    public final String TAG = this.getClass().getSimpleName();
    private LoadingDialog mRequestLoadingDialog;
    protected View rootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getArgumentsData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = LayoutInflater.from(getContext()).inflate(getLayoutRes(), container, false);
        }
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView(view);
        initData();
        bindListener();
    }

    public void bindListener() {
    }

    @Override
    public void onDestroy() {
        this.rootView = null;
        super.onDestroy();
        if (mRequestLoadingDialog != null){
            mRequestLoadingDialog.dismiss();
            mRequestLoadingDialog = null;
        }
    }

    protected abstract void initView(View view);

    protected abstract void initData();

    protected abstract int getLayoutRes();

    @Override
    public void showMessage(@NonNull String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @MainThread
    @Override
    public void showLoading() {
        if (getActivity() != null) {
            if (mRequestLoadingDialog == null){
                mRequestLoadingDialog = new LoadingDialog(getActivity());
                mRequestLoadingDialog.setCanceledOnTouchOutside(false);
            }

            if (mRequestLoadingDialog != null
                    && !mRequestLoadingDialog.isShowing()){
                mRequestLoadingDialog.show();
            }
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

    public void getArgumentsData() {

    }
}

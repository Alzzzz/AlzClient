package com.alzzz.client.main;

import com.alzzz.client.base.BaseAlzPresenter;

/**
 * @Description MainPresenter
 * @Date 2019-05-17
 * @Author sz
 */
public class MainPresenter extends BaseAlzPresenter<MainContract.View> implements MainContract.Presenter {
    public MainPresenter(MainContract.View mView) {
        super(mView);
    }


    @Override
    public void getData() {
        mView.setupData("ALZ MVP");
    }
}

package com.alzzz.client.main;

import com.alzzz.client.base.IAlzPresenter;
import com.alzzz.client.base.IAlzView;

/**
 * @Description MainContract
 * @Date 2019-05-17
 * @Author sz
 */
public interface MainContract {
    interface View extends IAlzView{
        void setupData(String result);
    }

    interface Presenter extends IAlzPresenter{
        void getData();
    }
}

package com.lee.rxjavamvphelper.mvp.v;

/**
 * Created by lee on 2017/7/27.
 */

public interface BaseMvpView {

    void showLoadingView();

    void hideLoadingView();

    void showErrorView(String msg);

    void showSuccessView(Object data);
}

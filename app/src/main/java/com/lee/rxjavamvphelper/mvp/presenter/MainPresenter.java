package com.lee.rxjavamvphelper.mvp.presenter;

import android.util.Log;


import com.lee.rxjavamvphelper.mvp.v.BaseMvpView;



import rx.Observable;
import rx.Observer;

/**
 * Created by lee on 2017/7/27.
 */

public abstract class MainPresenter {
    private BaseMvpView view;
    public MainPresenter(BaseMvpView view) {
        this.view = view;
        requestData();
    }

    public abstract Observable request();


    public void requestData() {
        view.showLoadingView();
        Observable observable=request();
        onComplete(observable);
        view.hideLoadingView();
    }



    public void onComplete(Observable observable) {
        observable.subscribe(new Observer<Object>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.i("info",e.getMessage());
                view.showErrorView(e.getMessage());
            }

            @Override
            public void onNext(Object o) {
                Log.i("info",o.toString());
                view.showSuccessView(o);
            }

        });

    }
}

package com.lee.rxjavamvphelper;

import android.os.Bundle;
import android.widget.Toast;

import com.lee.rxjavamvphelper.base.BaseActivity;
import com.lee.rxjavamvphelper.bean.WeatherBean;
import com.lee.rxjavamvphelper.mvp.contact.MainService;
import com.lee.rxjavamvphelper.mvp.presenter.MainPresenter;
import com.lee.rxjavamvphelper.mvp.v.BaseMvpView;
import com.lee.rxjavamvphelper.retrofit.ServiceFactory;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements BaseMvpView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //网络请求测试
        new MainPresenter(this) {
            @Override
            public Observable request() {
                Observable observable = ServiceFactory.getIntance().createService(MainService.class).loadData("101270101")
                        .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
                return observable;
            }
        };
    }

    @Override
    public void showLoadingView() {

    }

    @Override
    public void hideLoadingView() {

    }

    @Override
    public void showErrorView(String msg) {
        Toast.makeText(MainActivity.this,""+msg,Toast.LENGTH_SHORT).show();
    }


    @Override
    public void showSuccessView(Object data) {
        WeatherBean bean= (WeatherBean) data;
        Toast.makeText(MainActivity.this,""+bean.getWeatherinfo().getCity(),Toast.LENGTH_SHORT).show();

    }
}

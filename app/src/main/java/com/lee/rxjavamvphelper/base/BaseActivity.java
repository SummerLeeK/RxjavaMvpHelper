package com.lee.rxjavamvphelper.base;

import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.support.v7.app.AppCompatActivity;

import com.lee.rxjavamvphelper.mvp.v.BaseMvpView;
import com.lee.rxjavamvphelper.receiver.NetWorkStateReceiver;

/**
 * Created by lee on 2017/7/27.
 */

public abstract class BaseActivity<T extends BaseMvpView> extends AppCompatActivity{

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(new NetWorkStateReceiver(),filter);
    }
}

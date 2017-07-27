package com.lee.rxjavamvphelper.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.widget.Toast;

/**
 * Created by lee on 2017/7/27.
 */

public class NetWorkStateReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

//        api是否小于23
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {

            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//          获取wifi连接信息
            NetworkInfo wifi_networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//          获取移动网络连接信息
            NetworkInfo mobile_networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (wifi_networkInfo.isConnected() && mobile_networkInfo.isConnected()) {
                Toast.makeText(context, "WIFI已连接,移动数据已连接", Toast.LENGTH_SHORT).show();
            } else if (wifi_networkInfo.isConnected() && !mobile_networkInfo.isConnected()) {
                Toast.makeText(context, "WIFI已连接,移动数据已断开", Toast.LENGTH_SHORT).show();
            } else if (!wifi_networkInfo.isConnected() && mobile_networkInfo.isConnected()) {
                Toast.makeText(context, "WIFI已断开,移动数据已连接", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "WIFI已断开,移动数据已断开", Toast.LENGTH_SHORT).show();
            }

//        }
//        api大于23时
//        else {
//            ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//            Network[] networks=connectivityManager.getAllNetworks();
//            StringBuilder sb=new StringBuilder();
//
//            for (int i=0;i<networks.length;i++){
//                NetworkInfo networkInfo=connectivityManager.getNetworkInfo(networks[i]);
//                sb.append(networkInfo.getTypeName()+"connect is :"+networkInfo.isConnected());
//            }
//            Toast.makeText(context,sb,Toast.LENGTH_SHORT).show();
//        }
    }
}

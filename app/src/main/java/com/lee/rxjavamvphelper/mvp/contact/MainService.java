package com.lee.rxjavamvphelper.mvp.contact;

import com.lee.rxjavamvphelper.bean.WeatherBean;


import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * 项目接口
 * Created by lee on 2017/7/27.
 */

public interface MainService {
    String BASE_URL = "http://www.weather.com.cn/";

    //加载天气
    @GET("adat/sk/{cityId}.html")
    Observable<WeatherBean> loadData(@Path("cityId") String cityId);
}

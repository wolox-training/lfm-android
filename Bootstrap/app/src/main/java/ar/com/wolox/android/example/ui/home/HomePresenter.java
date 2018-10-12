package ar.com.wolox.android.example.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

class HomePresenter extends BasePresenter<IHomeView> {
    public String welcomeStr ( Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        return sharedPref.getString("username", "");
    }
}

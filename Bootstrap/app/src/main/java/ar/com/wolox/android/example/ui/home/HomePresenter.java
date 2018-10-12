package ar.com.wolox.android.example.ui.home;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import ar.com.wolox.wolmo.core.presenter.BasePresenter;

class HomePresenter extends BasePresenter<IHomeView> {
    @Inject
    public HomePresenter(){

    }
    public void doLogOut( Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.clear();
        editor.apply();
    }
}


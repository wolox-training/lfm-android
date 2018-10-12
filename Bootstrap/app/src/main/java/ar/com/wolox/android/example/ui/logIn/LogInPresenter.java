package ar.com.wolox.android.example.ui.logIn;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;

import ar.com.wolox.android.example.TrainingApplication;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

class LogInPresenter extends BasePresenter<ILogInView> {
    @Inject
    public LogInPresenter(){

    }
    public void doLogIn(String userName, String password, Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("mail", userName);
        editor.apply();
    }
}

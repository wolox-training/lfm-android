package ar.com.wolox.android.example.ui.logIn;

import android.content.Context;
import android.content.SharedPreferences;

import ar.com.wolox.android.example.TrainingApplication;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;

class LogInPresenter extends BasePresenter<ILogInView> {
    public void doLogIn(String userName, String password, Context context) {
        SharedPreferences sharedPref = context.getSharedPreferences("prefs",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("mail", userName);
        editor.apply();
    }
}

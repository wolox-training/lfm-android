package ar.com.wolox.android.example.ui.logIn;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.EditText;

import java.util.List;

import javax.inject.Inject;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.TrainingApplication;
import ar.com.wolox.android.example.model.User;
import ar.com.wolox.android.example.network.PostService;
import ar.com.wolox.android.example.network.UserService;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices;
import ar.com.wolox.wolmo.networking.retrofit.callback.NetworkCallback;
import butterknife.BindView;
import okhttp3.ResponseBody;

public class LogInPresenter extends BasePresenter<ILogInView> {
    @Inject
    RetrofitServices mRetrofitServices;

    private static final String SHARED_PREFERENCES="prefs";
    private static final String SHARED_PREFERENCES_KEY_EMAIL="mail";

    @Inject
    public LogInPresenter(){

    }
    public void doLogIn(String email, String password, Context context) {
       mRetrofitServices.getService(UserService.class).doLogin(email,password).enqueue(new NetworkCallback<List<User>>() {
           @Override
           public void onResponseSuccessful(@Nullable List<User> listUser) {
               if (!listUser.isEmpty()){
                   SharedPreferences sharedPref = context.getSharedPreferences(SHARED_PREFERENCES,Context.MODE_PRIVATE);
                   SharedPreferences.Editor editor = sharedPref.edit();
                   editor.putString(SHARED_PREFERENCES_KEY_EMAIL, email);
                   editor.apply();
                   getView().onLogInSuccessful();
               }
               else{
                   getView().setErrorCode(1);
               }
           }

           @Override
           public void onResponseFailed(@Nullable ResponseBody responseBody, int i) {
               getView().setErrorCode(2);
           }

           @Override
           public void onCallFailure(Throwable throwable) {
                getView().setErrorCode(3);
           }
       });
    }
}

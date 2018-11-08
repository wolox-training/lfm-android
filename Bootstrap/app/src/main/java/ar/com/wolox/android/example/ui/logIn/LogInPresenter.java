package ar.com.wolox.android.example.ui.logIn;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.util.List;

import javax.inject.Inject;

import ar.com.wolox.android.example.model.User;
import ar.com.wolox.android.example.network.UserService;
import ar.com.wolox.wolmo.core.presenter.BasePresenter;
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices;
import ar.com.wolox.wolmo.networking.retrofit.callback.NetworkCallback;
import okhttp3.ResponseBody;

public class LogInPresenter extends BasePresenter<ILogInView> {
    @Inject
    RetrofitServices mRetrofitServices;
    private GoogleSignInAccount account;
    private Task<GoogleSignInAccount> task;
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

    public Task<GoogleSignInAccount> getTask(Intent intent){
        task = GoogleSignIn.getSignedInAccountFromIntent(intent);
        return task;
    }
    public boolean signInWithGoogle (Task<GoogleSignInAccount> task,Context context){
        try {
            account=task.getResult(ApiException.class);
            SharedPreferences sharedPref = context.getSharedPreferences(SHARED_PREFERENCES,Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString(SHARED_PREFERENCES_KEY_EMAIL, account.getEmail());
            editor.apply();
            return true;
        } catch (ApiException e) {
            e.printStackTrace();
            getView().setErrorCode(e.getStatusCode());
            return false;
        }
    }
}

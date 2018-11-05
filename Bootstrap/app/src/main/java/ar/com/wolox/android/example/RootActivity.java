package ar.com.wolox.android.example;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.facebook.drawee.backends.pipeline.Fresco;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeActivity;
import ar.com.wolox.android.example.ui.logIn.LogInActivity;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

public class RootActivity extends WolmoActivity {
    private static final String SHARED_PREFERENCES="prefs";
    private static final String SHARED_PREFERENCES_KEY_EMAIL="mail";

    @Override
    protected int layout() {
        return  R.layout.activity_base;
    }

    @Override
    protected void init() {
        Intent intent;
        Fresco.initialize(this);
        SharedPreferences pref = getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE);
        String username = pref.getString(SHARED_PREFERENCES_KEY_EMAIL, "");
        if (username.isEmpty()){
            intent=new Intent(this,LogInActivity.class);
            startActivity(intent);
            this.finish();
        }
        else {
            intent = new Intent(this, HomeActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            this.finish();
        }
    }

}

package ar.com.wolox.android.example;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeActivity;
import ar.com.wolox.android.example.ui.logIn.LogInActivity;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

public class RootActivity extends WolmoActivity {
    @Override
    protected int layout() {
        return  R.layout.activity_base;
    }

    @Override
    protected void init() {
        Intent intent;
        SharedPreferences pref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String username = pref.getString("username", "");
        if (username.isEmpty()){
            intent=new Intent(this,LogInActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            this.finish();
        }
        else {
            intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
            this.finish();
        }
    }

}

package ar.com.wolox.android.example;

import android.content.Intent;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeActivity;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

public class RootActivity extends WolmoActivity {

    @Override
    protected int layout() {
        return  R.layout.activity_base;
    }

    @Override
    protected void init() {
        Intent intent;
        intent=new Intent(this, HomeActivity.class);
        startActivity(intent);
        this.finish();
    }

}

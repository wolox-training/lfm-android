package com.example.lmontesanto.login;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends FragmentActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.contenedor, new logInFragment());
        setContentView(R.layout.activity_main);
        ft.commit();
    }

    protected void onResume(Bundle savedInstance){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        SharedPreferences pref = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        String username = pref.getString("username", "");

        if (username!="") {
            BienvenidoFragment bienvFrg=new BienvenidoFragment();
            bienvFrg.updateTextView(username);
            ft.replace(R.id.contenedor,bienvFrg);
            ft.commit();
        }
        else{
            ft.replace(R.id.contenedor, new logInFragment());
            setContentView(R.layout.activity_main);
            ft.commit();
        }
    }

}

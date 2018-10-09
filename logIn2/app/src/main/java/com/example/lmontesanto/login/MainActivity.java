package com.example.lmontesanto.login;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickLogIn(View view){
        EditText email=(EditText) findViewById(R.id.emailText);
        EditText password=(EditText) findViewById(R.id.passwordText);
        if (email.getText().toString().isEmpty() && password.getText().toString().isEmpty()){
            email.setError("Debe completar este campo");
            password.setError("Debe completar este campo");
        }
        else{
            if (validarEmail(email.getText().toString())) {
                if (validarPassword(password.getText().toString())) {
                    //pasar a menu..
                }
                else{
                    password.setError("Password Incorrecta");
                }
            }
            else{
                // notificar al usuario con un error al lado del campo email
                email.setError("EMail Invalido");
            }
        }
    }

    public boolean validarEmail(String email){
        return  !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    public boolean validarPassword (String password){
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return !TextUtils.isEmpty(password)&& matcher.matches();
    }
}

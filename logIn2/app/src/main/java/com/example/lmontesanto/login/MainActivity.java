package com.example.lmontesanto.login;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends Activity {
    @BindView (R.id.emailText) EditText emailText;
    @BindView(R.id.passwordText) EditText passwordText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
    public void onClickLogIn(View view){
        if (emailText.getText().toString().isEmpty() && passwordText.getText().toString().isEmpty()){
            emailText.setError("Debe completar este campo");
            passwordText.setError("Debe completar este campo");
        }
        else{
            if (validarEmail(emailText.getText().toString())) {
                if (validarPassword(passwordText.getText().toString())) {
                    //pasar a menu..
                }
                else{
                    passwordText.setError("Password Incorrecta");
                }
            }
            else{
                // notificar al usuario con un error al lado del campo email
                emailText.setError("EMail Invalido");
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

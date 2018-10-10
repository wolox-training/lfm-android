package com.example.lmontesanto.login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import butterknife.BindView;
import butterknife.ButterKnife;

public class logInFragment extends Fragment implements View.OnClickListener {
    @BindView (R.id.emailText) EditText emailText;
    @BindView(R.id.passwordText) EditText passwordText;
    @BindView (R.id.logIn) Button logInButton;
    @BindView (R.id.signUp) Button signUpButton;

    public logInFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_log_in, container, false);
        ButterKnife.bind(this, view);
        logInButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
        return view;
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.logIn:
                logIn();
                break;
            case R.id.signUp:
                //sign up
                break;
        }
    }
    private boolean validarEmail(String email){
        return  !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    private boolean validarPassword (String password){
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{8,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return (!TextUtils.isEmpty(password)&& matcher.matches());
    }
    private void logIn(){
        if (emailText.getText().toString().isEmpty() && passwordText.getText().toString().isEmpty()){
            emailText.setError("Debe completar este campo");
            passwordText.setError("Debe completar este campo");
        }
        else{
            if (validarEmail(emailText.getText().toString())) {
                if (validarPassword(passwordText.getText().toString())) {
                    SharedPreferences sharedPref = getActivity().getSharedPreferences("prefs",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("mail", emailText.getText().toString());
                    editor.apply();
                    BienvenidoFragment bienvenidoFrg=new BienvenidoFragment();
                    bienvenidoFrg.updateTextView(emailText.getText().toString());
                    FragmentTransaction ft=getFragmentManager().beginTransaction();
                    ft.replace(R.id.contenedor,bienvenidoFrg);
                    ft.commit();
                }
                else
                    passwordText.setError("Password Incorrecta");
            }
            else
                emailText.setError("Email Invalido");
        }
    }

}

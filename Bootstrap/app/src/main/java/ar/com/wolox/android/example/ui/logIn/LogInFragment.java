package ar.com.wolox.android.example.ui.logIn;


import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeActivity;
import ar.com.wolox.android.example.ui.signUp.SignUpActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindView;
import butterknife.OnClick;
import kotlin.jvm.Strictfp;

public class LogInFragment extends WolmoFragment<LogInPresenter> implements ILogInView{

    @Inject
    public LogInFragment(){
    }
    @BindView(R.id.fragment_logIn_emailTextField)
    EditText emailText;
    @BindView(R.id.fragment_logIn_passwordTextField) EditText passwordText;
    @BindView (R.id.fragment_logIn_button) Button logInButton;
    @BindView (R.id.fragment_logIn_signUp_button) Button signUpButton;
    @BindView (R.id.fragment_logIn_terms_clickable) TextView mTermsAndConditions;




    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void init() {
        mTermsAndConditions.setMovementMethod(LinkMovementMethod.getInstance());
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
    @OnClick(R.id.fragment_logIn_button)
    public void logIn(){
        Context context=getContext();
        if (emailText.getText().toString().isEmpty() && passwordText.getText().toString().isEmpty()){
            emailText.setError(getActivity().getResources().getString(R.string.empty_fields_error));
        }
        else{
            if (validarEmail(emailText.getText().toString())) {
                    getPresenter().doLogIn(emailText.getText().toString(),passwordText.getText().toString(),getContext());
            }
            else
                emailText.setError(getActivity().getResources().getString(R.string.invalid_email_field));
        }
    }
     @OnClick(R.id.fragment_logIn_signUp_button)
     public void signUp(){
         Intent intent=new Intent(getActivity(),SignUpActivity.class);
         getActivity().startActivity(intent);
    }

    @Override
    public void onLogInSuccessful() {
        Intent intent=new Intent(getActivity(),HomeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        getActivity().startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void setErrorCode(int code) {
        Context context=getContext();
        Toast toast=Toast.makeText(context," ",Toast.LENGTH_LONG);
        switch (code){
            case 1:
               toast.setText(getActivity().getResources().getString(R.string.logInError_invalid_credentials));
               toast.show();
                break;

            case 2:
                toast.setText(getActivity().getResources().getString(R.string.logInError_serverError));
                toast.show();
                break;

            case 3:
                toast.setText(getActivity().getResources().getString(R.string.logInError_noConnection));
                toast.show();
                break;

        }

    }
}

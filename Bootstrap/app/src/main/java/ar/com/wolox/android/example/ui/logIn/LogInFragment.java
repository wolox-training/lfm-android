package ar.com.wolox.android.example.ui.logIn;


import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.ui.home.HomeActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class LogInFragment extends WolmoFragment<LogInPresenter> implements ILogInView{

    @Inject
    public LogInFragment(){
    }
    @BindView(R.id.emailText)
    EditText emailText;
    @BindView(R.id.passwordText) EditText passwordText;
    @BindView (R.id.logIn)
    Button logInButton;
    @BindView (R.id.signUp) Button signUpButton;



    @Override
    public int layout() {
        return R.layout.fragment_login;
    }

    @Override
    public void init() {
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
    @OnClick(R.id.logIn)
    public void logIn(){
        if (emailText.getText().toString().isEmpty() && passwordText.getText().toString().isEmpty()){
            emailText.setError("You must complete both fields");
        }
        else{
            if (validarEmail(emailText.getText().toString())) {
                if (validarPassword(passwordText.getText().toString())) {
                    getPresenter().doLogIn(emailText.getText().toString(),passwordText.getText().toString(),getContext());
                    Intent intent=new Intent(getActivity(),HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    getActivity().startActivity(intent);
                    getActivity().finish();
                }
                else
                    passwordText.setError("Invalid Password");
            }
            else
                emailText.setError("Invalid Email");
        }
    }
    /*
     @OnClick(R.id.signUp)
     public void signUp(){
        //TODO START SIGN UP ACTIVITY
    }
   */
}

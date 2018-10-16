package ar.com.wolox.android.example.ui.signUp;

import javax.inject.Inject;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.activity.WolmoActivity;

public class SignUpActivity extends WolmoActivity{
    @Inject
    SignUpFragment mSignUpFragment;


    @Override
    protected int layout() {
        return R.layout.activity_base;
    }

    @Override
    protected void init() {
        replaceFragment(R.id.vActivityBaseContent, mSignUpFragment);
    }
}

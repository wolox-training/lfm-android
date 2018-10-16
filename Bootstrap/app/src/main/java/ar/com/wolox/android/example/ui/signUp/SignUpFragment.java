package ar.com.wolox.android.example.ui.signUp;

import javax.inject.Inject;

import ar.com.wolox.android.R;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;

public class SignUpFragment extends WolmoFragment<SignUpPresenter> implements ISignUpView {

    @Inject
    public SignUpFragment(){

    }

    @Override
    public int layout() {
        return R.layout.fragment_signup;
    }

    @Override
    public void init() {

    }

}

package ar.com.wolox.android.example.ui.home;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import ar.com.wolox.android.R;
import ar.com.wolox.android.example.RootActivity;
import ar.com.wolox.wolmo.core.fragment.WolmoFragment;
import butterknife.BindView;
import butterknife.OnClick;

public class HomeFragment extends WolmoFragment<HomePresenter> implements IHomeView {

    @Inject
    public HomeFragment(){

    }

    @Override
    public int layout() {
        return R.layout.fragment_home;
    }

    @Override
    public void init() {

    }

}

package com.example.lmontesanto.login;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


public class BienvenidoFragment extends Fragment implements View.OnClickListener {
    @BindView(R.id.txtBienvenido)
    TextView txtBienvenido;

    public BienvenidoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_bienvenido, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public void updateTextView(String text){
        TextView textview=txtBienvenido;
        textview.setText(text);
    }

    @Override
    public void onClick(View v) {

    }
}

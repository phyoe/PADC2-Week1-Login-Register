package xyz.phyoekhant.padc2_week1_login_register.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.phyoekhant.padc2_week1_login_register.R;
import xyz.phyoekhant.padc2_week1_login_register.activities.LoginActivity;
import xyz.phyoekhant.padc2_week1_login_register.activities.RegisterActivity;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class HomeFragment extends Fragment {

    public static HomeFragment newInstance(){
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @OnClick(R.id.btn_login)
    public void onClickLogin(View view){
        navigateToLogin();
    }

    private void navigateToLogin(){
        Intent intent = LoginActivity.newIntent();
        startActivity(intent);
    }

    @OnClick(R.id.btn_register)
    public void onClickRegister(View view){
        navigateToRegister();
    }

    private void navigateToRegister(){
        Intent intent = RegisterActivity.newIntent();
        startActivity(intent);
    }
}

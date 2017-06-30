package xyz.phyoekhant.padc2_week1_login_register.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.phyoekhant.padc2_week1_login_register.CarPweSarApp;
import xyz.phyoekhant.padc2_week1_login_register.R;
import xyz.phyoekhant.padc2_week1_login_register.fragments.LoginConfirmFragment;
import xyz.phyoekhant.padc2_week1_login_register.fragments.LoginFragment;

public class LoginActivity extends BaseActivity implements LoginFragment.DataPassListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static Intent newIntent() {
        Intent intent = new Intent(CarPweSarApp.getContext(), LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        LoginFragment fragment = LoginFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, fragment)
                .commit();
    }

    @Override
    public void passData(String email, String password) {
        LoginConfirmFragment fragment = LoginConfirmFragment.newInstance();
        Bundle args = new Bundle();
        args.putString(fragment.DATA_EMAIL, email);
        args.putString(fragment.DATA_PASSWORD, password);
        fragment.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, fragment )
                .commit();
    }
}

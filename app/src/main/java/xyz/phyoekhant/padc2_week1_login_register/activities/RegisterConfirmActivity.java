package xyz.phyoekhant.padc2_week1_login_register.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.phyoekhant.padc2_week1_login_register.CarPweSarApp;
import xyz.phyoekhant.padc2_week1_login_register.R;

public class RegisterConfirmActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_username)
    TextView tvUsername;

    @BindView(R.id.tv_login_password)
    TextView tvLoginPassword;

    @BindView(R.id.tv_phone)
    TextView tvPhone;

    @BindView(R.id.tv_email)
    TextView tvEmail;

    @BindView(R.id.tv_sellertype)
    TextView tvSellertype;

    @BindView(R.id.tv_date_of_birth)
    TextView tvDOB;

    @BindView(R.id.tv_gender)
    TextView tvGender;

    @BindView(R.id.tv_notify_me)
    TextView tvNotifyMe;

    @BindView(R.id.tv_user_agreements)
    TextView tvUserAgreements;

    public final String EXTRA_USERNAME = "EXTRA_USERNAME";
    public final String EXTRA_PASSWORD = "EXTRA_PASSWORD";
    public final String EXTRA_PHONE = "EXTRA_PHONE";
    public final String EXTRA_EMAIL = "EXTRA_EMAIL";
    public final String EXTRA_SELLERTYPE = "EXTRA_SELLERTYPE";
    public final String EXTRA_DOB = "EXTRA_DOB";
    public final String EXTRA_GENDER = "EXTRA_GENDER";
    public final String EXTRA_NOTIFY = "EXTRA_NOTIFY";
    public final String EXTRA_USERAGREEMENTS = "EXTRA_USERAGREEMENTS";

    public static Intent newIntent() {
        Intent intent = new Intent(CarPweSarApp.getContext(), RegisterConfirmActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_confirm);

        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        String username = getIntent().getStringExtra(EXTRA_USERNAME);
        String loginPassword = getIntent().getStringExtra(EXTRA_PASSWORD);
        String phone = getIntent().getStringExtra(EXTRA_PHONE);
        String email = getIntent().getStringExtra(EXTRA_EMAIL);
        String sellertype = getIntent().getStringExtra(EXTRA_SELLERTYPE);
        String dob = getIntent().getStringExtra(EXTRA_DOB);
        String gender = getIntent().getStringExtra(EXTRA_GENDER);
        String notify_me = getIntent().getStringExtra(EXTRA_NOTIFY);
        String user_agreements = getIntent().getStringExtra(EXTRA_USERAGREEMENTS);

        tvUsername.setText(username);
        tvLoginPassword.setText(loginPassword);
        tvPhone.setText(phone);
        tvEmail.setText(email);
        tvSellertype.setText(sellertype);
        tvDOB.setText(dob);
        tvGender.setText(gender);
        tvNotifyMe.setText(notify_me);
        tvUserAgreements.setText(user_agreements);
    }
}

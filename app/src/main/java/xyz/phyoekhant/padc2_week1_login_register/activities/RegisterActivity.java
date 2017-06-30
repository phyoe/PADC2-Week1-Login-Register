package xyz.phyoekhant.padc2_week1_login_register.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;
import xyz.phyoekhant.padc2_week1_login_register.CarPweSarApp;
import xyz.phyoekhant.padc2_week1_login_register.R;
import xyz.phyoekhant.padc2_week1_login_register.adapters.SellertypeListAdapter;
import xyz.phyoekhant.padc2_week1_login_register.events.DataEvent;
import xyz.phyoekhant.padc2_week1_login_register.fragments.DatePickerDialogFragment;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.et_username)
    EditText etUsername;

    @BindView(R.id.et_login_password)
    EditText etLoginPassword;

    @BindView(R.id.et_phone)
    EditText etPhone;

    @BindView(R.id.et_email)
    EditText etEmail;

    @BindView(R.id.sp_sellertype_list)
    Spinner spSellertypeList;

    @BindView(R.id.tv_date_of_birth)
    TextView tvDateOfBirth;

    @BindView(R.id.radio_gender)
    RadioGroup radioGender;

    @BindView(R.id.radio_male)
    RadioButton radioMale;

    @BindView(R.id.radio_female)
    RadioButton radioFemale;

    @BindView(R.id.toogle_notify_me)
    ToggleButton toggleNotifyMe;

    @BindView(R.id.chk_user_agreements)
    CheckBox chkUserAgreements;

    private SellertypeListAdapter mSellertypeListAdapter;

    public static Intent newIntent() {
        Intent intent = new Intent(CarPweSarApp.getContext(), RegisterActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        String[] sellertypeListArray = getResources().getStringArray(R.array.current_sellertype);
        List<String> sellertypeList = new ArrayList<>(Arrays.asList(sellertypeListArray));

        mSellertypeListAdapter = new SellertypeListAdapter(sellertypeList);
        spSellertypeList.setAdapter(mSellertypeListAdapter);

        tvDateOfBirth.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    showDatePicker();
                }
            }
        });
        tvDateOfBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });

        chkUserAgreements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),
                        "I gree ...", Toast.LENGTH_LONG).show();
            }
        });
    }


    private void showDatePicker() {
        DialogFragment newFragment = new DatePickerDialogFragment();
        newFragment.show(this.getSupportFragmentManager(), "datePicker");
    }

    //Success Register
    public void onEventMainThread(DataEvent.DatePickedEvent event) {
        tvDateOfBirth.setText(event.getDateOfBrith());
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus eventBus = EventBus.getDefault();
        eventBus.unregister(this);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_male:
                if (checked)
                    // Pirates are the best
                    break;
            case R.id.radio_female:
                if (checked)
                    // Ninjas rule
                    break;
        }
    }

    @OnClick(R.id.btn_register)
    public void onClickRegister(View view) {
        navigateToRegisterConfirm();
    }

    private void navigateToRegisterConfirm() {

        String username = etUsername.getText().toString();
        String loginPassword = etLoginPassword.getText().toString();
        String phone = etPhone.getText().toString();
        String email = etEmail.getText().toString();
        String sellertype = spSellertypeList.getSelectedItem().toString();
        String dob = tvDateOfBirth.getText().toString();

        String gender = "";
        if(radioGender.getCheckedRadioButtonId()!=-1){
            int id = radioGender.getCheckedRadioButtonId();
            RadioButton radio = (RadioButton) radioGender.findViewById(id);
            int radioId = radioGender.indexOfChild(radio);
            gender = (String) radio.getText();
        }

        String notify_me = toggleNotifyMe.getText().toString();
        String user_agreements = (chkUserAgreements.isChecked()) ? "I agree." : "-";

        Intent intent = RegisterConfirmActivity.newIntent();
        intent.putExtra("EXTRA_USERNAME", username);
        intent.putExtra("EXTRA_PASSWORD", loginPassword);
        intent.putExtra("EXTRA_PHONE", phone);
        intent.putExtra("EXTRA_EMAIL", email);
        intent.putExtra("EXTRA_SELLERTYPE", sellertype);
        intent.putExtra("EXTRA_DOB", dob);
        intent.putExtra("EXTRA_GENDER", gender);
        intent.putExtra("EXTRA_NOTIFY", notify_me);
        intent.putExtra("EXTRA_USERAGREEMENTS", user_agreements);
        startActivity(intent);
    }
}

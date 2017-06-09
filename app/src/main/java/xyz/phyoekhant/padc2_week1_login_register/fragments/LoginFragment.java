package xyz.phyoekhant.padc2_week1_login_register.fragments;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.phyoekhant.padc2_week1_login_register.R;
import xyz.phyoekhant.padc2_week1_login_register.activities.RegisterActivity;
import xyz.phyoekhant.padc2_week1_login_register.views.PasswordVisibilityListener;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    @BindView(R.id.lbl_recover_password)
    TextView lblRecoverPassword;

    @BindView(R.id.et_email)
    EditText etEmail;

    @BindView(R.id.et_password)
    EditText etPassword;

    @BindView(R.id.lbl_forgot_pw)
    TextView lblForgotPw;

    DataPassListener mCallback;
    public interface DataPassListener{
        public void passData(String email, String password);
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            mCallback = (DataPassListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString()
                    + " must implement DataPassListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, rootView);

        // Text Style Underline
        SpannableString content = new SpannableString(getString(R.string.forgot_password));
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        lblForgotPw.setText(content);

        etPassword.setOnTouchListener(new PasswordVisibilityListener());

        return rootView;
    }

    @OnClick(R.id.btn_login)
    public void onClickLogin(View view) {

        String email = etEmail.getText().toString();
        String password = etPassword.getText().toString();

        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
            if (TextUtils.isEmpty(email)) {
                etEmail.setError(getString(R.string.error_missing_email_login));
            }
            if (TextUtils.isEmpty(password)) {
                etPassword.setError(getString(R.string.error_missing_password_login));
            }
        }else {
            mCallback.passData(email, password);
        }
    }

    @OnClick(R.id.btn_register)
    public void onClickRegister(View view) {
        navigateToRegister();
    }

    private void navigateToRegister() {
        Intent intent = RegisterActivity.newIntent();
        startActivity(intent);
    }

    @OnClick(R.id.lbl_forgot_pw)
    public void onClickForgotPW(View view) {
        Toast.makeText(getContext(), "Forgot Password ...", Toast.LENGTH_SHORT).show();
    }
}

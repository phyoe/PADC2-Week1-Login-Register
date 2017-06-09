package xyz.phyoekhant.padc2_week1_login_register.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.phyoekhant.padc2_week1_login_register.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginConfirmFragment extends Fragment {

    @BindView(R.id.tv_confirm_email)
    TextView tvConfirmEmail;

    @BindView(R.id.tv_confirm_password)
    TextView tvConfirmPassword;

    public final static String DATA_EMAIL = "data_email";
    public final static String DATA_PASSWORD = "data_password";

    public static LoginConfirmFragment newInstance() {
        LoginConfirmFragment fragment = new LoginConfirmFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login_confirm, container, false);
        ButterKnife.bind(this, rootView);

        return rootView;
    }


    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args != null) {
            tvConfirmEmail.setText(args.getString(DATA_EMAIL));
            tvConfirmPassword.setText(args.getString(DATA_PASSWORD));
        }
    }
}

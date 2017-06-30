package xyz.phyoekhant.padc2_week1_login_register.activities;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.phyoekhant.padc2_week1_login_register.R;
import xyz.phyoekhant.padc2_week1_login_register.fragments.HomeFragment;
import xyz.phyoekhant.padc2_week1_login_register.fragments.LoginConfirmFragment;
import xyz.phyoekhant.padc2_week1_login_register.fragments.LoginFragment;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, LoginFragment.DataPassListener {

    @BindView(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.nav_view)
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this,this);

        setSupportActionBar(toolbar);

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_carpwesar_launcher_icon);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        //toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        View headerview = navigationView.getHeaderView(0);
        TextView tv_login_reg = (TextView) headerview.findViewById(R.id.tv_login_reg);
        tv_login_reg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                navigateToLogin();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
            }
        });

        if(savedInstanceState == null){
            navigateToHome();
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        /**
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        /**/

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            navigateToHome();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void navigateToLogin(){
        LoginFragment fragment = LoginFragment.newInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, fragment)
                .commit();
    }

    private void navigateToHome(){
        HomeFragment fragment = HomeFragment.newInstance();
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

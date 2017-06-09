package xyz.phyoekhant.padc2_week1_login_register;

import android.app.Application;
import android.content.Context;

/**
 * Created by Phyoe Khant Zin on 6/7/17.
 */
public class CarPweSarApp extends Application {

    public static String TAG = "CarPweSarApp";

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

    }

    public static Context getContext() {
        return context;
    }
}

package id.sch.smktelkom_mlg.project.xiirpl401112131.inventariskelas;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by achma on 18/11/2016.
 */

public class Signin extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);
    }
}

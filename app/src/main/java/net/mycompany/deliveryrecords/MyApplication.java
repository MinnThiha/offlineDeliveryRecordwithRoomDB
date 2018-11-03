package net.mycompany.deliveryrecords;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/zone.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }



}

package com.example.devendra.translator;

import android.app.Application;
import android.content.Context;

import com.example.devendra.translator.Helper.LocaleHelper;

import java.util.Locale;

/**
 * Created by devendra on 18-03-2018.
 */

public class MainApplication extends Application {


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleHelper.onAttach(base,"en"));
    }
}
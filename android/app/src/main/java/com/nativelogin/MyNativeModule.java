package com.nativelogin;


import android.content.Intent;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Objects;

public class MyNativeModule extends ReactContextBaseJavaModule {

    public MyNativeModule (ReactApplicationContext reactApplicationContext){
        super(reactApplicationContext);
    }
    @NonNull
    @Override
    public String getName() {
        return "LoginModule";
    }

    @ReactMethod
    public void ShowLogin() {
        if (getCurrentActivity() != null) {
            Intent intent = new Intent(getCurrentActivity(), LoginActivity.class);
            getCurrentActivity().startActivity(intent);
        }
    }


}
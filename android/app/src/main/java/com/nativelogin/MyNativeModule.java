package com.nativelogin;


import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.Objects;

public class MyNativeModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    private static final int LOGIN_REQUEST = 1001;
    private Promise loginPromise;
    public MyNativeModule (ReactApplicationContext reactApplicationContext){
        super(reactApplicationContext);
        reactApplicationContext.addActivityEventListener(this);
    }
    @NonNull
    @Override
    public String getName() {
        return "LoginModule";
    }

    @ReactMethod
    public void ShowLogin(Promise promise) {

        Activity activity = getCurrentActivity();
        if (activity == null) {
            promise.reject("NO_ACTIVITY", "Current activity is null");
            return;
        }

        this.loginPromise = promise;
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivityForResult(intent, LOGIN_REQUEST);
    }

    @Override
    public void onActivityResult(Activity activity, int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == LOGIN_REQUEST && loginPromise != null) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                String message = data.getStringExtra("result");
                loginPromise.resolve(message);
            } else {
                loginPromise.reject("LOGIN_FAILED", "Login cancelled or failed");
            }
            loginPromise = null;
        }
    }

    @Override
    public void onNewIntent(Intent intent) {}






}
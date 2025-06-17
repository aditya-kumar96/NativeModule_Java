package com.nativelogin;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class MyNativeModule extends ReactContextBaseJavaModule implements ActivityEventListener {
    private final ReactApplicationContext reactContext;

    public MyNativeModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        reactContext.addActivityEventListener(this); // 👌 Safe to add
    }

    @NonNull
    @Override
    public String getName() {
        return "LoginModule";
    }

    @ReactMethod
    public void showLoginScreen() {
        if (getCurrentActivity() != null) {
            Intent intent = new Intent(getCurrentActivity(), LoginActivity.class);
            getCurrentActivity().startActivity(intent);
        } else {
            System.out.println("LoginModule: currentActivity is null");
        }
    }

    @Override
    public void onActivityResult(@NonNull android.app.Activity activity, int requestCode, int resultCode, @Nullable Intent data) {
        // Handle activity result if needed
    }

    @Override
    public void onNewIntent(@NonNull Intent intent) {
        // Handle new intent if needed
    }
}

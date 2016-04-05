package com.reactnativeexample;

import android.widget.Toast;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

public class ToastModule extends ReactContextBaseJavaModule {
    private static final String DURATION_SHORT_KEY = "SHORT";
    private static final String DURATION_LONG_KEY = "LONG";
    
    public ToastModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }
    
    // Necessary : Return the string name of the NativeModule which represents this class in Javascript
    @Override
    public String getName() {
        return "ToastAndroid";
    }
    
    // Optional : Return consntants values exposed to Javascript
    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(DURATION_SHORT_KEY, Toast.LENGTH_SHORT);
        constants.put(DURATION_LONG_KEY, Toast.LENGTH_LONG);
        return constants;
    }

    @Override
    public boolean canOverrideExistingModule() {
        return true;
    }

    // To expose this method to Javascript ; always void
    /**
    * Return types possibles
    * Boolean -> Bool 
    * Integer -> Number 
    * Double -> Number
    * Float -> Number 
    * String -> String 
    * Callback -> function 
    * ReadableMap -> Object 
    * ReadableArray -> Array
    */
    @ReactMethod
    public void show(String message, int duration) {
        Toast.makeText(getReactApplicationContext(), message, duration).show();
    }
}


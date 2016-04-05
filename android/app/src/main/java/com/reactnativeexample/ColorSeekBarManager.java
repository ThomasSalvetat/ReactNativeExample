package com.reactnativeexample;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class ColorSeekBarManager extends SimpleViewManager<ColorSeekBar> {

    // Necessary : Return the string name of the NativeModule which represents this class in Javascript
    @Override
    public String getName() {
        return "ColorSeekBar";
    }

    @Override
    protected ColorSeekBar createViewInstance(ThemedReactContext reactContext) {
        return new ColorSeekBar(reactContext);
    }


    @ReactProp(name="color")
    public void setColor(ColorSeekBar mySeekbar, ReadableArray colors) {
        mySeekbar.setColor(colors);
    }

}


package com.reactnativeexample;

import android.util.Log;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

public class LinearGradientManager extends SimpleViewManager<LinearGradientView> {

    public static final String REACT_CLASS = "BVLinearGradient";
    public static final String PROP_COLORS = "colors";
    public static final String PROP_LOCATIONS = "locations";
    public static final String PROP_START_POS = "start";
    public static final String PROP_END_POS = "end";
    public static final String PROP_BORDER_RADIUS = "borderRadius";

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    protected LinearGradientView createViewInstance(ThemedReactContext context) {
        return new LinearGradientView(context);
    }

    @ReactProp(name=PROP_COLORS)
    public void setColors(LinearGradientView gradientView, ReadableArray colors) {
        gradientView.setColors(colors);
    }

    @ReactProp(name=PROP_LOCATIONS)
    public void setLocations(LinearGradientView gradientView, ReadableArray locations) {
        gradientView.setLocations(locations);
    }

    @ReactProp(name=PROP_START_POS)
    public void setStartPosition(LinearGradientView gradientView, ReadableArray startPos) {
        gradientView.setStartPosition(startPos);
    }

    @ReactProp(name=PROP_END_POS)
    public void setEndPosition(LinearGradientView gradientView, ReadableArray endPos) {
        gradientView.setEndPosition(endPos);
    }

    // temporary solution until following issue is resolved:
    // https://github.com/facebook/react-native/issues/3198
    @ReactProp(name=PROP_BORDER_RADIUS, defaultFloat = 0f)
    public void setBorderRadius(LinearGradientView gradientView, float borderRadius) {
        gradientView.setBorderRadius(PixelUtil.toPixelFromDIP(borderRadius));
    }
}

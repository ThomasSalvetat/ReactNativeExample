package com.reactnativeexample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;

import butterknife.Bind;
import butterknife.ButterKnife;


public class ColorSeekBar extends LinearLayout {

    @Bind(R.id.seekBar) SeekBar seekBar;
    @Bind(R.id.textView) TextView textView;

    public ColorSeekBar(Context context) {
        super(context);
        init();
    }

    public void setThumbColor(int color) {
        seekBar.getThumb().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

    public void setBarColor(int color) {
        seekBar.getProgressDrawable().setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
    }

    public void setColor(ReadableArray colors){
        if (colors.size() == 1) {
            int intColor = colors.getInt(0);
            setThumbColor(intColor);
            setBarColor(intColor);
        }
    }

    private void init(){
        inflate(getContext(), R.layout.view_seekbar, this);
        ButterKnife.bind(this, this);

        textView.setText(String.valueOf(seekBar.getProgress()));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                WritableMap event = Arguments.createMap();
                event.putString("message", "SeekBarChanged");
                event.putInt("progress", progress);
                ReactContext reactContext = (ReactContext)getContext();
                reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(getId(), "topChange", event);

                textView.setText(String.valueOf(seekBar.getProgress()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
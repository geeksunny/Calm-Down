package com.radicalninja.calmdown;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends WearableActivity implements View.OnClickListener {

    private static final long[] PATTERN_HEARTBEAT = {0, 100, 100, 100, 1500};

    private boolean isPlaying;
    private BoxInsetLayout containerView;
    private ImageView playButton;
    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        setContentView(R.layout.activity_main);
        //setAmbientEnabled();

        containerView = (BoxInsetLayout) findViewById(R.id.container);
        playButton = (ImageView) findViewById(R.id.play_button);
        playButton.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isPlaying) {
            pause();
        }
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        //updateDisplay();
    }

    @Override
    public void onUpdateAmbient() {
        super.onUpdateAmbient();
        //updateDisplay();
    }

    @Override
    public void onExitAmbient() {
        //updateDisplay();
        super.onExitAmbient();
    }

    @Override
    public void onClick(View v) {
        togglePlayState();
    }

    private void togglePlayState() {
        if (isPlaying) {
            pause();
        } else {
            play();
        }
    }

    private void play() {
        playButton.setImageResource(R.drawable.ic_pause_circle_outline);
        isPlaying = true;
        startVibrations();
    }

    private void pause() {
        playButton.setImageResource(R.drawable.ic_play_circle_outline);
        isPlaying = false;
        stopVibrations();
    }

    private void startVibrations() {
        vibrator.vibrate(PATTERN_HEARTBEAT, 0);
    }

    private void stopVibrations() {
        vibrator.cancel();
    }

    private void updateDisplay() {
//        if (isAmbient()) {
//            containerView.setBackgroundColor(getResources().getColor(android.R.color.black));
//            textView.setTextColor(getResources().getColor(android.R.color.white));
//        } else {
//            containerView.setBackground(null);
//            textView.setTextColor(getResources().getColor(android.R.color.black));
//        }
    }
}

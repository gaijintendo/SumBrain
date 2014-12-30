package com.graphrica.sumbrain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

    public class SplashScreen extends Activity {
        protected boolean _active = true;
        protected int _splashTime = 3010; // time to display the splash screen in ms

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.splashscreen);

            final TextView mTextField;
            mTextField = (TextView) findViewById(R.id.textView);

            new CountDownTimer(4000, 1000) {
                public void onTick(long millisUntilFinished) {
                    mTextField.setText("" + millisUntilFinished / 1000);
                }
                public void onFinish() {
                    mTextField.setText("READY?");
                }
            }.start();

            Thread splashTread = new Thread() {
                @Override
                public void run() {
                    try {
                        int waited = 0;
                        while (_active && (waited < _splashTime)) {
                            sleep(100);
                            if (_active) {
                                waited += 100;
                            }
                        }
                    } catch (Exception e) {

                    } finally {

                        startActivity(new Intent(SplashScreen.this,
                                MyActivity.class));
                        finish();
                    }
                };
            };
            splashTread.start();

        }
    }


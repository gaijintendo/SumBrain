package com.graphrica.sumbrain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import java.util.Random;
import android.view.inputmethod.InputMethodManager;

public class MyActivity extends Activity {

    public int answer;
    public int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        appLoop();
    }

    public void appLoop(){
        final TextView tv;
        tv = (TextView) findViewById(R.id.tvSum);
        tv.setText(setQuestion());

        final TextView tvScore;
        tvScore = (TextView) findViewById(R.id.tvScore);
        tvScore.setText("0");

        final TextView timer;
        timer = (TextView) findViewById(R.id.tvCntDn);

        final Button btnRestart;
        btnRestart = (Button) findViewById(R.id.btnRestart);
        btnRestart.setVisibility(View.INVISIBLE);
        btnRestart.setOnClickListener(ReloadActivity);

        final EditText et;
        et = (EditText) findViewById(R.id.editText);
        et.setEnabled(true);

        //keep keyboard showing
        final InputMethodManager inputManager = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        //inputManager.toggleSoftInput (InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);
        inputManager.toggleSoftInput(InputMethodManager.SHOW_FORCED,0);

        new CountDownTimer(30000, 10) {
            //set to a small interval to keep keyboard up
            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished / 1000);
                inputManager.showSoftInput(et, InputMethodManager.SHOW_FORCED);
            }
            public void onFinish() {
                timer.setText("FINISHED");
                et.setEnabled(false);

                if (et.getText().toString().equals(String.valueOf(answer))) {
                    score += 1;
                    tvScore.setText(String.valueOf(score));
                }

                btnRestart.setVisibility(View.VISIBLE);
            }
        }.start();

        et.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // If the event is a key-down event on the "enter" button
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    //CALCULATE IF CORRECT + RECORD SCORE
                    if (et.getText().toString().equals(String.valueOf(answer))) {
                        score += 1;
                        tvScore.setText(String.valueOf(score));
                        tv.setText(setQuestion());
                        et.setText("");
                        et.requestFocus();
                    }else{
                        tv.setText(setQuestion());
                        Toast toast = Toast.makeText(getApplicationContext(), "WRONG",Toast.LENGTH_SHORT );
                        toast.show();
                        et.setText("");
                        et.requestFocus();
                    }
                    return true;
                }
                return false;
            }
        });
    }

    public String setQuestion(){

        String Q = "";
        Random r = new Random();
        int pt1 =(r.nextInt(12));
        int pt2 = (r.nextInt(12));

        switch (r.nextInt(3)) {
            case 0:
                //ADDITION
                answer = pt1+pt2;
                Q = String.valueOf(pt1);
                Q +="+";
                Q += String.valueOf(pt2);
                Q+="=";
                break;
            case 1:
                //MULTIPLICATION
                answer = pt1*pt2;
                Q = String.valueOf(pt1);
                Q +="*";
                Q += String.valueOf(pt2);
                Q+="=";
                break;
            case 2:
                //DIVISION
                //avoid divide by zero error
                if(pt2 == 0){
                    pt2 = 1;
                }

                //boring way to stop decimal places in responses
                if (pt1%pt2!=0) {
                    pt2 = 1;
                }

                answer = pt1 / pt2;

                Q = String.valueOf(pt1);
                Q +="/";
                Q += String.valueOf(pt2);
                Q+="=";
                break;
            default:
                //addition
                answer = pt1+pt2;
                Q = String.valueOf(pt1);
                Q +="+";
                Q += String.valueOf(pt2);
                Q+="=";
                break;
        }

        return Q;
    }

    private View.OnClickListener ReloadActivity = new View.OnClickListener() {
        public void onClick(View v) {
            //appLoop();
            startActivity(new Intent(MyActivity.this,
                    SplashScreen.class));
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

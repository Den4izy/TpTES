package com.den4izy.tptes2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;

import static com.den4izy.tptes2.Logic.ht;
import static com.den4izy.tptes2.Logic.search2;
import static com.den4izy.tptes2.Logic.st;

public class MainActivity extends AppCompatActivity {

    private TextView power;
    private TextView powerInt;
    private TextView powerFull;
    private TextView inWork;
    private String powerStatus;
    private String powerIntStatus;
    private String powerFullStatus;
    private String inWorkStatus;
    private Button button;


    Thread thread = new Thread() {
        @Override
        public void run() {
            try {
                while (!thread.isInterrupted()) {
                    Thread.sleep(5000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            String[] arr;
                            arr = com.den4izy.tptes2.Logic.st();
                            //powerStatus = search2(ht())[3];
                            powerStatus = com.den4izy.tptes2.Logic.search(arr[0],14,20) + " МВт.";
                            powerIntStatus = com.den4izy.tptes2.Logic.search(arr[1],14,20) + " МВт.";
                            powerFullStatus = com.den4izy.tptes2.Logic.search(arr[2],8,11) + " МВт.";
                            inWorkStatus = search2(ht());
                            power.setText(powerStatus);
                            powerInt.setText(powerIntStatus);
                            powerFull.setText(powerFullStatus);
                            inWork.setText(inWorkStatus);
                        }
                    });
                }
            } catch (InterruptedException e) {
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
        power = findViewById(R.id.TV_power);
        powerInt = findViewById(R.id.TV_powerInt);
        powerFull = findViewById(R.id.TV_powerFull);
        inWork = findViewById(R.id.TV_inWork);
        button = findViewById(R.id.B_button);
        com.den4izy.tptes2.Logic.create();
        String[] arr;
        arr = com.den4izy.tptes2.Logic.st();
        powerStatus = com.den4izy.tptes2.Logic.search(arr[0],14,20) + " МВт.";
        powerIntStatus = com.den4izy.tptes2.Logic.search(arr[1],14,20) + " МВт.";
        powerFullStatus = com.den4izy.tptes2.Logic.search(arr[2],8,11) + " МВт.";
        inWorkStatus = search2(ht());
        power.setText(powerStatus);
        powerInt.setText(powerIntStatus);
        powerFull.setText(powerFullStatus);
        inWork.setText(inWorkStatus);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] arr;
                arr = com.den4izy.tptes2.Logic.st();
                powerStatus = com.den4izy.tptes2.Logic.search(arr[0],14,20) + " МВт.";
                powerIntStatus = com.den4izy.tptes2.Logic.search(arr[1],14,20) + " МВт.";
                powerFullStatus = com.den4izy.tptes2.Logic.search(arr[2],8,11) + " МВт.";
                inWorkStatus = search2(ht());
                power.setText(powerStatus);
                powerInt.setText(powerIntStatus);
                powerFull.setText(powerFullStatus);
                inWork.setText(inWorkStatus);
            }
        };
        button.setOnClickListener(onClickListener);
        thread.start();
    }
}

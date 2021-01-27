package com.den4izy.tptes2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;

import static com.den4izy.tptes2.Logic.ht;
import static com.den4izy.tptes2.Logic.search2;
import static com.den4izy.tptes2.Logic.st;

public class MainActivity extends AppCompatActivity {

    private TextView power;
    private TextView inWork;
    private String powerStatus;
    private String powerStr;
    private String inWorkStatus;
    private Button button;
    private int w;


    Thread thread = new Thread() {             // Потік оновлення
        @Override
        public void run() {
            try {
                while (!thread.isInterrupted()) {
                    Thread.sleep(5000);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.d("REFR","ooooooo");
                            powerStr = com.den4izy.tptes2.Logic.st();  // Строка з потужністю
                            powerStatus = com.den4izy.tptes2.Logic.search(powerStr,8,11) + " МВт.";  // оброблена строка потужності
                            power.setText(powerStatus);  // установка потужності на екран

                            inWorkStatus = search2(ht()); // строка з робочими блоками
                            inWork.setText(inWorkStatus);  // установка блоків на екран



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
        inWork = findViewById(R.id.TV_inWork);
        button = findViewById(R.id.B_button);
        com.den4izy.tptes2.Logic.create();  // запуск метода з ініціалізацією всіх даних(URL, СON..)
        powerStr= com.den4izy.tptes2.Logic.st();
        powerStatus = com.den4izy.tptes2.Logic.search(powerStr,8,11) + " МВт.";
        power.setText(powerStatus);


        inWorkStatus = search2(ht());
        inWork.setText(inWorkStatus);
        View.OnClickListener onClickListener = new View.OnClickListener() { // опрацювання кнопки
            @Override
            public void onClick(View v) {
                setContentView(R.layout.settings_activity); // відкриваємо нове вікно
            }
        };
        button.setOnClickListener(onClickListener);
        thread.start();  // запуск оновлення
    }
}

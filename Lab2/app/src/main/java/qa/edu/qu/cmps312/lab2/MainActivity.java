package qa.edu.qu.cmps312.lab2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG =
            MainActivity.class.getSimpleName();

    private int onStartCounter = 0;
    private int onStopCounter = 0;
    private int onCreateCounter = 0;
    private int onReStartCounter = 0;
    private int onpauseCounter = 0;
    private int onReSumeCounter = 0;

    private Button openSecondBtn;
    int counter =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d(TAG, "onCreate: " + onCreateCounter++);
        openSecondBtn = (Button) findViewById(R.id.open_btn);
        openSecondBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,
                        SecondActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("myValue", "Man");

                intent.putExtras(bundle);

                startActivity(intent);

                Log.d(TAG, "Current QUestion is: " + names.get(counter++));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: " + onStartCounter++);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG, "onResume: " + onReSumeCounter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: " + onpauseCounter++);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: " + onStopCounter++);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: " + onReStartCounter++);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {

        outState.putInt("onCreate", onCreateCounter);
        outState.putInt("onStop", onStopCounter);
        outState.putInt("onPause", onpauseCounter);


        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        onCreateCounter = savedInstanceState.getInt("onCreate");

        super.onRestoreInstanceState(savedInstanceState);
    }
}

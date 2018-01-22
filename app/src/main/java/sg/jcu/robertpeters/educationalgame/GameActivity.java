package sg.jcu.robertpeters.educationalgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity{

    private taskFragment taskFragment;
    private EditText input;
    private int score;
    private int round;
    private SharedPreferences preferences;
    private SensorManager mSensorManager;
    private ShakeEventListener mSensorListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        taskFragment = (taskFragment) getSupportFragmentManager().findFragmentById(R.id.taskFragment);
        input = findViewById(R.id.resultInput);
        preferences = getSharedPreferences("EduGame", MODE_PRIVATE);
        score = 0;
        round = 0;
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mSensorListener = new ShakeEventListener();

        mSensorListener.setOnShakeListener(new ShakeEventListener.OnShakeListener() {

            public void onShake() {
                nextImpl();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    public void Next(View view) {
        nextImpl();
    }

    private void nextImpl(){
        if(taskFragment.checkResult(input.getText().toString())){
            score++;
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong :(", Toast.LENGTH_SHORT).show();
        }
        round++;
        if (round > 9){
            preferences.edit()
                    .putInt("score", score)
                    .apply();
            startActivity(new Intent(this, TwitterActivity.class));
            finish();
        } else {
            taskFragment.next();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(mSensorListener,
                mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        mSensorManager.unregisterListener(mSensorListener);
        super.onPause();
    }
}

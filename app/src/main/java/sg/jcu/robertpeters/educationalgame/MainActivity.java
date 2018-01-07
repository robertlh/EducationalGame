package sg.jcu.robertpeters.educationalgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void Settings(View view) {
        startActivity(new Intent(this, HighScoreActivity.class));
    }

    public void Start(View view){
        startActivity(new Intent(this, GameActivity.class));
    }
}

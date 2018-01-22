package sg.jcu.robertpeters.educationalgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView name;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferences = getSharedPreferences("EduGame", Context.MODE_PRIVATE);
        setContentView(R.layout.activity_main);
    }


    public void Settings(View view) {
        startActivity(new Intent(this, HighScoreActivity.class));
    }

    public void Start(View view) {
        name = findViewById(R.id.nameInput);
        String nameString = name.getText().toString();
        preferences.edit()
                .putString("name", nameString)
                .apply();
        startActivity(new Intent(this, GameActivity.class));
    }
}

package sg.jcu.robertpeters.educationalgame;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment {

    private SharedPreferences preferences;
    private EditText input;
    private DatabaseHandler db;

    public StartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_start, container, false);
        preferences = getContext().getSharedPreferences("EduGame", Context.MODE_PRIVATE);
        input = view.findViewById(R.id.nameInput);
        input.setText(preferences.getString("name", ""));
        db = new DatabaseHandler(getContext());
        String[] scores = db.getAllScores();
        TextView highScore = view.findViewById(R.id.viewHighScore);
        if (scores.length > 0)
            highScore.setText(scores[0]);
        return view;

    }
}

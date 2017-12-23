package sg.jcu.robertpeters.educationalgame;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class HighScoreFragment extends Fragment {

    private DatabaseHandler db;

    public HighScoreFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        db = new DatabaseHandler(getContext());
        //db.addScore(34, "Robert");
        //db.addScore(70, "Felix");
        View view = inflater.inflate(R.layout.fragment_hight_score, container, false);
        String[] scores = db.getAllScores();
        /*ArrayAdapter<String> scoresAdapter =
                new ArrayAdapter<>(getActivity(),
                        R.layout.score_item_layout,
                        R.id.list_item_score,
                        scores);
        ListView scoreView = view.findViewById(R.id.scoreList);
        scoreView.setAdapter(scoresAdapter);*/
        LinearLayout scoresLayout = view.findViewById(R.id.linearLayout);
        int i = 1;
        for (String sc : scores) {
            TextView textView = new TextView(getContext());
            textView.setText(String.valueOf(i) + ". " + sc);
            scoresLayout.addView(textView);
            i++;
        }
        return view;
    }


}

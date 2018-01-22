package sg.jcu.robertpeters.educationalgame;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class taskFragment extends Fragment {

    TextView resistor1Text, resistor2Text, resistor3Text, resistor1_2Text, resistor2_2Text, resistor3_2Text;
    ImageView ImageResistor1, ImageResistor2, ImageResistor3;
    private Image taskImage;
    private int result;
    private float R1, R2, R3, R1_2, R2_2, R3_2;
    private int R1picture, R2picture, R3picture;
    private float R_Gesamt;

    public taskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        //int[] temp = view.getResources(R.array.results);
        //int temp2 = randomNumber(temp.length);
        //result = temp[temp2];
        //Image = view.getResources(R.drawable.img1);
        // Inflate the layout for this fragment
        resistor1Text = view.findViewById(R.id.resistor1);
        resistor2Text = view.findViewById(R.id.resistor2);
        resistor3Text = view.findViewById(R.id.resistor3);
        resistor1_2Text = view.findViewById(R.id.resistor1_2);
        resistor2_2Text = view.findViewById(R.id.resistor2_2);
        resistor3_2Text = view.findViewById(R.id.resistor3_2);
        ImageResistor1 = view.findViewById(R.id.resistor1image);
        ImageResistor2 = view.findViewById(R.id.resistor2image);
        ImageResistor3 = view.findViewById(R.id.resistor3image);
        if (savedInstanceState != null) {
            R1 = savedInstanceState.getFloat("R1");
            R2 = savedInstanceState.getFloat("R2");
            R3 = savedInstanceState.getFloat("R3");
            R1_2 = savedInstanceState.getFloat("R1_2");
            R2_2 = savedInstanceState.getFloat("R2_2");
            R3_2 = savedInstanceState.getFloat("R3_2");
            R_Gesamt = savedInstanceState.getFloat("R_Gesamt");
            R1picture = savedInstanceState.getInt("R1picture");
            R2picture = savedInstanceState.getInt("R2picture");
            R3picture = savedInstanceState.getInt("R3picture");
            setView();
        } else {
            next();
        }
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putFloat("R1", R1);
        outState.putFloat("R2", R2);
        outState.putFloat("R3", R3);
        outState.putFloat("R1_2", R1_2);
        outState.putFloat("R2_2", R2_2);
        outState.putFloat("R3_2", R3_2);
        outState.putFloat("R_Gesamt", R_Gesamt);
        outState.putInt("R1picture", R1picture);
        outState.putInt("R2picture", R2picture);
        outState.putInt("R3picture", R3picture);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public boolean checkResult(String input) {
        if(R1picture==2)
            R1 = 1 / (1 / R1 + 1 / R1_2);
        if(R2picture==2)
            R2 = 1 / (1 / R2 + 1 / R2_2);
        R_Gesamt = R1 + R2 + R3;
        float R_Berechnet = Float.valueOf(input);
        return (R_Gesamt > (R_Berechnet - 1)) & (R_Gesamt < (R_Berechnet + 1));
    }

    public void next() {
        if (Math.random() > 0.7) {
            R1 = (float) (100 * Math.random());
            R1picture = 1;
        } else if (Math.random() > 0.8) {
            R1 = 0;
            R1picture = 0;
        } else {
            R1 = (float) (100 * Math.random());
            R1_2 = (float) (100 * Math.random());
            R1picture = 2;
        }

        if (Math.random() > 0.7) {
            R2 = (float) (100 * Math.random());
            R2_2 = (float) (100 * Math.random());
            R2picture = 2;


        } else {
            R2 = (float) (100 * Math.random());
            R2picture = 1;
        }


        R3 = (float) (100 * Math.random());
        R3picture = 1;

        setView();


    }

    private void setView(){
        if(R1picture == 0){
            ImageResistor1.setVisibility(View.GONE);
            resistor1_2Text.setVisibility(View.GONE);
            resistor1Text.setVisibility(View.GONE);
        } else if (R1picture ==1){
            resistor1Text.setText(String.format("%.2f", R1));
            ImageResistor1.setImageResource(R.drawable.resistor1);
            ImageResistor1.setVisibility(View.VISIBLE);
            resistor1_2Text.setVisibility(View.GONE);
            resistor1Text.setVisibility(View.VISIBLE);
        } else {
            resistor1Text.setText(String.format("%.2f", R1));
            resistor1Text.setVisibility(View.VISIBLE);
            resistor1_2Text.setText(String.format("%.2f", R1_2));
            resistor1_2Text.setVisibility(View.VISIBLE);
            ImageResistor1.setImageResource(R.drawable.resistor2);
            ImageResistor1.setVisibility(View.VISIBLE);
        }
        if(R2picture==2){
            ImageResistor2.setImageResource(R.drawable.resistor2);
            resistor2_2Text.setText(String.format("%.2f", R2_2));
            resistor2Text.setText(String.format("%.2f", R2));
            resistor2Text.setVisibility(View.VISIBLE);
            resistor2_2Text.setVisibility(View.VISIBLE);
            ImageResistor1.setVisibility(View.VISIBLE);
        } else {
            resistor2Text.setText(String.format("%.2f", R2));
            resistor2Text.setVisibility(View.VISIBLE);
            resistor2_2Text.setVisibility(View.GONE);
            ImageResistor2.setImageResource(R.drawable.resistor1);
        }

        resistor3Text.setText(String.format("%.2f", R3));
        resistor3Text.setVisibility(View.VISIBLE);
        ImageResistor3.setImageResource(R.drawable.resistor1);
        resistor3_2Text.setVisibility(View.GONE);
    }


}

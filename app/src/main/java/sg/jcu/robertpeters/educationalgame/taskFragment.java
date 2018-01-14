
package sg.jcu.robertpeters.educationalgame;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link taskFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class taskFragment extends Fragment {

    TextView resistor1Text;
    TextView resistor2Text;
    private OnFragmentInteractionListener mListener;
    private Image taskImage;
    private int result;
    private float R1;
    private float R2;
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
        next();
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public boolean checkResult(String input) {
        float R_Berechnet = Float.valueOf(input);
        R_Gesamt = R1 + R2;
        if ((R_Gesamt > (R_Berechnet - 1)) & (R_Gesamt < (R_Berechnet + 1))) {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void next(){
        R1 = (float)(100*Math.random());
        resistor1Text.setText(Float.toString(R1));
        R2 = (float)(100*Math.random());
        resistor2Text.setText(Float.toString(R2));
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {

    }

}

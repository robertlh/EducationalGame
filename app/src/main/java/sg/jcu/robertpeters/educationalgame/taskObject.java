package sg.jcu.robertpeters.educationalgame;

import android.media.Image;

/**
 * Created by U556094 on 07.01.2018.
 */

public class taskObject {

    private Image taskImage;
    private int result;

    public taskObject() {
        /*int[] temp = Context.getResources().getIntArray(R.array.results);
        int temp2 = randomNumber(temp.length);
        result = temp[temp2];
        Image = Context.getResources().getDrawable(R.drawable.img1);*/
    }

    public boolean result(int input) {
        return false;
    }

    private int randomNumber(int length) {
        return (int) ((Math.random() * length));
    }
}

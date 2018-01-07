package sg.jcu.robertpeters.educationalgame;

import android.media.Image;

import java.lang.reflect.Array;

/**
 * Created by U556094 on 07.01.2018.
 */

public class taskObject {

    private Image taskImage;
    private int result;

    public taskObject() {
        int[] temp = (Array) R.array.results
        result = randomNumber();
        Image = new Image();
    }

    public boolean result(int input) {

    }

    private int randomNumber() {
        return (int) ((Math.random() *);
    }
}

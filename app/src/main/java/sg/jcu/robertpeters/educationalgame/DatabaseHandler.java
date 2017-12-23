package sg.jcu.robertpeters.educationalgame;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by U556094 on 22.12.2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "game";

    // Table name
    private static final String TABLE_SCORE = "score";

    // Score Table Columns names
    private static final String KEY_ID_SCORE = "_id";
    private static final String KEY_SCORE = "score_value";
    private static final String KEY_NAME = "name";

    DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SCORE_TABLE = "CREATE TABLE " + TABLE_SCORE + "("
                + KEY_ID_SCORE + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_NAME + " TEXT,"
                + KEY_SCORE + " TEXT" + ")";

        db.execSQL(CREATE_SCORE_TABLE);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORE);

        // Create tables again
        onCreate(db);
    }

    // Adding new score
    void addScore(int score, String name) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_SCORE, score); // score value
        values.put(KEY_NAME, name);

        // Inserting Values
        db.insert(TABLE_SCORE, null, values);

        db.close();

    }

    // Getting All Scores
    String[] getAllScores() {

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_SCORE + " ORDER BY " + KEY_SCORE + " DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list

        int i = 0;

        String[] data = new String[cursor.getCount()];

        while (cursor.moveToNext()) {

            data[i] = cursor.getString(1) + " " + cursor.getString(2);

            i++;

        }
        cursor.close();
        db.close();
        // return score array
        return data;
    }
}

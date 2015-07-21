package lukesic.com.study_app.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import lukesic.com.study_app.entity.Word;

/**
 * Created by luizfelipe on 4/20/15.
 */
public class DataBase extends SQLiteOpenHelper{

    public static final String DB = "deutsch_app";
    public static final String TABLE_WORD = "words";
    private static final int VERSION = 1;

    public static final String WORD_ID = "_id";
    public static final String WORD_IN_DEUTSCH = "word_in_deutsch";

    public static final String ID = "_id";
    public static final String WORD_DEUTSCH_COLUMN = "word_in_deutsch";
    public static final String WORD_PORTUGUESE_COLUMN = "word_in_portuguese";
    public static final String GENDER_COLUMN = "gender";
    public static final String PLURAL_FORM_COLUMN = "plural_form";
    public static final String WORD_TYPE_COLUMN = "word_type";

    public DataBase(Context context) {
        super(context, DB, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table words (" +
                "_id integer primary key AUTOINCREMENT not null," +
                "word_in_deutsch varchar(255) not null," +
                "word_in_portuguese varchar(255) not null," +
                "gender varchar(3) null," +
                "plural_form varchar(255) null, " +
                "word_type varchar (255)" +
                ");");

        db.execSQL("insert into words values (null, 'Tisch', 'mesa', 'der', 'Tische', 'SUBSTANTIVE');");
        db.execSQL("insert into words values (null, 'arbeiten', 'trabalhar', '-', '-', 'VERB');");
    }





    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i2) {

    }
}

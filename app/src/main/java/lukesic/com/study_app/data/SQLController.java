package lukesic.com.study_app.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;

import lukesic.com.study_app.entity.Word;

/**
 * Created by luizfelipe on 4/25/15.
 */
public class SQLController {

    private DataBase dataBase;
    private Context context;
    private SQLiteDatabase sqLiteDatabase;

    public SQLController(Context c){
        context = c;
    }

    public SQLController open() throws SQLException{
        dataBase = new DataBase(context);
        sqLiteDatabase = dataBase.getWritableDatabase();

        return this;
    }

    public void close(){
        dataBase.close();
    }

    public Cursor getAll(){
        return sqLiteDatabase.rawQuery("select * from words order by _id", null);
    }

    public Cursor getWordById(int idWord){
        String where = "_id=" + idWord;
        String columns[] = {"_id, word_in_deutsch, word_in_portuguese, gender, plural_form, word_type"};
        Cursor cursor = sqLiteDatabase.query(true, "words",columns , where, null, null, null, null, null);
        cursor.moveToFirst();
        return cursor;
    }

    public long insertWord(Word word){
        ContentValues values = new ContentValues();

        values.put(DataBase.WORD_DEUTSCH_COLUMN, word.getWordInDeutsch());
        values.put(DataBase.WORD_PORTUGUESE_COLUMN, word.getWordInPortuguese());
        values.put(DataBase.GENDER_COLUMN, word.getGender());
        values.put(DataBase.PLURAL_FORM_COLUMN, word.getPuralForm());
        values.put(DataBase.WORD_TYPE_COLUMN, word.getWordType());

        long newRowId;

        newRowId = sqLiteDatabase.insert(DataBase.TABLE_WORD, "",values);

        return newRowId;
    }
}

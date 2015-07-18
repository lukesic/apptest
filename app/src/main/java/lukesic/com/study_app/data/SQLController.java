package lukesic.com.study_app.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.SQLException;

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
}

package lukesic.com.study_app.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;

import java.sql.SQLException;

import lukesic.com.study_app.R;
import lukesic.com.study_app.data.SQLController;

/**
 * Created by luizfelipe on 7/20/15.
 */
public class WordItemActivity extends Activity {

    public static final String ACTION_OPEN_WORD_ITEM = "deutsch.ACTION_OPEN_WORD_ITEM";
    public static final String CATEGORY_WORD_ITEM = "deutsch.CATEGORY_WORD_ITEM";
    public static final String EXTRA_WORD_ID = "deutsch.EXTRA_WORD_ID";


    private SQLController sqlController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_item);

        Intent intent = getIntent();

        if(intent.hasExtra(EXTRA_WORD_ID)){
            int idWord = intent.getIntExtra(EXTRA_WORD_ID, 0);

            Log.d("Valor vindo da lista ", String.valueOf(idWord));

            sqlController = new SQLController(this);
            try {
                sqlController.open();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            Cursor cursor = sqlController.getWordById(idWord);
        }
    }
}

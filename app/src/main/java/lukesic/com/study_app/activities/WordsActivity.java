package lukesic.com.study_app.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import java.sql.SQLException;

import lukesic.com.study_app.R;
import lukesic.com.study_app.data.DataBase;
import lukesic.com.study_app.data.SQLController;

/**
 * Created by luizfelipe on 4/19/15.
 */
public class WordsActivity extends Activity {

    public static final String ACTION_OPEN_WORDS_ACTIVITY = "deutsch.ACTION_OPEN_WORDS_ACTIVITY";
    public static final String CATEGORY_WORDS_ACTIVITY = "deutsch.CATEGORY_WORDS_ACTIVITY";

    public ListView listOfWords;
    private SQLController sqlController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        sqlController = new SQLController(this);
        try {
            sqlController.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        listOfWords = (ListView) findViewById(R.id.listOfWords);
        listOfWords.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        final Cursor cursor = sqlController.getAll();


        Log.d("Valor", String.valueOf(cursor.getCount()));

        String[] from = new String[]{DataBase.WORD_ID, DataBase.WORD_IN_DEUTSCH};
        int[] to = new int[]{R.id.word_id, R.id.word_in_deutsch};

        SimpleCursorAdapter cursorAdapter = new SimpleCursorAdapter(WordsActivity.this, R.layout.word_item, cursor, from, to, 1);

        cursorAdapter.notifyDataSetChanged();
        listOfWords.setAdapter(cursorAdapter);
        listOfWords.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Cursor list = (Cursor) listOfWords.getItemAtPosition(i);
                //Log.d("Valor ", cursor.getString(i));

                Intent intent = new Intent(WordItemActivity.ACTION_OPEN_WORD_ITEM);
                intent.addCategory(WordItemActivity.CATEGORY_WORD_ITEM);

                intent.putExtra(WordItemActivity.EXTRA_WORD_ID, cursor.getInt(0));
                startActivity(intent);
            }
        });
    }

    public void insertNewWord(View v){
        Intent intent = new Intent(InsertNewWordActivity.ACTION_OPEN_INSERT_NEW_WORD);

        intent.addCategory(InsertNewWordActivity.CATEGORY_INSERT_NEW_WORD);

        startActivity(intent);
    }
}

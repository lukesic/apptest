package lukesic.com.study_app.activities;

import android.app.Activity;
import android.os.Bundle;

import lukesic.com.study_app.R;

/**
 * Created by luizfelipe on 4/26/15.
 */
public class InsertNewWordActivity extends Activity{

    public static final String ACTION_OPEN_INSERT_NEW_WORD = "deutsch.ACTION_OPEN_INSERT_NEW_WORD";
    public static final String CATEGORY_INSERT_NEW_WORD = "deutsch.CATEGORY_INSERT_NEW_WORD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_word);
    }
}

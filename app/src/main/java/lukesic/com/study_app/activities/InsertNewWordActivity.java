package lukesic.com.study_app.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import lukesic.com.study_app.R;

/**
 * Created by luizfelipe on 4/26/15.
 */
public class InsertNewWordActivity extends Activity{

    public static final String ACTION_OPEN_INSERT_NEW_WORD = "deutsch.ACTION_OPEN_INSERT_NEW_WORD";
    public static final String CATEGORY_INSERT_NEW_WORD = "deutsch.CATEGORY_INSERT_NEW_WORD";

    private Spinner genderSpinner;
    private Spinner wordTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_word);

        fillSpinners();
    }

    private void fillSpinners() {
        genderSpinner = (Spinner) findViewById(R.id.spinnerGender);
        wordTypeSpinner = (Spinner) findViewById(R.id.spinnerWordType);

        ArrayAdapter genderArray = ArrayAdapter.createFromResource(this, R.array.spinner_gender_content, android.R.layout.simple_spinner_dropdown_item);
        genderArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter wordTypeArray = ArrayAdapter.createFromResource(this, R.array.spinner_word_type, android.R.layout.simple_spinner_dropdown_item);
        wordTypeArray.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        genderSpinner.setAdapter(genderArray);
        wordTypeSpinner.setAdapter(wordTypeArray);
    }
}

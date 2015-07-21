package lukesic.com.study_app.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.sql.SQLException;
import java.util.Calendar;

import lukesic.com.study_app.R;
import lukesic.com.study_app.bo.WordBo;
import lukesic.com.study_app.data.SQLController;
import lukesic.com.study_app.entity.Word;

/**
 * Created by luizfelipe on 4/26/15.
 */
public class InsertNewWordActivity extends Activity{

    public static final String ACTION_OPEN_INSERT_NEW_WORD = "deutsch.ACTION_OPEN_INSERT_NEW_WORD";
    public static final String CATEGORY_INSERT_NEW_WORD = "deutsch.CATEGORY_INSERT_NEW_WORD";

    private Spinner genderSpinner;
    private Spinner wordTypeSpinner;
    private EditText editTextWordInGerman;
    private EditText editTextWordInPortuguese;
    private EditText editTextWordInPlural;

    private SQLController sqlController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_word);

        fillSpinners();
    }

    public void saveWord(View v){
        editTextWordInGerman = (EditText) findViewById(R.id.textEditWordDeutsch);
        editTextWordInPortuguese = (EditText) findViewById(R.id.textEditWordPortuguese);
        editTextWordInPlural = (EditText) findViewById(R.id.textEditPluralForm);

        Word wordToInsert = new Word();

        wordToInsert.setWordInDeutsch(editTextWordInGerman.getText().toString());
        wordToInsert.setWordInPortuguese(editTextWordInPortuguese.getText().toString());
        wordToInsert.setPuralForm(editTextWordInPlural.getText().toString());
        wordToInsert.setGender(genderSpinner.getSelectedItem().toString());
        wordToInsert.setWordType(wordTypeSpinner.getSelectedItem().toString());
        wordToInsert.setDateInserted(Calendar.getInstance());

        String statusReturn = WordBo.validateData(wordToInsert);

        if(statusReturn.equalsIgnoreCase("OK")) {

            sqlController = new SQLController(this);

            try {
                sqlController.open();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            if(sqlController.insertWord(wordToInsert) != -1){
                Intent intent = new Intent(WordsActivity.ACTION_OPEN_WORDS_ACTIVITY);

                intent.addCategory(WordsActivity.CATEGORY_WORDS_ACTIVITY);
                startActivity(intent);
            }
        }else {
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage(statusReturn);
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
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

package lukesic.com.study_app.entity;

import java.util.Calendar;

import lukesic.com.study_app.enuns.WordType;

/**
 * Created by luizfelipe on 4/20/15.
 */
public class Word {

    private int id;
    private String wordInDeutsch;
    private String wordInPortuguese;
    private String gender;
    private String puralForm;
    private WordType wordType;
    private Calendar dateInserted;


    public Calendar getDateInserted() {
        return dateInserted;
    }

    public void setDateInserted(Calendar dateInserted) {
        this.dateInserted = dateInserted;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWordInDeutsch(String wordInDeutsch) {
        this.wordInDeutsch = wordInDeutsch;
    }

    public void setWordInPortuguese(String wordInPortuguese) {
        this.wordInPortuguese = wordInPortuguese;
    }

    public void setPuralForm(String puralForm) {
        this.puralForm = puralForm;
    }

    public void setWordType(WordType wordType) {
        this.wordType = wordType;
    }

    public int getId() {

        return id;
    }

    public String getWordInDeutsch() {
        return wordInDeutsch;
    }

    public String getWordInPortuguese() {
        return wordInPortuguese;
    }

    public String getPuralForm() {
        return puralForm;
    }

    public WordType getWordType() {
        return wordType;
    }
}

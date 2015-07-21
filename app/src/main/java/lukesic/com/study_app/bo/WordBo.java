package lukesic.com.study_app.bo;

import lukesic.com.study_app.entity.Word;

/**
 * Created by luizfelipe on 7/20/15.
 */
public class WordBo {

    public static String validateData(Word word){
        if(word.getWordInDeutsch().equalsIgnoreCase("")){
            return "Definir palavra em alemão";
        }else if(word.getWordInPortuguese().equalsIgnoreCase("")){
            return "Definir palavra em portugues";
        }else if(word.getWordType().equalsIgnoreCase("Substantivo")){
            if(word.getPuralForm().equalsIgnoreCase("")) {
                return "Definir plural";
            }else {
                return "OK";
            }
        }else{
            return "OK";
        }

    }
}

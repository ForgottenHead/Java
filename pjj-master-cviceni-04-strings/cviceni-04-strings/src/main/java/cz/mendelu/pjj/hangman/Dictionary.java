package cz.mendelu.pjj.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Slovn�k, kter� obsahuje vybranou sadu slov vhodn�ch pro h�d�n� ve h�e.
 */
public class Dictionary {
    private final List<String> words;

    /**
     * Prim�rn� konstruktor na vytvo�en� instance slovn�ku.
     *
     * Slovn�ky na��t� ve form�tu Ispell: https://en.wikipedia.org/wiki/Ispell
     * @param dic slovn�k ulo�en� v adres��i src/main/resources
     * @param worldFilter filtrok, kter� je odpov�dn� za v�b�r slov ze slovn�ku.
     */
    public Dictionary(String dic, WordFilter worldFilter){
        try (var br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(dic), "ISO-8859-2"))) {
            words = br.lines()
                    .filter(worldFilter::acceptWord)
                    .map(worldFilter::transformWord)
                    .collect(Collectors.toList());
        } catch (IOException | NullPointerException e) {
            throw new LoadDictionaryException("Nelze nacist slovnik: " + dic, e);

        }
    }

    /**
     * Tato metoda zam�ch� po�ad� slov ve slovn�ku.
     */
    public void shuffleWords() {
        Collections.shuffle(words);
    }

    /**
     * Metoda vyberje jedno slovo ze slovn�ku.
     * Z�dn� slovo nen� vr�ceno dvakr�t.
     * @return Slovo ze slovn�ku
     * @throws {@link IllegalStateException} je slovn�k ji� pr�zdn�.
     */
    public String getWord() {
        if (words.isEmpty()) {
            throw new IllegalStateException("Vsechna slova pouzita");
        }
        return words.remove(0);
    }
}

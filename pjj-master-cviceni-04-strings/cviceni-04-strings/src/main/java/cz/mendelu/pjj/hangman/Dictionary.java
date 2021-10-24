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
 * Slovník, který obsahuje vybranou sadu slov vhodných pro hádání ve høe.
 */
public class Dictionary {
    private final List<String> words;

    /**
     * Primární konstruktor na vytvoøení instance slovníku.
     *
     * Slovníky naèítá ve formátu Ispell: https://en.wikipedia.org/wiki/Ispell
     * @param dic slovník uložený v adresáøi src/main/resources
     * @param worldFilter filtrok, který je odpovìdný za výbìr slov ze slovníku.
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
     * Tato metoda zamíchá poøadí slov ve slovníku.
     */
    public void shuffleWords() {
        Collections.shuffle(words);
    }

    /**
     * Metoda vyberje jedno slovo ze slovníku.
     * Zádné slovo není vráceno dvakrát.
     * @return Slovo ze slovníku
     * @throws {@link IllegalStateException} je slovník již prázdný.
     */
    public String getWord() {
        if (words.isEmpty()) {
            throw new IllegalStateException("Vsechna slova pouzita");
        }
        return words.remove(0);
    }
}

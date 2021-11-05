package cz.mendelu.pjj.hangman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Slovník, který obsahuje vybranou sadu slov vhodných pro hádání ve hře.
 */
public class Dictionary {

    // FIXME doplnit klíčové slovo: final
    private List<String> words;

    /**
     * Primární konstruktor na vytvoření instance slovníku.
     *
     * Slovníky načítá ve formátu Ispell: https://en.wikipedia.org/wiki/Ispell
     * @param dic slovník uložený v adresáři src/main/resources
     * @param worldFilter filtrok, který je odpovědný za výběr slov ze slovníku.
     */
    public Dictionary(String dic, WordFilter worldFilter) {
        try (var br = new BufferedReader(new InputStreamReader(ClassLoader.getSystemResourceAsStream(dic), "iso-8859-2"))) {
            words = br.lines()
                    .filter(worldFilter::acceptWord)
                    .map(worldFilter::transformWord)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            // FIXME Vyhodi výjimku: LoadDictionaryException
            e.printStackTrace();
        }
    }

    /**
     * Tato metoda zamíchá pořadí slov ve slovníku.
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
            // FIXME Vyhodit vhodnou výjimku z Java API
        }
        return words.remove(0);
    }

    /**
     * Metoda pro sískání aktuálního množství slov ve slovníku.
     * @return
     */
    public int getSize() {
        return words.size();
    }
}

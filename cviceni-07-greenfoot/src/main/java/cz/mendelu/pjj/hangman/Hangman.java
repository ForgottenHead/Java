package cz.mendelu.pjj.hangman;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class Hangman {

    private final Dictionary dictionary;

    private final String word;

    private final boolean[] uncovered;

    private final String letters;

    private final boolean[] unavailable; // reversed logic

    private final PictureBuilder picture;

    private Integer missed = 0;


    Hangman(Dictionary dictionary) {
        this.dictionary = dictionary;
        this.dictionary.shuffleWords();
        this.word = this.dictionary.getWord();
        this.uncovered = new boolean[word.length()];
        this.letters = "abcdefghijklmnopqrstuvwxyz";
        this.unavailable = new boolean[letters.length()];
        this.picture = new PictureBuilder();
    }

    public static Hangman createNewGame() {
        var dic = new Dictionary("cs_CZ.dic", new WordFilter() {
            @Override
            public boolean acceptWord(String word) {
                return word.endsWith("/H") && word.length() > 8;
            }

            @Override
            public String transformWord(String word) {
                return StringUtils.stripAccents(word.substring(0, word.length() - 2).toLowerCase());
            }
        });
        return new Hangman(dic);
    }

    boolean isDone() {
        if (picture.isEnd()) return true;
        for (boolean b : uncovered) {
            if (!b) return false;
        }
        return true;
    }

    boolean isHanged() { return picture.isEnd(); }

    /**
     * Získání seznamu doposud nehádaných písmen.
     */
    public String availableLetters() {
        var sb = new StringBuilder();
        for (int i = 0; i < letters.length(); i++) {
            if (!unavailable[i]) {
                sb.append(letters.charAt(i)).append(" ");
            } else {
                sb.append("_ ");
            }
        }
        return sb.toString();
    }

    /**
     * Vrací hádanné slovo se zakrytými písmeny: "A _ _ J"
     */
    public String coveredWord() {
        var sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (uncovered[i]) {
                sb.append(word.charAt(i)).append(" ");
            } else {
                sb.append("_ ");
            }
        }
        return sb.toString();
    }

    /**
     * Hádání pismena nebo celé slovo v případě, že hráč je již uhádl.
     * @param letter Hdanné písmen nebo celé slovo.
     */
    public boolean guessLetter(String letter) {
        if (letter.length() > 1) { // hádání celého slova
            if (letter.equals(word)) {
                Arrays.fill(uncovered, true);
                return true;
            }
            return false;
        }
        int i = letters.indexOf(letter);
        boolean guessed = false;
        if (!unavailable[i]) {
            unavailable[i] = true;
            int ii;
            int iter = 0;
            String wordTmp = word;
            while (wordTmp.contains(letter)) {
                ii = wordTmp.indexOf(letter);
                if (ii >= 0) {
                    uncovered[ii + iter] = true;
                    wordTmp = wordTmp.substring(ii + 1);
                    guessed = true;
                    iter += ii + 1;
                }
            }
        }
        return guessed;
    }

    /**
     * Vygenerování obrázku oběšence.
     * @return
     */
    public String hangmanAsciiArt() {
        return picture.getPicture(missed++);
    }

    public boolean validInput(String input) {
        if (input.length() < 1) {
            Main.con.printf("Nezadán vstup\n");
            return false;
        }
        if (input.length() > 1) {
            if (input.length() != word.length()) {
                Main.con.printf("Slovo nemá totožnou délku, zkus to znovu\n");
                return false;
            }
            return true;
        }
        int index = letters.indexOf(input.charAt(0));
        if (index >= 0 ) {
            if (unavailable[index]) {
                Main.con.printf("Písmeno už jsi hádal\n");
                return false;
            } else {
                return true;
            }
        } else Main.con.printf("Nezadán platný vstup\n");
        return false;
    }

    public boolean isAvailable(int index){
        return !unavailable[index];
    }

    public String getLetter(int index){
        return letters.substring(index, index+1);
    }

    public int getMissed(){
        return missed;
    }
}

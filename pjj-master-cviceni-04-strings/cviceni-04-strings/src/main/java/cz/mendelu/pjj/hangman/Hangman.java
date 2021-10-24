package cz.mendelu.pjj.hangman;

public class Hangman {

    private final Dictionary dic;

    private static final String LETTRES = "abcdefghijklmnopqrstuvwxyz";

    private String word;
    private boolean[] selected = new boolean[LETTRES.length()];
    private int lives = 10;

    public Hangman(Dictionary dic) {
        this.dic = dic;
        this.nextGame(true);
    }

    public void nextGame(boolean shuffle) {
        if (shuffle) dic.shuffleWords();
        word = dic.getWord();
        lives = 10;
        selected = new boolean[LETTRES.length()];
    }

    /**
     * Metoda vrací true, pokud jsou všchna písmena slova obìvena nebo obìšenc visí
     * @return
     */
    public boolean isDone() {
        if (lives <= 0){
            System.out.println("YOU LOOSE, word was: " + word);
            return true;
        }
        for (int i = 0; i < word.length(); i++) {
            if (!selected[LETTRES.indexOf(word.charAt(i))]){
                return false;
            }
        }
        System.out.println("YOU WIN, word was: " + word);
        return true;
    }

    /**
     * Získání seznamu doposud nehádaných písmen.
     */
    public String availableLetters() {
        var sb = new StringBuilder();
        for (int i = 0; i < LETTRES.length(); i++) {
            if (selected[i]){
                sb.append("_ ");
            }else{
                sb.append(LETTRES.charAt(i)).append(' ');
            }
        }
        return  sb.toString();
    }

    /**
     * Vrací hádanné slovo se zakrytými písmeny: "a _ _ j"
     */
    public String coveredWord() {
        var sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (selected[LETTRES.indexOf(word.charAt(i))]){
                sb.append(word.charAt(i)).append(' ');
            }else{
                sb.append("_ ");
            }
        }
        return  sb.toString();
    }


    /**
     * Hádání pismena nebo celé slovo v pøípadì, že hráè je již uhádl.
     * @param letter Hdanné písmen nebo celé slovo.
     */
    public boolean guessLetter(String letter) {
        selected[LETTRES.indexOf(letter)] = true;
        if (word.contains(letter)){
            return true;
        }

        lives -= letter.length();
        return false;
    }


    /**
     * Vygenerování obrázku obìšence.
     * Inspirace: https://codegolf.stackexchange.com/questions/135936/ascii-hangman-in-progress
     * @return
     */
    public String hangmanAsciiArt() {
        if (lives <= 0){
            return "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "=========\n";
        }
        if (lives == 1){
            return "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========\n";
        }
        if (lives == 2){
            return "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========\n";
        }
        if (lives == 3){
            return "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========\n";
        }
        if (lives == 4){
            return "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========\n";
        }
        if (lives == 5){
            return "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========\n";
        }
        if (lives == 6){
            return "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========\n";
        }
        if (lives == 7){
            return "  +---+\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========\n";
        }
        if (lives == 8){
            return "       \n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========\n";
        }
        if (lives == 9){
            return "       \n" +
                    "      \n" +
                    "      \n" +
                    "      \n" +
                    "      \n" +
                    "      \n" +
                    "=========\n";
        }
        return "       \n" +
                "      \n" +
                "      \n" +
                "      \n" +
                "      \n" +
                "      \n" +
                "=========\n";
    }
}

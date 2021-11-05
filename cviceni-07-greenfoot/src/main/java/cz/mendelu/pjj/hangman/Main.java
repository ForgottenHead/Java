package cz.mendelu.pjj.hangman;

import org.apache.commons.lang3.StringUtils;

public class Main {

    static final Console con = Console.console();

    public static void main(String[] args) {
        var hangman = Hangman.createNewGame();
        while (!hangman.isDone()) {
            con.printf("Word: %s\n", hangman.coveredWord());
            con.printf("Lettes: %s\n", hangman.availableLetters());
            var letter = con.readLine("Zvol písmeno, nebo hádej slovo: ");
            if (hangman.validInput(letter)) {
                if (hangman.guessLetter(letter)) {
                    con.printf("CORRECT\n");
                } else {
                    con.printf("MISSED\n");
                    con.printf(hangman.hangmanAsciiArt());
                }
            }
        }
        if (hangman.isHanged()) {
            con.printf("Byl jsi oběšen, příště se víc snaž ;-)\n");
        } else {
            con.printf("Gratuluji! Bystrá mysl :-)\n");
        }
    }


}

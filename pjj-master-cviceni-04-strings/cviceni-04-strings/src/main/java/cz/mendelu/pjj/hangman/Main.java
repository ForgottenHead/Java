package cz.mendelu.pjj.hangman;

public class Main {

    private static Console con = Console.console();


    public static void main(String[] args) {
        var dic = new Dictionary("cs_CZ.dic", new WordFilter() {

            private String ascent = "ìšèøžýáíéóúùïò";
            private String replaced = "escrzyaieouudtn";

            @Override
            public boolean acceptWord(String word) {
                return word.length() >= 8 && word.endsWith("/H");
            }

            @Override
            public String transformWord(String word) {


                var transform = word.toLowerCase();

                for (int i = 0; i < ascent.length(); i++) {
                   transform = transform.replace(ascent.charAt(i), replaced.charAt(i));
                }

                return transform.substring(0, transform.length() - 2);

            }
        });
        var hangman = new Hangman(dic);

        // Hlavní herní smyèka
        while (!hangman.isDone()) {
            con.printf("\nWord: \t\t%s\n", hangman.coveredWord());
            con.printf("Letters: \t%s\n", hangman.availableLetters());
            var letter = con.readLine("Write letter or word: ");
            if (hangman.guessLetter(letter)) {
                con.printf("CORRECT\n");
            } else {
                con.printf("MISSED\n");
                con.printf(hangman.hangmanAsciiArt());
            }
        }


    }
}

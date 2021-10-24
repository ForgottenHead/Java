package cz.mendelu.pjj.hangman;

/**
 * Interface filtrování slov při načítání slovníku.
 * Vytváření probíhá ve dvou fázích. 
 * 
 * 1. Je použita metoda {@link #acceptWord(String)} pro zjištšní, jestli je slovo vhodné
 * 2. Pokud slovo byhoví je použíta metoda {@link #transformWord(String)} pro unifikaci slov.
 *    Tedy slova nesmí obsahovat českou diakritiku ani musí se skládat jen z velkývh písmen.
 *    Všechny ostatní znaky musí být odsraněny nebo nahrzeny.
 */
public interface WordFilter {
    
    boolean acceptWord(String word);
    
    String transformWord(String word);
}

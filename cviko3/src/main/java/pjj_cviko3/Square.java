package pjj_cviko3;

public class Square {
    Chess chess;
    char row;
    int col;
    Figure figure;

    /**
     * Metoda pro získání sousedních polí.
     * Parametr slouží jako filter pro sousedy v daných směrech.
     * Pokud directions není zadán, pak metoda vrací všechny sousedy pole
     * @param directions smery ve kterých se sousedi hledají.
     * @return Pole sousedů, pokud žádný není, pak se vrací prázdné pole.
         */
    public Square[] lineAt(Direction direction){
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    /**
     * Metoda {@link Figure} na pozici nebo <code>null</code>
     * @return Figure
     */
    public Figure getFigure(){
        return figure;
    }

    public void setFigure(Figure figure){
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}

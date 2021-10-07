package pjj_cviko3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FigureTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     *
     * Test navratu not null pola pre whereCanMove()
     *
     * @author: Nikolas
     * @version: Etapa2
     */
    @Test
    void whereCanMove() {
        //setup
        var chess = Chess.createEnglishDraughts();
        var figure = new Figure();
        var square = chess.getSquare('c',3);
        square.setFigure(figure);
        //when
        Square[] squares = figure.whereCanMove();
        //then
        assertNotNull(square);

    }
}
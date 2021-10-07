package pjj_cviko3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChessTest {

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    /**
     *
     * @author: Nikolas
     * @version: Etapa2
     */
    @Test
    void createEnglishDraughts() {
        //act/when
        var chess = Chess.createEnglishDraughts();
        assertNotNull(chess);
        assertNotNull(chess.getSquare('a', 1).getFigure());
        assertNull(chess.getSquare('b', 1).getFigure());

    }

    @Test
    void getSquare() {
        //setup
        var chess = Chess.createEnglishDraughts();
        //when
        var square = chess.getSquare('a',1);
        //then
        assertNotNull(square);


    }
}
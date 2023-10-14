package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BishopBlackTest {

    @Test
    public void whenCreatedOnB3positionB3() {
        BishopBlack bishop = new BishopBlack(Cell.B3);
        Cell expected = Cell.B3;
        assertThat(bishop.position()).isEqualTo(expected);
    }

    @Test
    public void whenCopyA5newObjectOnA5() {
        BishopBlack bishop = new BishopBlack(Cell.B3);
        Figure copied = bishop.copy(Cell.A5);
        Cell expected = Cell.A5;
        assertThat(copied.position()).isEqualTo(expected);
    }

    @Test
    public void whenMoveC1G5thenD2E3F4G5() {
        Cell[] way = new BishopBlack(Cell.C1).way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(way).containsExactly(expected);
    }

    @Test
    public void whenMoveNotDiagonalThrowsException() {
        ImpossibleMoveException exception = assertThrows(
                ImpossibleMoveException.class,
                () -> {
                    new BishopBlack(Cell.C1).way(Cell.G6);
                });
        assertThat(exception.getMessage()).isEqualTo("Could not way by diagonal from C1 to G6");
    }
}
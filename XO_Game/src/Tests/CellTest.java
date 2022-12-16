package Tests;

import Model.Board;
import Model.Cell;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {

    @Test
    public void isFREE() {
        Cell cell = new Cell();
        assertTrue(cell.isFREE());
    }

    @Test
    public void isX() {
        Cell cell = new Cell();
        cell.state = Board.X;
        assertTrue(cell.isX());
    }

    @Test
    public void isO() {
        Cell cell = new Cell();
        cell.state = Board.O;
        assertTrue(cell.isO());
    }

    @Test
    public void isF() {
        Cell cell = new Cell();
        cell.state = Board.F;
        assertTrue(cell.isF());
    }

    @Test
    public void isValidCell() {
        Cell cell = new Cell();
        assertFalse(cell.isValidCell(20,20));
    }
}
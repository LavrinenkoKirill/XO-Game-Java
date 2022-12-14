package View;

import Model.Board;

import javax.swing.*;

public class GameView extends JFrame {
    private static final int DEFAULT_WIDTH = 500;
    private static final int DEFAULT_HEIGHT = 600;


    public GameView(int size){
        super("TIC-TAC-TOE");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        super.setLocationByPlatform(true);
        Board brd = new Board(size);
        BoardView board = new BoardView(brd,this);
        setContentPane(board);
        setUndecorated(true);
        setVisible(true);
    }


}

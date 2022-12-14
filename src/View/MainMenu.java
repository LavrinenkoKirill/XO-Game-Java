package View;
import Model.Board;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainMenu extends JFrame {
    public MainMenu() {
        super("TIC-TAC-TOE");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        JPanel contents = new JPanel();
        JLabel name = new JLabel(" TIC-TAC-TOE ");
        name.setFont(new Font("Serif", Font.PLAIN, 40));
        name.setPreferredSize(new Dimension(300, 100));
        JButton button1 = new JButton("CREATE NEW GAME");
        button1.setPreferredSize(new Dimension(500, 100));
        JButton button2 = new JButton("JOIN THE GAME");
        button2.setPreferredSize(new Dimension(500, 100));
        contents.add(name);
        contents.add(button1);
        contents.add(button2);
        ActionListener actionListener = new TestActionListener();
        button1.addActionListener(actionListener);
       // ActionListener computerListener = new TestChooseMenuListener();
      //  button2.addActionListener(computerListener);
        setContentPane(contents);
        setVisible(true);

    }


    public class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose();
            JFrame chooseMenu = new JFrame();
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setSize(600, 400);
            JPanel contents = new JPanel();
            JLabel name = new JLabel("Choose game mode");
            name.setFont(new Font("Serif", Font.PLAIN, 50));
            name.setPreferredSize(new Dimension(300, 100));
            JButton button1 = new JButton("3X3");
            button1.setPreferredSize(new Dimension(500, 100));
            JButton button2 = new JButton("5X5");
            button2.setPreferredSize(new Dimension(500, 100));
            JButton button3 = new JButton("10X10");
            button3.setPreferredSize(new Dimension(500, 100));
            ActionListener first = new FirstButtonListener();
            button1.addActionListener(first);
            ActionListener second = new SecondButtonListener();
            button2.addActionListener(second);
            ActionListener third = new ThirdButtonListener();
            button3.addActionListener(third);
            contents.add(name);
            contents.add(button1);
            contents.add(button2);
            contents.add(button3);
            setContentPane(contents);
            setVisible(true);
        }
    }

    public class FirstButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose();
            new GameView(3);
        }
    }

    public class SecondButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose();
            new GameView(5);
        }
    }

    public class ThirdButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            dispose();
            new GameView(10);
        }
    }
}
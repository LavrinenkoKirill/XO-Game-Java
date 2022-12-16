package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostGameMenu extends JDialog {
    public PostGameMenu(GameView view, String str) {
        super(view, "Post game menu");
        this.setLayout(new FlowLayout());
        this.add(new JLabel(str));
        this.setSize(300, 300);
        this.setVisible(true);

    }
}

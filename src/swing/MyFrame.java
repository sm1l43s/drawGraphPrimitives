package swing;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyFrame() {

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();

        setTitle("Лабораторная работа. Браусов Д.Д.");
        setResizable(false);
        setSize(dimension);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        add(new MyPanel());
        setVisible(true);
    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
    }

}

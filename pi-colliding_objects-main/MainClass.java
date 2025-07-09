
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferStrategy;

/**
 * Write a description of class Objekt here.
 *
 * @author Leo 
 * @version 09.07.2025
 */

public class MainClass extends JFrame{
    MyCanvas canvas;
    public MainClass() {
        Frame f = new Frame("Canvas Example");
        f.setVisible(true);
        setVisible(true);
        f.add(new MyCanvas(1920));
        f.setLayout(null);
        f.setSize(1920, 1080);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new MainClass();
    }
}
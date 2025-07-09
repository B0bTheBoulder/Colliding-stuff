
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.GraphicsConfiguration;

/**
 * Write a description of class MyCanvas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

class MyCanvas extends Canvas {
    public static final int heightAll = 850;
    public static final int size = 100;
    public static final int initial_position1 = 400;
    public static final int initial_position2 = 1920-size-10;

    private static final int TIMER_DELAY_MILLIS = 1000 / 30; // 30 FPS

    private int mass1 = 1;
    private int mass2 = 1;
    private int v1 = 0;
    private int v2 = -10;
    private int x1 = initial_position1;
    private int x2 = initial_position2;
    private int canvasSize;
    BufferStrategy bs;
    private final Timer timer;
    

    public MyCanvas(int pcanvasSize) {
        setVisible(true);
        setVisible(true);
        canvasSize = pcanvasSize;
        setBackground(Color.BLACK);
        setSize(canvasSize, canvasSize);

        timer = new Timer(TIMER_DELAY_MILLIS, (event) -> {
            collision();
            movement();
            repaint();
        });
        timer.start();
    }

    public void paint(Graphics g) {
        Graphics2D g2=null;
        try{
        g2 = (Graphics2D) bs.getDrawGraphics();
        draw(g2);
        } finally {
        g2.dispose();
        }
        bs.show();
        
    }
        
    public void draw(Graphics2D g2){
        g2.setColor(Color.BLUE);
        g2.fillRect(x1, (heightAll-100), 100, 100);
        g2.fillRect(x2, (heightAll-size), size, size);
        g2.drawLine(0, heightAll+3, canvasSize, heightAll+3);

        int stringY1 = heightAll - 105;
        g2.drawString("masse: " + mass1, x1, stringY1);
        int stringY2 = heightAll - 105;
        g2.drawString("masse: " + mass2, x2, stringY2);
    }
    
    public void movement(){
        x1 = x1 + v1;
        x2 = x2 + v2;
    }
    
    public void collision(){
        createBufferStrategy(2);
        bs = this.getBufferStrategy();
    }

    private void stopAnimation() {
        timer.stop();
    }
}
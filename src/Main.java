import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

public class Main implements Runnable{

    static int WIDTH = 1000;
    static int HEIGHT = 800;

    public int xpos = 0;
    public int ypos = 0;
    public BufferStrategy bufferStrategy;

    public Main(){

        JFrame frame = new JFrame("Cyclotron Simulator");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JButton("Run!"), BorderLayout.SOUTH);

        Canvas canvas = new Canvas();
        canvas.setBackground(Color.BLACK);
        panel.add(canvas);

        frame.add(panel);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.getBufferStrategy();


    }


    public static void main(String[] args) {

        Main main = new Main();
        new Thread(main).start();
    }


    public void render(){

        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.setColor(Color.BLACK);
        g.fillRect(0,0,WIDTH,HEIGHT);

        g.setColor(Color.WHITE);
        g.drawOval(180,50,650,650);
        g.fillOval(180,50,650,650);

        int internalXPos = 505;

        for (int a = 0; a <= 20; a++){
            for (int ypos = 175; ypos < 575; ypos++){
                g.setColor(Color.BLACK);
                g.fillOval(internalXPos,ypos,5,5);
            }
        }

        g.setColor(Color.RED);
        g.fillOval(505,375,5,5);

        g.setColor(Color.CYAN);
        g.drawLine(500,40,500,700);

        g.dispose();
        bufferStrategy.show();
    }

    public void run() {
        while (true) {

            moveThings();
            render();  // paint the graphics
            pause(20); // sleep for 10 ms
        }
    }

    public void pause(int time){
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

    public void moveThings(){
        xpos = xpos+3;
        ypos = ypos+1;
    }


}

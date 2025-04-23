import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

//Questions for Mx. Bradford:
//1) Do I still need the moveThings() method
//2) Does my double for loop make sense... how would I add the animation?
//3) Is there a way to make my code cleaner... do I need to construct the 'oval' manually?

//Next Steps:
//Implement the Physics into the render() method


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

        for (int a = 0; a <= 20; a++){
            for (int ypos = 40; ypos < 710; ypos++){
                g.setColor(Color.BLACK);
                g.fillOval(505, ypos,5,5);
                //pause(10); //shows the animation?
            }
        }

        g.setColor(Color.RED);
        g.fillOval(505,375,5,5); //this point is the center of the Cyclotron
        //...as long as I don't adjust the previous drawOval

//        g.setColor(Color.CYAN);
//        g.drawLine(500,40,500,700);

        for (int xpos = 150; xpos < 900; xpos = xpos+60){
            for (int ypos = 40; ypos < 850; ypos = ypos+60){
                g.setColor(Color.BLUE);
                g.fillOval(xpos, ypos,5,5);
            }
        }

        g.dispose();
        bufferStrategy.show();
    }

    public void run() {
        while (true) {

            //moveThings(); //do I need it???
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
        //xpos = xpos+3;
        //ypos = ypos+1;
    }


}

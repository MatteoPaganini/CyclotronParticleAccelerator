import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

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
    public int angle = -20;

    public double angle0;
    public double angle1;
    public double angle2;
    public double angle3;

    public BufferStrategy bufferStrategy;

    public List<Physics> bodies;

    public Main(){

        JFrame frame = new JFrame("Cyclotron Simulator");
        frame.setSize(WIDTH, HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JButton("Run!"), BorderLayout.SOUTH);
        panel.add(new JButton("See B Field"), BorderLayout.NORTH);

        Canvas canvas = new Canvas();
        canvas.setBackground(Color.BLACK);
        panel.add(canvas);

        frame.add(panel);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.getBufferStrategy();

        bodies = new ArrayList<>();
        bodies.add(new Physics(10,10));

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

        int centerX = 505;
        int centerY = 375;
        int radius = 100;

        int movingX = centerX +(int)(radius*cos(angle));
        int movingY = centerY +(int)(radius*sin(angle));

        g.setColor(Color.YELLOW);
        g.fillOval(movingX,movingY,10,10);

        for (Physics physics : bodies){
            g.setColor(Color.RED);
            g.fillOval(515,275,15,15);

            update();
        }

        g.dispose();
        bufferStrategy.show();
    }

    public void run() {
        while (true) {

            //moveThings(); //do I need it???
            render();  // paint the graphics
            pause(2000); // sleep for 2s
        }
    }

    public void pause(int time){
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

    public void update(){
        for (Physics physics : bodies){

            double f1 = (physics.q)*(physics.v)*(physics.B);
            System.out.println("Force: " + f1 + " N");
            double r1 = (physics.m*physics.v) / (physics.q*physics.B);
            System.out.println("Radius: " + r1 + " meters");

            angle0 = 0;
            double x1 = r1*cos(angle0);
            double y1 = r1*sin(angle0);
            System.out.println("(" + x1 + "," + y1 + ")");
            System.out.println(" ");



            //create an if statement
            physics.v = physics.v + 100;



            double f2 = (physics.q)*(physics.v)*(physics.B);
            System.out.println("Force: " + f2 + " N");
            double r2 = (physics.m*physics.v) / (physics.q*physics.B);
            System.out.println("Radius: " + r2 + " meters");

            angle1 = 1 / (y1/x1);
            double x2 = r2*cos(angle1);
            double y2 = r2*sin(angle1);
            System.out.println("(" + x2 + "," + y2 + ")");
            System.out.println(" ");

        }
    }

    public void moveThings(){
        //xpos = xpos+3;
        //ypos = ypos+1;
    }


}

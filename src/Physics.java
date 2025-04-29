import static java.lang.Math.*;

public class Physics {

    double v = 1e8; //velocity (m/s)
    double B = 1.0; //magnetic field (T)
    double q = 1.6e-19; //point charge (C)
    double R; //radius (m)
    double m = 1.67e-27; //mass (kg)
    double V; //potential difference (V)
    double F; //force (N)
    double w; //angular frequency (Hz)
    double theta = 3.14159/2; //angle (radians)
    double c = 2.99e8; //speed of light


    public static void main(String[] args) {
        //new Physics();
    }

//    Physics(){
//        PhysicsMath(); //I turned PhysicsMath into Physics constructor
//    }

    public Physics(){

        F = q*v*B; //assuming perpendicularity between v and B
        R = (m*v) / (q*B); //if we adjust for relativity, we have to add the multiplier "gamma" before mv

        V = (m*v*v) / (2*q); //again here if we adjust for relativity, we substitute '(1+gamma)' for '2'
        w = (q*B / m); //angular frequency is independent of v

        System.out.println(F + " N");
        System.out.println(R + " m");
    }

}

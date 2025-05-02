import static java.lang.Math.*;

public class Physics {

    double v = 2.73e5; //velocity (m/s)
    double B = 1.0; //magnetic field (T)
    double q = 1.602e-19; //point charge (C)
    double R; //radius (m)
    double m = 1.67e-27; //mass (kg)
    double V = 50000; //potential difference (V)
    double F; //force (N)
    double w; //angular frequency (Hz)
    double PE; //potential energy (J)
    double E; //electric field (V/m)
    double vFinal1;
    double aThroughGap; //constant a of the particle through the gap (m/s*s)
    double x = 0.02; //distance between the dees (m)
    double vFinal2; //change in v through the gap due to voltage difference
    double c = 2.99e8; //speed of light


    public static void main(String[] args) {
        new Physics();
    }

    public Physics(){

        F = q*v*B; //assuming perpendicularity between v and B
        R = (m*v) / (q*B); //if we adjust for relativity, we have to add the multiplier "gamma" before mv
        PE = q*V;
        E = V/x;
        aThroughGap = (q*E) / m;
        vFinal1 = (2*aThroughGap*x);
        vFinal2 = sqrt(vFinal1);

        //V = (m*v*v) / (2*q); //again here if we adjust for relativity, we substitute '(1+gamma)' for '2'
        w = (q*B / m); //angular frequency is independent of v

        System.out.println(F + " N");
        System.out.println(R*100 + " cm");
        System.out.println(PE + " J");
        System.out.println(aThroughGap + " m/s*s");
        System.out.println(vFinal2 + " m/s");
        System.out.println(w + " Hz");

    }

}

import static java.lang.Math.*;

public class Physics {

    double v; //velocity
    double B; //magnetic field
    double q; //point charge
    double R; //radius
    double m; //mass
    double V; //potential difference
    double F; //force
    double theta;
    //double c = 2.99 * 10^8; //how do I make this cleaner
    double c = 2.99 * 100000000;


    public void PhysicsMath(){
        F = q * (v*B*sin(theta));
        R = m*v / (q*B); //if we adjust for relativity, we have to add the multiplyer "gamma" before mv
        V = (m*v*v) / 2*q; //again here if we adjust for relativity, we substitute '(1+gamma)' for '2'
    }

}

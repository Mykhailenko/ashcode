package main;

import java.util.HashSet;
import java.util.Set;

public class Simulator {

    private int B;

    private int R;

    private int C;

    private int F;

    private int T;

    private Set<Car> cars = new HashSet<Car>();

    private Set<Ride> nonAsignedRides = new HashSet<Ride>();


    public int score(){
        return 0;
    }

    public void simulate(){
        for(int t = 0; t < T; ++t){
            while(tryToAssign());

            for (Car car : cars) {
                move(car);
            }

        }
    }

    private void move(Car car) {
    }

    private boolean tryToAssign() {
        return false;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
    }

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        C = c;
    }

    public int getF() {
        return F;
    }

    public void setF(int f) {
        F = f;
    }

    public int getT() {
        return T;
    }

    public void setT(int t) {
        T = t;
    }


    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }

    public Set<Ride> getNonAsignedRides() {
        return nonAsignedRides;
    }

    public void setNonAsignedRides(Set<Ride> nonAsignedRides) {
        this.nonAsignedRides = nonAsignedRides;
    }
}

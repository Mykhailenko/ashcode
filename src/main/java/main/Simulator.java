package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Simulator {

    private int B;

    private int R;

    private int C;

    private int F;

    private int T;

    private List<Car> cars = new ArrayList<Car>();

    private Set<Ride> nonAsignedRides = new HashSet<Ride>();


    private boolean tryToAssign(int t) {
        Car free = null;
        for (Car car : cars) {
            if(car.isFree()){
                free = car;
                break;
            }
        }

        if(free != null){
            for (Ride ride : nonAsignedRides) {
                int k = koef(t, free, ride);
            }

        }


        return false;
    }

    private int koef(int t, Car free, Ride ride) {
        ride.getEarliestStart() - ()
    }

    public int score(){
        return 0;
    }

    public void simulate(){
        for(int t = 0; t < T; ++t){
            while(tryToAssign(t));

            for (Car car : cars) {
                move(car);
            }

        }
    }

    private void move(Car car) {
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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Set<Ride> getNonAsignedRides() {
        return nonAsignedRides;
    }

    public void setNonAsignedRides(Set<Ride> nonAsignedRides) {
        this.nonAsignedRides = nonAsignedRides;
    }
}

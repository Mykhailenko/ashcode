package main;

import java.util.Set;

public class Simulator {

    private int bonus;

    private int R;

    private int C;

    private int T;

    private Set<Car> cars;

    private Set<Ride> nonAsignedRides;

    public Simulator(int bonus, int r, int c, int t, Set<Car> cars, Set<Ride> nonAsignedRides) {
        this.bonus = bonus;
        R = r;
        C = c;
        T = t;
        this.cars = cars;
        this.nonAsignedRides = nonAsignedRides;
    }

    public Set<Car> getCars() {
        return cars;
    }

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
}

package main;

import java.util.ArrayList;
import java.util.List;

public class Car {

    private final int id;

    private List<Ride> completed = new ArrayList<Ride>();

    private Ride ride = null;

    private Cord cord = new Cord();

    public Car(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return id == car.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public boolean isFree(){
        return ride == null;
    }

    public List<Ride> getCompleted() {
        return completed;
    }

    public void setCompleted(List<Ride> completed) {
        this.completed = completed;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public Cord getCord() {
        return cord;
    }

    public void setCord(Cord cord) {
        this.cord = cord;
    }
}

package store;

import model.Car;
import model.Driver;
import model.Engine;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.setEngine(Hibernate.getInstance().findItem(1));
        car.getDrivers().add(Hibernate.getInstance().findDriver(1));
        car.getDrivers().add(Hibernate.getInstance().findDriver(2));
        car.getDrivers().add(Hibernate.getInstance().findDriver(3));
        Hibernate.getInstance().add(car);
    }
}

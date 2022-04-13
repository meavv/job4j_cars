package model;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String body;
    private String color;

    public Car(String brand, String body, String color) {
        this.brand = brand;
        this.body = body;
        this.color = color;
    }

    public Car() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id && Objects.equals(brand, car.brand)
                && Objects.equals(body, car.body) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, body, color);
    }

    @Override
    public String toString() {
        return "Car{" + "id=" + id + ", brand='"
                + brand + '\'' + ", body='" + body + '\''
                + ", color='" + color + '\'' + '}';
    }
}
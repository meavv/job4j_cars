package model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;
    private boolean sold;
    private Date dateCreated;
    private boolean havePhoto;
    private double price;
    private String photo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @OneToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public static Item of(String description, double price, User user, Car car, String photo) {
        Item item = new Item();
        item.description = description;
        item.sold = false;
        item.dateCreated = new Date();
        item.havePhoto = true;
        item.price = price;
        item.author = user;
        item.car = car;
        item.photo = photo;
        return item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public boolean isHavePhoto() {
        return havePhoto;
    }

    public void setHavePhoto(boolean havePhoto) {
        this.havePhoto = havePhoto;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id && sold == item.sold && havePhoto == item.havePhoto
                && Double.compare(item.price, price) == 0 && Objects.equals(description, item.description)
                && Objects.equals(dateCreated, item.dateCreated) && Objects.equals(author, item.author)
                && Objects.equals(car, item.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, sold, dateCreated, havePhoto, price, author, car);
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id
                + ", description='" + description + '\''
                + ", sold=" + sold + ", dateCreated=" + dateCreated
                + ", havePhoto=" + havePhoto + ", price=" + price
                + ", author=" + author + ", car=" + car + '}';
    }
}

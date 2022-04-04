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
    private String brand;
    private String body;
    private boolean sold;
    private Date dateCreated;
    private boolean havePhoto;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    public static Item of(String description, String brand, String body, User author, boolean havePhoto) {
        Item item = new Item();
        item.description = description;
        item.brand = brand;
        item.body = body;
        item.author = author;
        item.sold = false;
        item.havePhoto = havePhoto;
        item.dateCreated = new Date();
        return item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id && sold == item.sold
                && Objects.equals(description, item.description) && Objects.equals(brand, item.brand)
                && Objects.equals(body, item.body) && Objects.equals(author, item.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, brand, body, sold, author);
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", description='" + description + '\''
                + ", brand='"
                + brand + '\'' + ", body='" + body + '\''
                + ", sold=" + sold + ", dateCreated=" + dateCreated
                + ", havePhoto=" + havePhoto + ", author=" + author + '}';
    }
}

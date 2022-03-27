package model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "j_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private String password;

    public static User of(String name, String email, String password) {
        User user = new User();
        user.email = email;
        user.name = name;
        user.password = password;
        return user;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\''
                + ", email='" + email + '\''
                + ", password='" + password + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name)
                && Objects.equals(email, user.email) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password);
    }

}

package store;

import model.*;

public class Main {
    public static void main(String[] args) {
        Item item = Item.of("Описание", "BMW", "Седан", Hibernate.getInstance().findUser(1));
        Hibernate.getInstance().add(item);
    }
}

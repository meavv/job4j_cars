package store;

import model.User;

public class Main {

    public static void main(String[] args) {

        var s = Hibernate.getInstance().findAllItem();
        System.out.println(s);

    }


}

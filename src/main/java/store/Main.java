package store;

import model.Brand;
import model.User;

public class Main {

    public static void main(String[] args) {
        var s = CarRepository.findAllBrand();
        System.out.println(s.toString());

    }


}

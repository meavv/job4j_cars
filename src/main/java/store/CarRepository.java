package store;

import model.Brand;
import model.Car;
import model.Item;
import model.User;

import java.util.List;

public class CarRepository {
    private static final Hibernate h = Hibernate.getInstance();

    public static Car add(Car o) {
        h.tx(session -> session.save(o));
        return o;
    }

    public Car findCar(int id) {
        return h.tx(session -> (session.get(Car.class, id)));
    }

    public static Brand add(Brand o) {
        h.tx(session -> session.save(o));
        return o;
    }

    public Brand findBrand(int id) {
        return h.tx(session -> (session.get(Brand.class, id)));
    }

    public static Brand findBrand(String email) {
        return h.tx(session -> {
            String hql = "from model.Brand where name = :nameParam";
            var query = session.createQuery(hql);
            query.setParameter("nameParam", email);
            return (Brand) query.uniqueResult();
        });
    }

    public static List<Brand> findAllBrand() {
        return h.tx(session -> session.createQuery("from Brand", Brand.class).getResultList());
    }

}

package store;

import model.Item;

import java.util.List;

public class AdsRepository {

    private static final Hibernate h = Hibernate.getInstance();

    public static boolean changeStatus(int id) {
        return h.tx(session -> {
            String hql = "update model.Item set sold = true where id = :idParam";
            var query = session.createQuery(hql);
            query.setParameter("idParam", id);
            int result = query.executeUpdate();
            return result != 0;
        });
    }

    public static void add(Item o) {
        h.tx(session -> (session.save(o)));
    }

    public static List<Item> findAllItem() {
        return h.tx(session -> session.createQuery
                ("from Item where sold = 'false'", Item.class).getResultList());
    }

    public static Item findItem(int id) {
        return h.tx(session -> (session.get(Item.class, id)));
    }
}

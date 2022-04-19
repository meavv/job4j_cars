package store;

import model.User;

public class UserRepository {

    private static final Hibernate h = Hibernate.getInstance();

    public static void add(User o) {
        h.tx(session -> session.save(o));
    }

    public static void del(User o) {
        h.tx(session -> {
            session.remove(o);
            return session;
        });
    }

    public static User findUser(int id) {
        return h.tx(session -> (session.get(User.class, id)));
    }

    public static User findUser(String email) {
        return h.tx(session -> {
            String hql = "from model.User where email = :emailParam";
            var query = session.createQuery(hql);
            query.setParameter("emailParam", email);
            return (User) query.uniqueResult();
        });
    }
}

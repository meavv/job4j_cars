package store;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.function.Function;

public class Hibernate {

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();

    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    public static class Lazy {
        public static final Hibernate HOLDER_INSTANCE = new Hibernate();
    }

    private Hibernate() {

    }

    public static Hibernate getInstance() {
        return Lazy.HOLDER_INSTANCE;
    }

    private <T> T tx(final Function<Session, T> command) {
        final Session session = sf.openSession();
        final Transaction tx = session.beginTransaction();
        try {
            T rsl = command.apply(session);
            tx.commit();
            return rsl;
        } catch (final Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            session.close();
        }
    }

    public void add(Object o) {
        tx(session -> (session.save(o)));
    }

    public void del(Object o) {
        tx(session -> {
            session.remove(o);
            return session;
        });
    }

    public Engine findEngine(int id) {
        return tx(session -> (session.get(Engine.class, id)));
    }

    public Car findCar(int id) {
        return tx(session -> (session.get(Car.class, id)));
    }

    public Driver findDriver(int id) {
        return tx(session -> (session.get(Driver.class, id)));
    }

    public User findUser(int id) {
        return tx(session -> (session.get(User.class, id)));
    }

    public Item findItem(int id) {
        return tx(session -> (session.get(Item.class, id)));
    }

}

package web.repositories;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepository {

    @PersistenceContext
    EntityManager em;

    public List<User> getAllUsers() {
        return em.createQuery("select u from User u", User.class).getResultList();
    }

    public void add(User user) {
        em.persist(user);
    }

    public void delete(int id) {
        User user = getById(id);
        em.remove(user);
    }

    public void edit(User user) {
        em.merge(user);
    }

    public User getById(int id) {
        TypedQuery<User> query = em.createQuery("select u from User u where u.id = :id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }
}
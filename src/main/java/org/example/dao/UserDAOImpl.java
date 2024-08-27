package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.example.model.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = false)
    public void addUser(User user) {
        em.persist(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void updateUser(User user) {
        em.merge(user);
    }

    @Override
    public List<User> getAll() {
        return em.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return em.createQuery("from User where id=:person_id", User.class)
                .setParameter("person_id", id)
                .getSingleResult();
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteUser(int id) {
        User user = getUserById(id);
        if (user != null) {
            em.remove(user);
        }
    }
}

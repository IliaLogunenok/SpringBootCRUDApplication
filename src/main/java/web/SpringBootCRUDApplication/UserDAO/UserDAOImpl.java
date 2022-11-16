package web.SpringBootCRUDApplication.UserDAO;

import org.springframework.stereotype.Component;
import web.SpringBootCRUDApplication.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private final EntityManager entityManager;

    public UserDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        return entityManager.createQuery("SELECT u FROM User u ORDER BY u.id", User.class).getResultList();
    }

    @Override
    public User findOne(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(int id, User updateUser) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updateUser.getName());
        userToBeUpdated.setSurname(updateUser.getSurname());
    }


    @Override
    public void delete(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User show(int id) {
        TypedQuery<User> userTypedQuery = entityManager.createQuery(
                "select u from User u where u.id = :id", User.class);
        userTypedQuery.setParameter("id", id);
        return userTypedQuery.getSingleResult();
    }
}

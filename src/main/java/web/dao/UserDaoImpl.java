package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    EntityManager em;
    public List<User> getAllUsers() {
        return em.createQuery("from User", User.class).getResultList();
    }


    public void saveUser(User user) {
        em.persist(user);
    }

    public void deleteUser(long id) {
        em.createQuery("delete from User u where u.id =:id")
                .setParameter("id", id).executeUpdate();
    }

    public User getUserById(long id) {
        return em.createQuery("SELECT u FROM User u WHERE u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void updateUser(long id, User updatedUser) {
        User userToBeUpdated = getUserById(id);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setSurname(updatedUser.getSurname());
        userToBeUpdated.setAge(updatedUser.getAge());
        userToBeUpdated.setDepartment(updatedUser.getDepartment());
        userToBeUpdated.setSalary(updatedUser.getSalary());

    }


}

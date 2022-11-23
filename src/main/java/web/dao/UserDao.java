package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(long id);

    User getUserById(long id);

    void updateUser(long id, User updatedUser);

}

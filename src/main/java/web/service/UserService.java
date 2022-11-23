package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(long id);

    User getUserById(long id);

    void updateUser(long id, User updatedUser);

}

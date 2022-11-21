package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService users = new UserServiceImpl();
        users.createUsersTable();
        users.saveUser("Egor", "Brows", (byte) 25);
        users.saveUser("Sven", "Cat", (byte) 4);
        users.saveUser("Daria", "Ice", (byte) 20);
        users.saveUser("Max", "Cat", (byte) 11);
        System.out.println(users.getAllUsers());
        users.removeUserById(1);
        users.removeUserById(4);
        System.out.println(users.getAllUsers());
        users.saveUser("Crispy", "Cat", (byte) 1);
        System.out.println(users.getAllUsers());
        users.cleanUsersTable();
        users.dropUsersTable();
    }
}

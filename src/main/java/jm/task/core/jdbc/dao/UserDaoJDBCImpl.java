package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Util.getConnection();
            stmt = conn.createStatement();
            stmt.execute("create table IF NOT EXISTS USERS (\n" +
                    "   ID bigint not null AUTO_INCREMENT,\n" +
                    "   NAME varchar(255) not null,\n" +
                    "   LASTNAME varchar(255) not null,\n" +
                    "   AGE tinyint not null,\n" +
                    "   primary key (ID)\n" +
                    ");");
            System.out.println("table users has been successfully created");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null & stmt != null) {
                try {
                    stmt.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void dropUsersTable() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Util.getConnection();
            stmt = conn.createStatement();
            stmt.execute("drop table if exists users;");
            System.out.println("table users has been successfully dropped");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null & stmt != null) {
                try {
                    stmt.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Util.getConnection();
            stmt = conn.prepareStatement("insert into users (name, lastname, age) values (?, ? ,?);");
            stmt.setString(1, name);
            stmt.setString(2, lastName);
            stmt.setByte(3, age);
            stmt.executeUpdate();
            System.out.println("User with name: " + name + ", lastname: " + lastName +
                    ", age: " + age + " has been successfully added");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null & stmt != null) {
                try {
                    stmt.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void removeUserById(long id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = Util.getConnection();
            stmt = conn.prepareStatement("delete from users where id = ?;");
            stmt.setLong(1, id);
            stmt.executeUpdate();
            System.out.println("User with id " + id + " has been successfully removed");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null & stmt != null) {
                try {
                    stmt.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<User> getAllUsers() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<User> users = new ArrayList<>();
        try {
            conn = Util.getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select id, name, lastname, age from users;");
            while (rs.next()) {
                User user = new User(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getByte(4)
                        );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null & stmt != null & rs != null) {
                try {
                    rs.close();
                    stmt.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }

    public void cleanUsersTable() {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = Util.getConnection();
            stmt = conn.createStatement();
            stmt.execute("truncate table users;");
            System.out.println("table users has been successfully truncated");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null & stmt != null) {
                try {
                    stmt.close();
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

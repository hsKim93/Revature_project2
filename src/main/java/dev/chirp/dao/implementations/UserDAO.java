package dev.chirp.dao.implementations;

import dev.chirp.customexceptions.DuplicateException;
import dev.chirp.dao.interfaces.UserDAOInt;
import dev.chirp.entities.User;
import dev.chirp.utility.ConnectionDB;

import java.sql.*;
import java.util.ArrayList;

public class UserDAO implements UserDAOInt {

    @Override
    public User requestLogin(String userName, String password) {
        try (Connection connection = ConnectionDB.createConnection()) {
            String sql = "select user_id, user_name, first_name, last_name, email, is_admin " +
                    "from \"project2\".users where user_name = ? and password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new User(
                    resultSet.getInt("user_id"),
                    resultSet.getString("user_name"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email"),
                    resultSet.getBoolean("is_admin")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User createAccount(String userName, String password, String firstName, String lastName, String email) {
        try (Connection connection = ConnectionDB.createConnection()) {
            String sql = "insert into \"project2\".users values(default, ?, ?, ?, ?, ?, default) " +
                    "returning user_id, user_name, first_name, last_name, email";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, lastName);
            preparedStatement.setString(5, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new User(
                    resultSet.getInt("user_id"),
                    resultSet.getString("user_name"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            if (e.getMessage().contains("user_name")) {
                throw new DuplicateException("duplicate user name");
            } else if (e.getMessage().contains("email")) {
                throw new DuplicateException("duplicate email");
            } else {
                return null;
            }
        }
    }

    @Override
    public ArrayList<User> getUsers() {
        try (Connection connection = ConnectionDB.createConnection()) {
            String sql = "select user_id, user_name, first_name, last_name, email from" +
                    "\"project2\".users where is_admin = false";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ArrayList<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("user_id"),
                        resultSet.getString("user_name"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getString("email")
                ));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User getUserById(int id) {
        try (Connection connection = ConnectionDB.createConnection()) {
            String sql = "select user_id, user_name, first_name, last_name, email from" +
                    "\"project2\".users where user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new User(
                    resultSet.getInt("user_id"),
                    resultSet.getString("user_name"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<User> getUsersByFirstName(String firstName) {
        try (Connection connection = ConnectionDB.createConnection()) {
            String sql = "select user_id, user_name, first_name, last_name, email from " +
                    "\"project2\".users where first_name ilike ? and is_admin = false";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + firstName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            ArrayList<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(
                        new User(
                                resultSet.getInt("user_id"),
                                resultSet.getString("user_name"),
                                resultSet.getString("first_name"),
                                resultSet.getString("last_name"),
                                resultSet.getString("email")
                        )
                );
            }
            return !users.isEmpty() ? users : null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User editUserInformationById(int id, String userName, String password,
                                        String firstName, String LastName, String email) {
        try (Connection connection = ConnectionDB.createConnection()) {
            String sql;
            PreparedStatement preparedStatement;
            if (password.isEmpty()) {
                sql = "update  \"project2\".users set user_name = ?, first_name = ?, " +
                        "last_name = ?, email = ? where user_id = ? " +
                        "returning user_id, user_name, first_name, last_name, email";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, firstName);
                preparedStatement.setString(3, LastName);
                preparedStatement.setString(4, email);
                preparedStatement.setInt(5, id);
            } else {
                sql = "update  \"project2\".users set user_name = ?, password = ?, first_name = ?, " +
                        "last_name = ?, email = ? where user_id = ? " +
                        "returning user_id, user_name, first_name, last_name, email";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, firstName);
                preparedStatement.setString(4, LastName);
                preparedStatement.setString(5, email);
                preparedStatement.setInt(6, id);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new User(
                    resultSet.getInt("user_id"),
                    resultSet.getString("user_name"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            if (e.getMessage().contains("user_name")) {
                throw new DuplicateException("duplicate user name");
            } else if (e.getMessage().contains("email")) {
                throw new DuplicateException("duplicate email");
            } else {
                return null;
            }
        }
    }

    @Override
    public User deleteUserById(int id) {
        try (Connection connection = ConnectionDB.createConnection()) {
            String sql = "delete from  \"project2\".users where user_id = ? " +
                    "returning user_id, user_name, first_name, last_name, email";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new User(
                    resultSet.getInt("user_id"),
                    resultSet.getString("user_name"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("email")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

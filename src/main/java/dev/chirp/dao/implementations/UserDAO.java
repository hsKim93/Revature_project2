package dev.chirp.dao.implementations;

import dev.chirp.dao.interfaces.UserDAOInt;
import dev.chirp.entities.User;
import dev.chirp.utility.ConnectionDB;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO implements UserDAOInt {

    static Logger logger = LoggerFactory.getLogger(UserDAO.class);

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
            logger.error("SQLException in UserDAO.requestLogin");
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
            return null;
        }
    }

    @Override
    public User editUserInformationById(int id, String userName, String password,
                                        String firstName, String LastName, String email) {
        try (Connection connection = ConnectionDB.createConnection()) {
            String sql = "update  \"project2\".users set user_name = ?, password = ?, first_name = ?, " +
                    "last_name = ?, email = ? where user_id = ? " +
                    "returning user_id, user_name, first_name, last_name, email";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, LastName);
            preparedStatement.setString(5, email);
            preparedStatement.setInt(6, id);
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
            return null;
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
            return null;
        }
    }
}

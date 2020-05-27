package service;

import entity.User;
import storage.UserStorage;

public class UserService {

    private UserStorage userStorage = new UserStorage();

    public User authService(String login, String password) {
        User user = userStorage.getUserByLogin(login);
        if (user == null) {
            return null;
        } else {
            if (user.getPassword().equals(password)) {
                return user;
            } else {
                return null;
            }
        }
    }

    public String authMessageService(String login, String password) {
        User user = userStorage.getUserByLogin(login);
        String message;
        if (user == null) {
            message = "User " + login + " not found";
            return message;
        } else {
            if (!user.getPassword().equals(password)) {
                message = "Password not correct";
                return message;
            }
        }
        return null;
    }
}

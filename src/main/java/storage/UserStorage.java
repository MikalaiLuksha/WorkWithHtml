package storage;

import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserStorage {

    private static List<User> list = new ArrayList<>();

    public void add(User user) {
        list.add(user);
    }

    public User getUserByLogin(String login) {
        for (User user : list) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public boolean checkUserByLogin (String login){
        for (User user: list  ) {
            if (user.getLogin().equals(login)){
                return false;
            }
        }
        return true;
    }
}



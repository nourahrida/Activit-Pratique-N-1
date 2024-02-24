package org.miniproject.service;

import org.miniproject.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    private final List<User> users;

    public UserService() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public Optional<User> getUserById(String userId) {
        return users.stream()
                .filter(user -> user.getID().equals(userId))
                .findFirst();
    }

    public void updateUser(User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            if (user.getID().equals(updatedUser.getID())) {
                users.set(i, updatedUser);
                break;
            }
        }
    }

    public void deleteUser(String userId) {
        users.removeIf(user -> user.getID().equals(userId));
    }

    public List<User> searchUsers(String keyword) {
        List<User> searchResults = new ArrayList<>();
        for (User user : users) {
            if (user.getFname().contains(keyword) || user.getLname().contains(keyword) || user.getEmail().contains(keyword)) {
                searchResults.add(user);
            }
        }
        return searchResults;
    }
}

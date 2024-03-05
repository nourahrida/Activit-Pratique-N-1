package org.miniproject.service;

import org.miniproject.model.User;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    void addUser(User user);
    List<User> getAllUsers();
    Optional<User> getUserById(String userId);
    void updateUser(User updatedUser);
    void deleteUser(String userId);
    List<User> searchUsers(String keyword);
}

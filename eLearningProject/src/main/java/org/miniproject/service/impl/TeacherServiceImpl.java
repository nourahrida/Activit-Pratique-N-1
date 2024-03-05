package org.miniproject.service.impl;

import org.miniproject.model.Teacher;
import org.miniproject.model.User;
import org.miniproject.service.IUserService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TeacherServiceImpl implements IUserService {

    private final List<Teacher> teachers = new ArrayList<>();

    @Override
    public void addUser(User user) {
        if (user instanceof Teacher) {
            teachers.add((Teacher) user);
        } else {
            throw new IllegalArgumentException("User must be an instance of Teacher");
        }
    }

    @Override
    public List<User> getAllUsers() {
        // This casts each Teacher back to User, for compatibility with the interface
        return new ArrayList<>(teachers);
    }

    @Override
    public Optional<User> getUserById(String userId) {
        return teachers.stream()
                .filter(teacher -> teacher.getID().equals(userId))
                .findFirst()
                .map(teacher -> (User) teacher);
    }

    @Override
    public void updateUser(User updatedUser) {
        if (!(updatedUser instanceof Teacher)) {
            throw new IllegalArgumentException("User must be an instance of Teacher");
        }
        Teacher updatedTeacher = (Teacher) updatedUser;
        for (int i = 0; i < teachers.size(); i++) {
            Teacher teacher = teachers.get(i);
            if (teacher.getID().equals(updatedTeacher.getID())) {
                teachers.set(i, updatedTeacher);
                return;
            }
        }
    }

    @Override
    public void deleteUser(String userId) {
        teachers.removeIf(teacher -> teacher.getID().equals(userId));
    }

    @Override
    public List<User> searchUsers(String keyword) {
        // Stream through teachers list, matching keyword against various fields
        List<Teacher> searchResults = teachers.stream()
                .filter(teacher -> teacher.getFname().contains(keyword) || teacher.getLname().contains(keyword) || teacher.getEmail().contains(keyword))
                .collect(Collectors.toList());
        return new ArrayList<>(searchResults);
    }
}

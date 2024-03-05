package org.miniproject.service;

import org.miniproject.model.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeacherService {
    private final List<Teacher> teachers;

    public TeacherService(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public List<Teacher> getAllTeachers() {
        return new ArrayList<>(teachers);
    }

    public Optional<Teacher> getTeacherById(String teacherId) {
        return teachers.stream()
                .filter(teacher -> teacher.getID().equals(teacherId))
                .findFirst();
    }

    public void updateTeacher(Teacher updatedTeacher) {
        for (int i = 0; i < teachers.size(); i++) {
            Teacher teacher = teachers.get(i);
            if (teacher.getID().equals(updatedTeacher.getID())) {
                teachers.set(i, updatedTeacher);
                break;
            }
        }
    }

    public void deleteTeacher(String teacherId) {
        teachers.removeIf(teacher -> teacher.getID().equals(teacherId));
    }
}

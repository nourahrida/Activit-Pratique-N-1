package org.miniproject.service;

import org.miniproject.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService {
    private final List<Student> students;

    public StudentService(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public Optional<Student> getStudentById(String studentId) {
        return students.stream()
                .filter(student -> student.getID().equals(studentId))
                .findFirst();
    }

    public void updateStudent(Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getID().equals(updatedStudent.getID())) {
                students.set(i, updatedStudent);
                break;
            }
        }
    }

    public void deleteStudent(String studentId) {
        students.removeIf(student -> student.getID().equals(studentId));
    }

    public List<Student> searchStudents(String keyword) {
        List<Student> searchResults = new ArrayList<>();
        for (Student student : students) {
            if (student.getFname().contains(keyword) || student.getLname().contains(keyword) || student.getEmail().contains(keyword)) {
                searchResults.add(student);
            }
        }
        return searchResults;
    }
}

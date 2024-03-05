package org.miniproject.model;

import org.miniproject.emun.UserType;
import org.miniproject.exception.TeacherUserViolationException;
import org.miniproject.util.AutoIdGenerator;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

public class Course {
    protected final String TeacherUser_Violation_Exception_Message = "The user you are trying to add is not a user with type 'Teacher'. Please verify and try again.";
    protected String ID;
    protected String name;
    protected Teacher teacher;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected int durationInWeeks;
    protected String description;
    protected List<User> enrolledStudents;
    protected List<Exam> enrolledExams;

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) throws TeacherUserViolationException {
       this.teacher = teacher;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        // Calculating the week count between the start date and the end date
        Period period = Period.between(startDate, endDate);
        this.durationInWeeks = (int) (period.toTotalMonths() * 4 + period.getDays() / 7);
    }

    public int getDurationInWeeks() {
        return durationInWeeks;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void setEnrolledStudents(List<User> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }

    public List<Exam> getEnrolledExams() {
        return enrolledExams;
    }

    public void setEnrolledExams(List<Exam> enrolledExams) {
        this.enrolledExams = enrolledExams;
    }

    public Course(String name, Teacher teacher, LocalDate startDate, LocalDate endDate, int durationInWeeks, String description, List<User> enrolledStudents, List<Exam> enrolledExams) {
        this.ID = AutoIdGenerator.generateAutoId(name);
        this.name = name;
        this.teacher = teacher;
        this.startDate = startDate;
        this.endDate = endDate;
        this.durationInWeeks = durationInWeeks;
        this.description = description;
        this.enrolledStudents = enrolledStudents;
        this.enrolledExams = enrolledExams;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return durationInWeeks == course.durationInWeeks && Objects.equals(TeacherUser_Violation_Exception_Message, course.TeacherUser_Violation_Exception_Message) && Objects.equals(ID, course.ID) && Objects.equals(name, course.name) && Objects.equals(teacher, course.teacher) && Objects.equals(startDate, course.startDate) && Objects.equals(endDate, course.endDate) && Objects.equals(description, course.description) && Objects.equals(enrolledStudents, course.enrolledStudents) && Objects.equals(enrolledExams, course.enrolledExams);
    }

    @Override
    public int hashCode() {
        return Objects.hash(TeacherUser_Violation_Exception_Message, ID, name, teacher, startDate, endDate, durationInWeeks, description, enrolledStudents, enrolledExams);
    }

    @Override
    public String toString() {
        return "Course{" +
                "TeacherUser_Violation_Exception_Message='" + TeacherUser_Violation_Exception_Message + '\'' +
                ", ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", durationInWeeks=" + durationInWeeks +
                ", description='" + description + '\'' +
                ", enrolledStudents count=" + enrolledStudents.size() +
                ", enrolledExams count=" + enrolledExams.size() +
                '}';
    }
}

package org.miniproject.model;

import org.miniproject.util.AutoIdGenerator;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Course {
    protected String ID;
    protected String name;
    protected User teacher;
    protected LocalDate startDate;
    protected LocalDate endDate;
    protected int durationInWeeks;
    protected String description;
    protected List<User> enrolledStudents;

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

    public void setTeacher(User teacher) {
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

    public Course(String name, User teacher, LocalDate startDate, LocalDate endDate, int durationInWeeks, String description, List<User> enrolledStudents) {
        this.ID = AutoIdGenerator.generateAutoId(name);
        this.name = name;
        this.teacher = teacher;
        this.startDate = startDate;
        this.endDate = endDate;
        this.durationInWeeks = durationInWeeks;
        this.description = description;
        this.enrolledStudents = enrolledStudents;
    }
}

package org.miniproject.model;

import org.miniproject.util.AutoIdGenerator;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

public class Exam {
    protected String ID;
    protected String name;
    protected LocalDateTime dateTime;
    protected int durationMinutes;
    protected int maxScore;
    protected Course course;
    protected Map<Student, Double> grades;

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Map<Student, Double> getGrades() {
        return grades;
    }

    public void setGrades(Map<Student, Double> grades) {
        this.grades = grades;
    }

    public Exam(String name, LocalDateTime dateTime, int durationMinutes, int maxScore, Course course, Map<Student, Double> grades) {
        this.ID = AutoIdGenerator.generateAutoId(name);
        this.setName(name);
        this.setDateTime(dateTime);
        this.setDurationMinutes(durationMinutes);
        this.setMaxScore(maxScore);
        this.setCourse(course);
        this.setGrades(grades);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exam exam = (Exam) o;
        return durationMinutes == exam.durationMinutes && maxScore == exam.maxScore && Objects.equals(ID, exam.ID) && Objects.equals(name, exam.name) && Objects.equals(dateTime, exam.dateTime) && Objects.equals(course, exam.course) && Objects.equals(grades, exam.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, dateTime, durationMinutes, maxScore, course, grades);
    }

    @Override
    public String toString() {
        return "Exam{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", dateTime=" + dateTime +
                ", durationMinutes=" + durationMinutes +
                ", maxScore=" + maxScore +
                ", course=" + course +
                ", grades=" + grades +
                '}';
    }
}


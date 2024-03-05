package org.miniproject.model;

import org.miniproject.emun.EnrollmentStatus;
import org.miniproject.emun.UserType;
import org.miniproject.exception.NegativeNumberException;
import org.miniproject.exception.StudentUserViolationException;
import org.miniproject.exception.TeacherUserViolationException;
import org.miniproject.util.AutoIdGenerator;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Enrollment {
    protected final String Enrollment_Name = "ENR";
    protected final String StudentUser_Violation_Exception_Message = "The user you are trying to add is not a user with type 'Student'. Please verify and try again.";
    protected final String NegativeNumber_Violation_Exception_Message = "The Number that you are trying to use is not a positive number. Please verify and try again.";
    protected String ID;
    protected Student student;
    protected Teacher teacher;
    protected LocalDate enrollmentDate;
    protected EnrollmentStatus status;
    protected Exam enrolledExam;

    public String getEnrollment_Name() {
        return Enrollment_Name;
    }

    public String getID() {
        return ID;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(Student student) throws StudentUserViolationException {
        this.student = student;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public EnrollmentStatus getStatus() {
        return status;
    }

    public void setStatus(EnrollmentStatus status) {
        this.status = status;
    }

    public List<Exam> getEnrolledExams() {
        return enrolledExams;
    }

    public void setEnrolledExams(List<Exam> enrolledExams) {
        this.enrolledExams = enrolledExams;
    }

    public Map<Exam, Double> getGrades() {
        return grades;
    }

    public void setGrades(Map<Exam, Double> grades) {
        this.grades = grades;
    }

    public Enrollment(String ID, Student student, LocalDate enrollmentDate, EnrollmentStatus status, List<Exam> enrolledExams, Map<Exam, Double> grades) throws StudentUserViolationException, NegativeNumberException {
        this.ID = AutoIdGenerator.generateAutoId(Enrollment_Name);
        this.setStudent(student);
        this.setEnrollmentDate(enrollmentDate);
        this.setStatus(status);
        this.setEnrolledExams(enrolledExams);
        this.setGrades(grades);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return Objects.equals(Enrollment_Name, that.Enrollment_Name) && Objects.equals(StudentUser_Violation_Exception_Message, that.StudentUser_Violation_Exception_Message) && Objects.equals(NegativeNumber_Violation_Exception_Message, that.NegativeNumber_Violation_Exception_Message) && Objects.equals(ID, that.ID) && Objects.equals(student, that.student) && Objects.equals(enrollmentDate, that.enrollmentDate) && status == that.status && Objects.equals(enrolledExams, that.enrolledExams) && Objects.equals(grades, that.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Enrollment_Name, StudentUser_Violation_Exception_Message, NegativeNumber_Violation_Exception_Message, ID, student, enrollmentDate, status, enrolledExams, grades);
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "Enrollment_Name='" + Enrollment_Name + '\'' +

                ", ID='" + ID + '\'' +
                ", student=" + student +
                ", enrollmentDate=" + enrollmentDate +
                ", status=" + status +
                ", enrolledExams count=" + enrolledExams.size() +
                ", grades count=" + grades.size() +
                '}';
    }
}

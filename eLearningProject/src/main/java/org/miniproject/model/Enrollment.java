package org.miniproject.model;

import org.miniproject.emun.EnrollmentStatus;
import org.miniproject.emun.UserType;
import org.miniproject.exception.NegativeNumberException;
import org.miniproject.exception.StudentUserViolationException;
import org.miniproject.exception.TeacherUserViolationException;
import org.miniproject.util.AutoIdGenerator;

import java.time.LocalDate;

public class Enrollment {
    protected final String Enrollment_Name = "ENR";
    protected final String StudentUser_Violation_Exception_Message = "The user you are trying to add is not a user with type 'Student'. Please verify and try again.";
    protected final String NegativeNumber_Violation_Exception_Message = "The Number that you are trying to use is not a positive number. Please verify and try again.";
    protected String ID;

    protected User student;
    protected LocalDate enrollmentDate;
    protected EnrollmentStatus status;
    protected Exam exam;
    protected int score;

    public String getEnrollment_Name() {
        return Enrollment_Name;
    }

    public String getID() {
        return ID;
    }

    public User getStudent() {
        return student;
    }

    public void setStudent(User student) throws StudentUserViolationException {
        if(student.getUserType() == UserType.STUDENT){
            this.student = student;
        }else{
            throw new StudentUserViolationException(StudentUser_Violation_Exception_Message);
        }
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

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) throws NegativeNumberException {
        if(score >= 0){
            this.score = score;
        }else{
            throw new NegativeNumberException(NegativeNumber_Violation_Exception_Message);
        }
    }

    public Enrollment(String ID, User student, LocalDate enrollmentDate, EnrollmentStatus status, Exam exam, int score) throws StudentUserViolationException, NegativeNumberException {
        this.ID = AutoIdGenerator.generateAutoId(Enrollment_Name);
        this.setStudent(student);
        this.setEnrollmentDate(enrollmentDate);
        this.setStatus(status);
        this.setExam(exam);
        this.setScore(score);
    }
}

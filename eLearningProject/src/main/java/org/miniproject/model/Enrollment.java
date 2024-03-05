package org.miniproject.model;

import org.miniproject.emun.EnrollmentStatus;
import org.miniproject.exception.GradeOutOfRangeException;
import org.miniproject.exception.StudentUserViolationException;
import org.miniproject.util.AutoIdGenerator;

import java.time.LocalDate;
import java.util.Objects;

public class Enrollment {
    protected final String Enrollment_Name = "ENR";
    protected final String StudentUser_Violation_Exception_Message = "The user you are trying to add is not a user with type 'Student'. Please verify and try again.";
    protected final String NegativeNumber_Violation_Exception_Message = "The Number that you are trying to use is not a positive number. Please verify and try again.";
    protected final String GradeOutOfRange_Violation_Exception_Message = "The Grade that you are trying to use is out of range. Please verify that the grade is between 0 and 20 and try again.";
    protected String ID;
    protected Student student;
    protected Teacher teacher;
    protected LocalDate enrollmentDate;
    protected EnrollmentStatus status;
    protected double grade;

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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) throws GradeOutOfRangeException {
        if(grade >= 0 && grade <= 20){
            this.grade = grade;
        }
        else{
            throw new GradeOutOfRangeException(GradeOutOfRange_Violation_Exception_Message);
        }
    }

    public Enrollment(Student student, Teacher teacher, LocalDate enrollmentDate, EnrollmentStatus status, double grade) throws StudentUserViolationException, GradeOutOfRangeException {
        this.ID = AutoIdGenerator.generateAutoId(Enrollment_Name);
        this.setStudent(student);
        this.setTeacher(teacher);
        this.setEnrollmentDate(enrollmentDate);
        this.setStatus(status);
        this.setGrade(grade);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return Double.compare(grade, that.grade) == 0 && Objects.equals(Enrollment_Name, that.Enrollment_Name) && Objects.equals(StudentUser_Violation_Exception_Message, that.StudentUser_Violation_Exception_Message) && Objects.equals(NegativeNumber_Violation_Exception_Message, that.NegativeNumber_Violation_Exception_Message) && Objects.equals(GradeOutOfRange_Violation_Exception_Message, that.GradeOutOfRange_Violation_Exception_Message) && Objects.equals(ID, that.ID) && Objects.equals(student, that.student) && Objects.equals(teacher, that.teacher) && Objects.equals(enrollmentDate, that.enrollmentDate) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(Enrollment_Name, StudentUser_Violation_Exception_Message, NegativeNumber_Violation_Exception_Message, GradeOutOfRange_Violation_Exception_Message, ID, student, teacher, enrollmentDate, status, grade);
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "Enrollment_Name='" + Enrollment_Name + '\'' +
                ", StudentUser_Violation_Exception_Message='" + StudentUser_Violation_Exception_Message + '\'' +
                ", NegativeNumber_Violation_Exception_Message='" + NegativeNumber_Violation_Exception_Message + '\'' +
                ", GradeOutOfRange_Violation_Exception_Message='" + GradeOutOfRange_Violation_Exception_Message + '\'' +
                ", ID='" + ID + '\'' +
                ", student=" + student +
                ", teacher=" + teacher +
                ", enrollmentDate=" + enrollmentDate +
                ", status=" + status +
                ", grade=" + grade +
                '}';
    }
}

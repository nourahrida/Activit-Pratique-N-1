package org.miniproject.model;

import org.miniproject.exception.EmailValidationException;
import org.miniproject.exception.PhoneNumberValidationException;
import org.miniproject.model.submodel.UserAddress;
import org.miniproject.model.submodel.UserPhoneNumber;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Student extends User{
    protected List<Enrollment> enrolledCourses;

    public List<Enrollment> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void setEnrolledCourses(List<Enrollment> enrolledCourses) {
        this.enrolledCourses = enrolledCourses;
    }

    public Student(String fname, String lname, String email, LocalDate birthdate, UserAddress address, UserPhoneNumber phoneNumber, List<Enrollment> enrolledCourses) throws EmailValidationException, PhoneNumberValidationException {
        super(fname, lname, email, birthdate, address, phoneNumber);
        this.enrolledCourses = enrolledCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(enrolledCourses, student.enrolledCourses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), enrolledCourses);
    }

    @Override
    public String toString() {
        return "Student{" +
                "enrolledCourses=" + enrolledCourses +
                ", ID='" + ID + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", age=" + age +
                ", address=" + address +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}

package org.miniproject.model;

import org.miniproject.emun.UserType;
import org.miniproject.exception.EmailValidationException;
import org.miniproject.exception.PhoneNumberValidationException;

import java.time.LocalDate;
import java.util.Objects;

public class Teacher extends User{
    protected Course courseTeaching;

    public Course getCourseTeaching() {
        return courseTeaching;
    }

    public void setCourseTeaching(Course courseTeaching) {
        this.courseTeaching = courseTeaching;
    }

    public Teacher(String fname, String lname, String email, LocalDate birthdate, UserAddress address, UserPhoneNumber phoneNumber, UserType userType, Course courseTeaching) throws EmailValidationException, PhoneNumberValidationException {
        super(fname, lname, email, birthdate, address, phoneNumber, userType);
        this.courseTeaching = courseTeaching;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(courseTeaching, teacher.courseTeaching);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), courseTeaching);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "courseTeaching=" + courseTeaching +
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

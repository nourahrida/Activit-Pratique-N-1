package org.miniproject.model;

import org.miniproject.exception.EmailValidationException;
import org.miniproject.exception.PhoneNumberValidationException;
import org.miniproject.model.submodel.UserAddress;
import org.miniproject.model.submodel.UserPhoneNumber;
import org.miniproject.util.AgeCalculator;
import org.miniproject.util.AutoIdGenerator;
import org.miniproject.util.EmailValidator;
import org.miniproject.util.PhoneNumberValidator;

import java.time.LocalDate;
import java.util.Objects;

public class User {
    protected final String Email_Validation_Exception_Message = "The email that has been entered is not valid, Please verify it!";
    protected final String PhoneNumber_Validation_Exception_Message = "The phone number that has been entered is not valid, Please verify it!";

    protected String ID;
    protected String fname;
    protected String lname;
    protected String email;
    protected LocalDate birthdate;
    protected int age;
    protected UserAddress address;
    protected UserPhoneNumber phoneNumber;

    public String getID() {
        return ID;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws EmailValidationException {
        if(EmailValidator.isValidEmail(email)){
            this.email = email;
        }else{
            throw new EmailValidationException(Email_Validation_Exception_Message);
        }
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        // calculting the age
        this.age = AgeCalculator.calculateAge(this.getBirthdate());
    }

    public int getAge() {
        return age;
    }

    public UserAddress getAddress() {
        return address;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }

    public UserPhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(UserPhoneNumber phoneNumber) throws PhoneNumberValidationException {
        if(PhoneNumberValidator.isValidPhoneNumber(phoneNumber)){
            this.phoneNumber = phoneNumber;
        }else{
            throw new PhoneNumberValidationException(PhoneNumber_Validation_Exception_Message);
        }
    }


    public User(String fname, String lname, String email, LocalDate birthdate, UserAddress address, UserPhoneNumber phoneNumber) throws EmailValidationException, PhoneNumberValidationException {
        this.ID = AutoIdGenerator.generateAutoId(fname, lname);
        this.setFname(fname);
        this.setLname(lname);
        this.setEmail(email);
        this.setBirthdate(birthdate);
        this.setAddress(address);
        this.setPhoneNumber(phoneNumber);
    }
    public User(){
        // default constructor

    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", email='" + email + '\'' +
                ", birthdate=" + birthdate +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return ID.equals(user.ID) && age == user.age && Objects.equals(fname, user.fname) && Objects.equals(lname, user.lname) && Objects.equals(email, user.email) && Objects.equals(birthdate, user.birthdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, fname, lname, email, birthdate, age);
    }
}

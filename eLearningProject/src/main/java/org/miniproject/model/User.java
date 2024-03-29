package org.miniproject.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.miniproject.exception.EmailValidationException;
import org.miniproject.exception.PhoneNumberValidationException;
import org.miniproject.model.submodel.UserAddress;
import org.miniproject.model.submodel.UserPhoneNumber;
import org.miniproject.util.AgeCalculator;
import org.miniproject.util.AutoIdGenerator;
import org.miniproject.util.EmailValidator;
import org.miniproject.util.PhoneNumberValidator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    // Constants
    protected final String Email_Validation_Exception_Message = "The email that has been entered is not valid, Please verify it!";
    protected final String PhoneNumber_Validation_Exception_Message = "The phone number that has been entered is not valid, Please verify it!";
    @Getter
    @Column
    @Id
    protected String ID;
    @Column()
    @Getter
    @Setter
    protected String fname;
    @Column()
    @Getter
    @Setter
    protected String lname;
    @Column()
    @Getter
    protected String email;
    @Column()
    @Getter
    protected LocalDate birthdate;
    @Column()
    @Getter
    protected int age;
    @Column
    @Getter
    @Setter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userAddress")
    protected UserAddress address;
    @Column
    @Getter
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userPhoneNumber")
    protected UserPhoneNumber phoneNumber;

    public void setEmail(String email) throws EmailValidationException {
        if(EmailValidator.isValidEmail(email)){
            this.email = email;
        }else{
            throw new EmailValidationException(Email_Validation_Exception_Message);
        }
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
        // calculting the age
        this.age = AgeCalculator.calculateAge(this.getBirthdate());
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
}
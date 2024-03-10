package org.miniproject.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.miniproject.exception.EmailValidationException;
import org.miniproject.exception.PhoneNumberValidationException;
import org.miniproject.model.submodel.UserAddress;
import org.miniproject.model.submodel.UserPhoneNumber;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Objects;
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@NoArgsConstructor
@Data
public class Teacher extends User{

    @ManyToOne
    @JoinColumn(name = "course_id")
    protected Course courseTeaching;

    public Teacher(String fname, String lname, String email, LocalDate birthdate, UserAddress address, UserPhoneNumber phoneNumber, Course courseTeaching) throws EmailValidationException, PhoneNumberValidationException {
        super(fname, lname, email, birthdate, address, phoneNumber);
        this.courseTeaching = courseTeaching;
    }

}

package org.miniproject.model;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.miniproject.exception.EmailValidationException;
import org.miniproject.exception.PhoneNumberValidationException;
import org.miniproject.model.submodel.UserAddress;
import org.miniproject.model.submodel.UserPhoneNumber;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@NoArgsConstructor
@SuperBuilder
@Data
public class Student extends User{
    // this is a subClass of User
    @Column
    @OneToMany(mappedBy = "student")
    private Set<Enrollment> enrollments = new HashSet<>();

}

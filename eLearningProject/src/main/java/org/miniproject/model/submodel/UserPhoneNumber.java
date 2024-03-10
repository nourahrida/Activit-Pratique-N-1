package org.miniproject.model.submodel;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class UserPhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String number;
    @Column
    private String countryCode;

    // Constructor
    public UserPhoneNumber(String number, String countryCode) {
        this.number = number;
        this.countryCode = countryCode;
    }
}

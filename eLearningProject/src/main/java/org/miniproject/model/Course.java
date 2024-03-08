package org.miniproject.model;

import lombok.*;
import org.miniproject.util.AutoIdGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;
@Entity
@NoArgsConstructor()
@EqualsAndHashCode
@ToString
public class Course {
    // Constant
    protected final String TeacherUser_Violation_Exception_Message = "The user you are trying to add is not a user with type 'Teacher'. Please verify and try again.";
    @Getter
    @Id
    protected String ID;
    @Column()
    @Getter
    @Setter
    protected String name;
    @Column()
    @Getter
    @Setter
    protected LocalDate startDate;
    @Column()
    @Getter
    protected LocalDate endDate;
    @Column()
    @Getter
    @Setter
    protected int durationInWeeks;
    @Column()
    @Getter
    @Setter
    protected String description;

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        // Calculating the week count between the start date and the end date
        Period period = Period.between(startDate, endDate);
        this.durationInWeeks = (int) (period.toTotalMonths() * 4 + period.getDays() / 7);
    }


    public Course(String name, LocalDate startDate, LocalDate endDate, int durationInWeeks, String description) {
        this.ID = AutoIdGenerator.generateAutoId(name);
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.durationInWeeks = durationInWeeks;
        this.description = description;
    }

}

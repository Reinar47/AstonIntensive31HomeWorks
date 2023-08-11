package org.example.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student extends Person {

    @Column(name = "is_student")
    boolean isStudent;

    @ManyToMany(mappedBy = "students")
    @Builder.Default
    Set<Course> courses = new HashSet<>();

    @Override
    public String toString() {
        return String.format("Student : %s %s \n",
                getLastName(),
                getFirstName());
    }

}

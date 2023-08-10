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
@Table(name = "teacher")
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Teacher extends Person {

    @Column(name = "is_teacher")
    boolean isTeacher;

    @ManyToMany(mappedBy = "teachers")
    @Builder.Default
    Set<Course> courses = new HashSet<>();

    @Override
    public String toString() {
        return String.format("Teacher : %s %s \n",
                getLastName(),
                getFirstName());
    }


}



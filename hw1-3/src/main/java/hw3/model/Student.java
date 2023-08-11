package hw3.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@SuperBuilder
@Table(name = "student")
public class Student extends Person {

    @Column(name = "is_student")
    private boolean isStudent;

    @ManyToMany(mappedBy = "students")
    @Builder.Default
    private Set<Course> courses = new HashSet<>();

    @Override
    public String toString() {
        return String.format("Student : %s %s \n",
                getLastName(),
                getFirstName());
    }

}

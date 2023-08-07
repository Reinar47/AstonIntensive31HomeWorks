package hw3.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@SuperBuilder
@Table(name = "teacher")
public class Teacher extends Person{

    @Column(name = "is_teacher")
    private boolean isTeacher;

    @ManyToMany(mappedBy = "teachers")
    @Builder.Default
    private Set<Course> courses = new HashSet<>();

    @Override
    public String toString() {
        return String.format("Teacher : %s %s \n",
                getLastName(),
                getFirstName());
    }

}


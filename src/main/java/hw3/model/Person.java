package hw3.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;

//    @ManyToMany(mappedBy = "students")
//    @Builder.Default
//    private Set<Teacher> teachers = new HashSet<>();


//    @ManyToMany(cascade = {CascadeType.ALL})
//    @JoinTable(
//        name = "teacher_student",
//        joinColumns = @JoinColumn(name = "teachers_id"),
//        inverseJoinColumns = @JoinColumn(name = "students_id"))
//    @Builder.Default
//   private Set<Student> students = new HashSet<>();


}

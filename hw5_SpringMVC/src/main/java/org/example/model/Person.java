package com.example.rest.temp.hw5_SpringMVC.src.main.java.org.example.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@SuperBuilder
@NoArgsConstructor
@Table(name = "person")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    long id;
    @Column(name = "first_name", nullable = false)
    String firstName;
    @Column(name = "last_name", nullable = false)
    String lastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;
        return getId() == person.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

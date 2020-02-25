package pl.sixfaces.relationship_db.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Profesor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_prof;
    private String name;
    private String surname;
    //@ManyToMany  //bykowski
    @ManyToMany
    @JoinTable(
            name = "id_student_id_prof",
            joinColumns = @JoinColumn(name = "id_prof"),
            inverseJoinColumns = @JoinColumn(name = "id_student")

    )
    private List<Student> studentList;


    public Profesor(String name, String surname) {
        this.name = name;
        this.surname = surname;

    }

    public void add(Student student) {
        if (studentList == null) {
            studentList = new ArrayList<>();
        }
        studentList.add(student);
    }

}

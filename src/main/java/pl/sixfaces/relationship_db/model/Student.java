package pl.sixfaces.relationship_db.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_student;
    private String name;
    private String surname;
    private String groupNumber;

  /* @JoinTable(
            name = "id_student_id_prof",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_prof")

    )*/

    @ManyToMany
    private List<Profesor> profesorList;


     @OneToOne(  cascade = CascadeType.REMOVE, orphanRemoval = true)
     @JoinColumn(name = "back_pack_id")
     private  Backpack backpack;


    public Student(String name, String surname, String groupNumber) {
        this.name = name;
        this.surname = surname;
        this.groupNumber = groupNumber;
    }

    public void add(Profesor profesor) {
        if (profesorList == null) {
            profesorList = new ArrayList<>();
        }
        profesorList.add(profesor);
    }







}

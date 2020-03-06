package pl.sixfaces.relationship_db.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//złe
/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_student")*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student     {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_student;
    private String name;
    private String surname;
    private String groupNumber;
// udemy old banding
  /* @JoinTable(
            name = "id_student_id_prof",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_prof")

    )*/
    @JsonIgnore
    @ManyToMany
    private List<Profesor> profesorList;

/*    // 2 - way
     @OneToOne(  cascade = CascadeType.REMOVE, orphanRemoval = true)
     @JoinColumn(name = "back_pack_id")*/

     // 1- way
     @JsonIgnore
     @OneToOne(cascade = CascadeType.REMOVE,orphanRemoval = true)
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

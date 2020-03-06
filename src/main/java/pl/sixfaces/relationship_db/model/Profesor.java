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

/*@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_prof")*/
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
    
    // old udemy version
   // @ManyToMany(fetch = FetchType.EAGER)
     /*   @JoinTable(
            name = "id_student_id_prof",
            joinColumns = @JoinColumn(name = "id_prof"),
            inverseJoinColumns = @JoinColumn(name = "id_student")

    )*/
    @JsonIgnore
    @ManyToMany (mappedBy = "profesorList")
    private List<Student> studentList;

  // old udemy version
  /*  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "room_id")*/

    @JsonIgnore
    @OneToOne(cascade = CascadeType.REMOVE)
    private  Room roomID;



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

    public Long getId_prof() {
        return id_prof;
    }

    public void setId_prof(Long id_prof) {
        this.id_prof = id_prof;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Room getRoomID() {
        return roomID;
    }

    public void setRoomID(Room room) {
        this.roomID = room;
    }
}

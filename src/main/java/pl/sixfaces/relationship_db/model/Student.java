package pl.sixfaces.relationship_db.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// cała relacja wszystkie połączenia
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id_student")
@Data
@NoArgsConstructor
@AllArgsConstructor
//create time and update
@EntityListeners(AuditingEntityListener.class)
@Entity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_student;
    private String name;
    private String surname;
    private String groupNumber;
    @Column(updatable = false, nullable = false)
    @CreatedDate
    private LocalDateTime createdTime;

    @Column(nullable = false)
    @LastModifiedDate
    private LocalDateTime updatedTime;


    // udemy old banding
  /* @JoinTable(
            name = "id_student_id_prof",
            joinColumns = @JoinColumn(name = "id_student"),
            inverseJoinColumns = @JoinColumn(name = "id_prof")

    )*/
    //blokowanie relacji w głąb
    // @JsonIgnore
    @ManyToMany
    private List<Professor> professorList;

/*    // 2 - way
     @OneToOne(  cascade = CascadeType.REMOVE, orphanRemoval = true)
     @JoinColumn(name = "back_pack_id")*/

    // 1- way
    // @JsonIgnore
    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Backpack backpack;


    public Student(String name, String surname, String groupNumber) {
        this.name = name;
        this.surname = surname;
        this.groupNumber = groupNumber;
    }

    public void add(Professor professor) {
        if (professorList == null) {
            professorList = new ArrayList<>();
        }
        professorList.add(professor);
    }


}

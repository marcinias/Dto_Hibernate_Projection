package pl.sixfaces.relationship_db.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sixfaces.relationship_db.model.dto.NoteDto;

@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "id")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
class Note {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String title;
  //  2-WAY
  // @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "backpack_id")
  private Backpack backpackId;

  public Note(String title) {
    this.title = title;
  }



  NoteDto toDto(){

   return  NoteDto.create(id,title);

  }


}

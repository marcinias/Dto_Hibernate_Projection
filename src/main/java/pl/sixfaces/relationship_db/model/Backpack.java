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
public class Backpack {


   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mark;
   // unidirectional   1-way
     /* @OneToMany(cascade = CascadeType.ALL)
      @JoinColumn(name = "back_pack_id")*/

   //  bidirectional  2-way
   @OneToMany(mappedBy =  "backpackId",cascade = CascadeType.REMOVE)
    private List<Note> noteList;


    public Backpack(String mark) {
        this.mark = mark;
    }

   //  unidirectional   1-way  method

  public void add(Note note) {
        if (noteList == null) {
            noteList = new ArrayList<>();
        }
        noteList.add(note);
    }

}

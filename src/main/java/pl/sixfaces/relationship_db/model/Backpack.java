package pl.sixfaces.relationship_db.model;

import static java.util.stream.Collectors.toList;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import pl.sixfaces.relationship_db.model.dto.BackpackDto;

@Entity
 class Backpack {


  @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mark;
    // unidirectional   1-way
     /* @OneToMany(cascade = CascadeType.ALL)
      @JoinColumn(name = "back_pack_id")*/

    //  bidirectional  2-way
    @OneToMany(mappedBy = "backpackId", cascade = CascadeType.REMOVE)
    private List<Note> noteList;


    public Backpack(String mark) {
        this.mark = mark;
    }

  public Backpack() {
  }

  //  unidirectional   1-way  method

    public void add(Note note) {
        if (noteList == null) {
            noteList = new ArrayList<>();
        }
        noteList.add(note);
    }



  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getMark() {
    return mark;
  }

  public void setMark(String mark) {
    this.mark = mark;
  }

  public List<Note> getNoteList() {
    return noteList;
  }





}

package pl.sixfaces.relationship_db.model.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.List;

@JsonDeserialize(as = BackpackDto.Deserialize.class)
public interface BackpackDto {


  static BackpackDto create(Long id, String mark, List<NoteDto> noteDtoList) {

    return new Deserialize(id, mark, noteDtoList);

  }

  Long getId();

  String getMark();

  List<NoteDto> getNoteList();


  static class Deserialize implements BackpackDto {

    private Long id;
    private String mark;
    private List<NoteDto> noteList;

    public Deserialize(Long id, String mark, List<NoteDto> noteList) {
      this.id = id;
      this.mark = mark;
      this.noteList = noteList;
    }

    @Override
    public Long getId() {
      return id;
    }

    @Override
    public String getMark() {
      return mark;
    }

    @Override
    public List<NoteDto> getNoteList() {
      return noteList;
    }
  }
}

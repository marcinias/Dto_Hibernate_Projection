package pl.sixfaces.relationship_db.model.dto;



import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


@JsonDeserialize(as = NoteDto.Deserialized.class)
public interface NoteDto {


  static NoteDto create(Long id, String title) {
    return new Deserialized(id, title);

  }

  Long getId();

  String getTitle();


  static class Deserialized implements NoteDto {

    private Long id;
    private String title;


    public Deserialized(Long id, String title) {
      this.id = id;
      this.title = title;


    }

    @Override
    public Long getId() {
      return id;
    }

    @Override
    public String getTitle() {
      return title;
    }


  }


}

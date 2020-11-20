package pl.sixfaces.relationship_db.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import pl.sixfaces.relationship_db.model.dto.BackpackDto;
import pl.sixfaces.relationship_db.model.dto.NoteDto;

public interface QueryRepository extends JpaRepository<Note, Long> {




    List<NoteDto> findBy();






}

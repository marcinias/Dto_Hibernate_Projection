package pl.sixfaces.relationship_db.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sixfaces.relationship_db.model.Note;

@Repository
 public interface NoteRepo extends JpaRepository<Note, Long> {
}

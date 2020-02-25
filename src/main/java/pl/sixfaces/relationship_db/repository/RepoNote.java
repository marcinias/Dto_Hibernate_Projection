package pl.sixfaces.relationship_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sixfaces.relationship_db.model.Note;

public interface RepoNote extends JpaRepository<Note,Long> {
}

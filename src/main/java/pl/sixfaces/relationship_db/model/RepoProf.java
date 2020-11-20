package pl.sixfaces.relationship_db.model;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sixfaces.relationship_db.model.Professor;

public interface RepoProf extends JpaRepository<Professor, Long> {
}

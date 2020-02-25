package pl.sixfaces.relationship_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sixfaces.relationship_db.model.Profesor;
import pl.sixfaces.relationship_db.model.Student;

public interface RepoProf extends JpaRepository<Profesor,Long> {
}

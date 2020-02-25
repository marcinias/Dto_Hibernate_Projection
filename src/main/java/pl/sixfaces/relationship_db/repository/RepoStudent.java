package pl.sixfaces.relationship_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sixfaces.relationship_db.model.Student;

public interface RepoStudent extends JpaRepository<Student,Long> {
}

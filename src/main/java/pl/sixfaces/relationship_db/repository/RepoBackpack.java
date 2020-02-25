package pl.sixfaces.relationship_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sixfaces.relationship_db.model.Backpack;

public interface RepoBackpack extends JpaRepository<Backpack,Long> {
}

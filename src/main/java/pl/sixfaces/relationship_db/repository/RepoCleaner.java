package pl.sixfaces.relationship_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sixfaces.relationship_db.model.Backpack;
import pl.sixfaces.relationship_db.model.Cleaner;

public interface RepoCleaner extends JpaRepository<Cleaner,Long> {
}

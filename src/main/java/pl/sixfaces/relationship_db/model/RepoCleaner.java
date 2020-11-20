
package pl.sixfaces.relationship_db.model;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sixfaces.relationship_db.model.Cleaner;

public interface RepoCleaner extends JpaRepository<Cleaner, Long> {
}

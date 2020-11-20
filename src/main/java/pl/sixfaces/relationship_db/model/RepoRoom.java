package pl.sixfaces.relationship_db.model;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sixfaces.relationship_db.model.Backpack;
import pl.sixfaces.relationship_db.model.Room;

public interface RepoRoom extends JpaRepository<Room, Long> {
}

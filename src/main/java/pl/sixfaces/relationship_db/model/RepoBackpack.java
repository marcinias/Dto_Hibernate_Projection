
package pl.sixfaces.relationship_db.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sixfaces.relationship_db.model.Backpack;

import java.util.List;

@Repository
public interface RepoBackpack extends JpaRepository<Backpack, Long> {

    List<Backpack> deleteByMarkIs(String mark);
}


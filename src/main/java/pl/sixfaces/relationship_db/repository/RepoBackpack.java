package pl.sixfaces.relationship_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sixfaces.relationship_db.model.Backpack;

import java.util.List;

public interface RepoBackpack extends JpaRepository<Backpack,Long> {

   List<Backpack> deleteByMarkIs(String mark);
}

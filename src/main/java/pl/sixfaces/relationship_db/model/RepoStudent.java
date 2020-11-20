package pl.sixfaces.relationship_db.model;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sixfaces.relationship_db.model.Student;

import java.util.List;

public interface RepoStudent extends JpaRepository<Student, Long> {

    List<Student> findStudentBySurnameIs(String surName);
    // List<Student> findStudentBySurnames(String surName);


}

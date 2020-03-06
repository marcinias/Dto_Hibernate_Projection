package pl.sixfaces.relationship_db.service;

import pl.sixfaces.relationship_db.model.Note;
import pl.sixfaces.relationship_db.model.Profesor;
import pl.sixfaces.relationship_db.model.Student;

import java.util.List;

public interface ServiceImp {

   List <Student> getAllStudent();
    Student deleteStudentID(Long id);
    Profesor getProfessorID(Long id);
    Student saveStudent(Student student);
    List<Note> getAllNote();

}

package pl.sixfaces.relationship_db.model;

import java.util.List;
import pl.sixfaces.relationship_db.model.dto.NoteDto;

public interface ServiceImp {

    List<Student> getAllStudent();

    Student deleteStudentID(Long id);

    Professor getProfessorID(Long id);

    Student saveStudent(Student student);

    List<NoteDto> getAllNote();

}

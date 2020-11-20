package pl.sixfaces.relationship_db.controller;


import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sixfaces.relationship_db.model.NoteRepo;
import pl.sixfaces.relationship_db.model.Professor;
import pl.sixfaces.relationship_db.model.QueryRepository;
import pl.sixfaces.relationship_db.model.Student;
import pl.sixfaces.relationship_db.model.dto.BackpackDto;
import pl.sixfaces.relationship_db.model.dto.NoteDto;
import pl.sixfaces.relationship_db.model.ServiceImp;


@RestController
@RequestMapping("/api")
public class ControllerDb {

   private ServiceImp serviceImp;
   private QueryRepository queryRepository;
   private NoteRepo noteRepo;


    public ControllerDb(ServiceImp serviceImp,
        QueryRepository queryRepository, NoteRepo noteRepo) {
        this.serviceImp = serviceImp;
        this.queryRepository = queryRepository;
        this.noteRepo = noteRepo;
    }

    @GetMapping("/note")
    public List<NoteDto> getAllNote() {
        return  serviceImp.getAllNote();

    }

    @GetMapping("/student")
    public List<Student> getAllStudent() {
        return serviceImp.getAllStudent();
    }


    @DeleteMapping("del/student/{id}")
    public Student deleteStudentId(@PathVariable Long id) {

        Student student = serviceImp.deleteStudentID(id);
        return student;

    }

    @GetMapping("prof/{id}")

    public Professor getProfessorID(@PathVariable Long id) {

        return serviceImp.getProfessorID(id);
    }


}

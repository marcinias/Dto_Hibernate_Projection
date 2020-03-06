package pl.sixfaces.relationship_db.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sixfaces.relationship_db.model.Note;
import pl.sixfaces.relationship_db.model.Profesor;
import pl.sixfaces.relationship_db.model.Student;
import pl.sixfaces.relationship_db.service.ServiceImp;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ControllerDb {

    ServiceImp serviceImp;

    @Autowired
    public ControllerDb(ServiceImp serviceImp) {
        this.serviceImp = serviceImp;
    }


    @GetMapping
    public List<Note> getAllNote() {
        return serviceImp.getAllNote();

    }

    @DeleteMapping("del/student/{id}")
    public Student deleteStudentId(@PathVariable Long id) {

        Student student = serviceImp.deleteStudentID(id);
        return student;

    }

    @GetMapping("prof/{id}")

    public Profesor getProfesorID(@PathVariable Long id) {

        return serviceImp.getProfessorID(id);
    }


}

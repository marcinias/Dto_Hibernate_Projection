package pl.sixfaces.relationship_db.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sixfaces.relationship_db.model.Note;
import pl.sixfaces.relationship_db.model.Profesor;
import pl.sixfaces.relationship_db.model.Student;
import pl.sixfaces.relationship_db.repository.RepoNote;
import pl.sixfaces.relationship_db.repository.RepoProf;
import pl.sixfaces.relationship_db.repository.RepoStudent;


import java.util.ArrayList;
import java.util.List;


@Service("serviceImp")
public class ServiceDb implements ServiceImp {


    RepoNote repoNote;
    RepoStudent repoStudent;
    RepoProf repoProf;

    @Autowired
    public ServiceDb(RepoNote repoNote, RepoStudent repoStudent, RepoProf repoProf) {
        this.repoNote = repoNote;
        this.repoStudent = repoStudent;
        this.repoProf = repoProf;
    }

    @Override
    public List<Note> getAllNote() {

        return repoNote.findAll();

    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> studentsList = new ArrayList<>();
        List<Student> repoStudentAll = repoStudent.findAll();
        repoStudentAll.forEach(student -> {
            studentsList.add(student);

        });

        return studentsList;
    }

    @Override
    public Student deleteStudentID(Long id) {
        Student student = repoStudent.findById(id).get();
        repoStudent.deleteById(id);

        return student;
    }

    @Override
    public Profesor getProfessorID(Long id) {
        Profesor profesor = repoProf.findById(id).get();
        return profesor;
    }

    @Override
    public Student saveStudent(Student student) {
        return repoStudent.save(student);

    }


}

package pl.sixfaces.relationship_db.model;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import pl.sixfaces.relationship_db.model.dto.NoteDto;


@Service("serviceImp")
 public class FacadeServiceDb implements ServiceImp {


   private QueryRepository queryRepository;
   private RepoStudent repoStudent;
   private RepoProf repoProf;
   private NoteRepo noteRepo;

    public FacadeServiceDb(QueryRepository queryRepository,
        RepoStudent repoStudent, RepoProf repoProf, NoteRepo noteRepo) {
        this.queryRepository = queryRepository;
        this.repoStudent = repoStudent;
        this.repoProf = repoProf;
        this.noteRepo = noteRepo;

    }

    @Override
    public List<NoteDto> getAllNote() {

     // return Arrays.asList(NoteDto.create(1L, "marcin"));

       return noteRepo.findAll().stream().map(Note::toDto).collect(toList());



    }

    @Override
    public List<Student> getAllStudent() {
        return repoStudent.findAll();

    }

    @Override
    public Student deleteStudentID(Long id) {
        Student student = repoStudent.findById(id).get();
        repoStudent.deleteById(id);

        return student;
    }

    @Override
    public Professor getProfessorID(Long id) {
        Professor professor = repoProf.findById(id).get();
        return professor;
    }

    @Override
    public Student saveStudent(Student student) {
        return repoStudent.save(student);

    }


}

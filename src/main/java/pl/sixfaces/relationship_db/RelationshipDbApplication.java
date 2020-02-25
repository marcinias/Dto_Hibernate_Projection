package pl.sixfaces.relationship_db;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sixfaces.relationship_db.model.Backpack;
import pl.sixfaces.relationship_db.model.Note;
import pl.sixfaces.relationship_db.model.Profesor;
import pl.sixfaces.relationship_db.model.Student;
import pl.sixfaces.relationship_db.repository.RepoBackpack;
import pl.sixfaces.relationship_db.repository.RepoNote;
import pl.sixfaces.relationship_db.repository.RepoProf;
import pl.sixfaces.relationship_db.repository.RepoStudent;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class RelationshipDbApplication implements CommandLineRunner {

    RepoStudent repoStudent;
    RepoBackpack repoBackpack;
    RepoNote repoNote;
    RepoProf repoProf;

    @Autowired
    public RelationshipDbApplication(RepoStudent repoStudent, RepoBackpack repoBackpack, RepoNote repoNote, RepoProf repoProf) {
        this.repoStudent = repoStudent;
        this.repoBackpack = repoBackpack;
        this.repoNote = repoNote;
        this.repoProf = repoProf;
    }

    public static void main(String[] args) {
        SpringApplication.run(RelationshipDbApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


        Backpack backpack01 = new Backpack("Nike");
        Backpack backpack02 = new Backpack("Adidas");
        Backpack backpack03 = new Backpack("4F");


        Note note1 = new Note("Zeszyt z religji");
        Note note2 = new Note("Zeszyt z informatyki ");
        Note note3 = new Note("Zeszyt z histori ");
        Note note4 = new Note("Zeszyt z polskiego  ");




        backpack01.add(note1);
        backpack02.add(note2);
        backpack03.add(note3);
        backpack03.add(note4);


        repoBackpack.save(backpack01);
        repoBackpack.save(backpack02);
        repoBackpack.save(backpack03);


        repoNote.save(note1);
        repoNote.save(note2);
        repoNote.save(note3);
        repoNote.save(note4);


        Student student01 = new Student("Karol", "Blebus", "67276");
        Student student02 = new Student("Szczepan", "Kondzior", "342576");
        student01.setBackpack(backpack01);
        student02.setBackpack(backpack02);



        Profesor profesor01 = new Profesor("prof", "nazwisko");
        Profesor profesor02 = new Profesor("prdvof", "dvnazwisko");
        Profesor profesor03 = new Profesor("prdvvnof", "dvnavnzwisko");





        student01.add(profesor01);
        student02.add(profesor03);
        student02.add(profesor01);
        student02.add(profesor02);


        repoProf.save(profesor01);
        repoProf.save(profesor02);
        repoProf.save(profesor03);


        repoStudent.save(student01);
        repoStudent.save(student02);


    }
}

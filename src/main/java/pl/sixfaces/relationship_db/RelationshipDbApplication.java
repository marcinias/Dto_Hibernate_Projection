package pl.sixfaces.relationship_db;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.sixfaces.relationship_db.model.*;
import pl.sixfaces.relationship_db.repository.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class RelationshipDbApplication implements CommandLineRunner {

    RepoStudent repoStudent;
    RepoBackpack repoBackpack;
    RepoNote repoNote;
    RepoProf repoProf;
    RepoRoom repoRoom;
    RepoCleaner repoCleaner;

    @Autowired
    public RelationshipDbApplication(RepoStudent repoStudent, RepoBackpack repoBackpack, RepoNote repoNote, RepoProf repoProf, RepoRoom repoRoom, RepoCleaner repoCleaner) {
        this.repoStudent = repoStudent;
        this.repoBackpack = repoBackpack;
        this.repoNote = repoNote;
        this.repoProf = repoProf;
        this.repoRoom = repoRoom;
        this.repoCleaner = repoCleaner;
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


        Room room01 = new Room(2312, "muzyka");
        Room room02 = new Room(1212, "IT");
        Room room03 = new Room(5212, "wos");

        Cleaner cleaner01 = new Cleaner("Jas", "Kowalski");
        Cleaner cleaner02 = new Cleaner("Karolina", "Lesniacka");

        student01.add(profesor01);
        student02.add(profesor03);
        student02.add(profesor01);
        student02.add(profesor02);


        repoRoom.save(room01);
        repoRoom.save(room02);
        repoRoom.save(room03);

        profesor01.setRoom(room01);
        profesor02.setRoom(room02);
        profesor03.setRoom(room02);

        repoProf.save(profesor01);
        repoProf.save(profesor02);
        repoProf.save(profesor03);


        repoStudent.save(student01);
        repoStudent.save(student02);

        cleaner01.add(room01);
        cleaner02.add(room02);
        cleaner02.add(room03);


        repoCleaner.save(cleaner01);
        repoCleaner.save(cleaner02);


    }
}

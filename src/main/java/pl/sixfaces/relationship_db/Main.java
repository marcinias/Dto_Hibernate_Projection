package pl.sixfaces.relationship_db;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sixfaces.relationship_db.model.*;
import pl.sixfaces.relationship_db.repository.*;

@Component
public class Main {


    @Autowired
    public Main(RepoStudent repoStudent, RepoBackpack repoBackpack, RepoNote repoNote, RepoProf repoProf, RepoRoom repoRoom, RepoCleaner repoCleaner) {


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




        repoRoom.save(room01);
        repoRoom.save(room02);
        repoRoom.save(room03);

        profesor01.setRoom(room01);
        profesor02.setRoom(room02);
        profesor03.setRoom(room02);






     student01.add(profesor01);
        student02.add(profesor03);
        student02.add(profesor01);
        student02.add(profesor02);

      /*  profesor01.add(student02);
        profesor01.add(student01);*/

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

        // repoStudent.deleteById(1L);

     /* System.out.println("buu-------------");
         List<Student> blebus = repoStudent.findStudentBySurnameIs("Blebus");
           if(blebus != null){
               System.out.println("not null------------------");
               System.out.println(blebus.get(0).getName() );

           }
    }*/





    }


}

package pl.sixfaces.relationship_db.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Warmup {
    NoteRepo noteRepo;


    @Autowired
    public Warmup(RepoStudent repoStudent, RepoBackpack repoBackpack, NoteRepo noteRepo, RepoProf repoProf, RepoRoom repoRoom, RepoCleaner repoCleaner) {


        Backpack backpack01 = new Backpack("Nike");
        Backpack backpack02 = new Backpack("Adidas");
        Backpack backpack03 = new Backpack("4F");


        repoBackpack.save(backpack01);
        repoBackpack.save(backpack02);
        repoBackpack.save(backpack03);


        Note note1 = new Note("Zeszyt z religji");
        Note note2 = new Note("Zeszyt z informatyki ");
        Note note3 = new Note("Zeszyt z histori ");
        Note note4 = new Note("Zeszyt z polskiego  ");

//      backpack01.add(note1);
//      backpack02.add(note2);
//      backpack03.add(note3);
//      backpack03.add(note4);


        note1.setBackpackId(backpack02);
        note2.setBackpackId(backpack01);
        note4.setBackpackId(backpack03);
        note3.setBackpackId(backpack03);


        noteRepo.save(note1);
        noteRepo.save(note2);
        noteRepo.save(note3);
        noteRepo.save(note4);


        repoBackpack.save(backpack01);
        repoBackpack.save(backpack02);
        repoBackpack.save(backpack03);


        backpack01.add(note1);
        backpack02.add(note2);
        backpack03.add(note3);
        backpack03.add(note4);


        note1.setBackpackId(backpack02);
        note2.setBackpackId(backpack01);
        note4.setBackpackId(backpack03);
        note3.setBackpackId(backpack03);


        noteRepo.save(note1);
        noteRepo.save(note2);
        noteRepo.save(note3);
        noteRepo.save(note4);


        Student student01 = new Student("Karol", "Blebus", "67276");
        Student student02 = new Student("Szczepan", "Kondzior", "342576");
        student01.setBackpack(backpack03);
        student02.setBackpack(backpack02);


        Professor professor01 = new Professor("prof", "nazwisko");
        Professor professor02 = new Professor("prdvof", "dvnazwisko");
        Professor professor03 = new Professor("prdvvnof", "dvnavnzwisko");


        Room room01 = new Room(2312, "muzyka");
        Room room02 = new Room(1212, "IT");
        Room room03 = new Room(5212, "wos");

        Cleaner cleaner01 = new Cleaner("Jas", "Kowalski");
        Cleaner cleaner02 = new Cleaner("Karolina", "Lesniacka");


        repoRoom.save(room01);
        repoRoom.save(room02);
        repoRoom.save(room03);

        professor01.setRoomID(room01);
        professor02.setRoomID(room02);
        professor03.setRoomID(room02);


        student01.add(professor01);
        student02.add(professor03);
        student02.add(professor01);
        student02.add(professor02);


        professor01.add(student02);
        professor01.add(student01);


        repoProf.save(professor01);
        repoProf.save(professor02);
        repoProf.save(professor03);

        repoStudent.save(student01);
        repoStudent.save(student02);


        cleaner01.add(room01);
        cleaner02.add(room02);
        cleaner02.add(room03);


        repoCleaner.save(cleaner01);
        repoCleaner.save(cleaner02);

        //repoStudent.deleteById(1L);


     /*   System.out.println("buu-------------");
        List<Student> blebus = repoStudent.findStudentBySurnameIs("Blebus");
        if (blebus != null) {
            System.out.println("not null------------------");
            System.out.println(blebus.get(0).getName());

        }*/


    }

}

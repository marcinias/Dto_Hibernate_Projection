package pl.sixfaces.relationship_db.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_room;
    private int numberRoom;
    private  String nameRoom;


    @ManyToMany(mappedBy = "roomList")
  /*  @JoinTable(
            name = "id_room_id_cleaner",
            joinColumns = @JoinColumn(name = "id_room"),
            inverseJoinColumns = @JoinColumn(name = "id_cleaner")

    )*/
    private List<Cleaner> cleanersList;


    public Room(int numberRoom, String nameRoom) {
        this.numberRoom = numberRoom;
        this.nameRoom = nameRoom;
    }

    public void add(Cleaner cleaner) {
        if (cleanersList == null) {
            cleanersList = new ArrayList<>();
        }
        cleanersList.add(cleaner);
    }

}

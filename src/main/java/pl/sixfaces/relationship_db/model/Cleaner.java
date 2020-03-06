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
public class Cleaner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_cleaner;
    private String name;
    private String surname;


  /*  @JoinTable(
            name = "id_room_id_cleaner",
            joinColumns = @JoinColumn(name = "id_cleaner"),
            inverseJoinColumns = @JoinColumn(name = "id_room")

    )*/
    @ManyToMany
    private List<Room> roomList;

    public Cleaner(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }


    public void add(Room room) {
        if (roomList == null) {
            roomList = new ArrayList<>();
        }
        roomList.add(room);
    }
}

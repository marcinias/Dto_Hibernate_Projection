package pl.sixfaces.relationship_db.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public Room(int numberRoom, String nameRoom) {
        this.numberRoom = numberRoom;
        this.nameRoom = nameRoom;
    }
}

package hogm.mongodb.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "player_website")
public class Website implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id    
    private int id;
    private String http_address;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }    

    public String getHttp_address() {
        return http_address;
    }

    public void setHttp_address(String http_address) {
        this.http_address = http_address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

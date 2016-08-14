package hogm.mongodb.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "players_photos")
public class Photo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String photo;  
    @ManyToOne
    @JoinColumn(name = "player_fk", unique = true, nullable = false, updatable = false)  
    private Player player;    

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }   
    
    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.id;
        hash = 61 * hash + Objects.hashCode(this.photo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Photo other = (Photo) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.photo, other.photo)) {
            return false;
        }
        return true;
    }            
}

package hogm.mongodb.entities;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ExcludeSuperclassListeners;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

@Entity
@ExcludeSuperclassListeners
@AttributeOverride(name = "age", column =
@Column(name = "tenis_player_age"))
public class TennisPlayer extends Player implements Serializable {

    private static final long serialVersionUID = 1L;
    protected String handplay;    

    @PrePersist
    @Override
    void onPrePersist() {
        Logger.getLogger(TennisPlayer.class.getName()).log(Level.INFO, "PREPARING THE PERSIST A TENNIS PLAYER OBJECT ...");
    }

    @PostPersist
    @Override
    void onPostPersist() {
        Logger.getLogger(TennisPlayer.class.getName()).log(Level.INFO, "THE TENNIS PLAYER OBJECT WAS PERSISTED ...");
    }

    @PostLoad
    @Override
    void onPostLoad() {
        Logger.getLogger(TennisPlayer.class.getName()).log(Level.INFO, "THE FIRST TENNIS PLAYER OBJECT WAS LOADED ...");
    }

    @PreUpdate
    void onPreUpdate() {
        Logger.getLogger(TennisPlayer.class.getName()).log(Level.INFO, "PREPARING THE UPDATE THE FIRST TENNIS PLAYER OBJECT ...");
    }

    @PostUpdate
    void onPostUpdate() {
        Logger.getLogger(TennisPlayer.class.getName()).log(Level.INFO, "THE FIRST TENNIS PLAYER OBJECT WAS UPDATED...");
    }

    @PreRemove
    void onPreRemove() {
        Logger.getLogger(TennisPlayer.class.getName()).log(Level.INFO, "PREPARING THE DELETE FOR THE FIRST TENNIS PLAYER OBJECT ...");
    }

    @PostRemove
    void onPostRemove() {
        Logger.getLogger(TennisPlayer.class.getName()).log(Level.INFO, "THE FIRST TENNIS PLAYER OBJECT WAS REMOVED ...");
    }
    
    public String getHandplay() {
        return handplay;
    }

    public void setHandplay(String handplay) {
        this.handplay = handplay;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.handplay);
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
        final TennisPlayer other = (TennisPlayer) obj;
        if (!Objects.equals(this.handplay, other.handplay)) {
            return false;
        }
        return true;
    }        
}

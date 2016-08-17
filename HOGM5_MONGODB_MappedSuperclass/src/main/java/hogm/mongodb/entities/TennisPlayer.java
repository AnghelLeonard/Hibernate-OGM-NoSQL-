package hogm.mongodb.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverride(name="age", column=@Column(name="tenis_player_age"))
public class TennisPlayer extends Player implements Serializable {
    
    private static final long serialVersionUID = 1L;
   
    protected String handplay; 

    public String getHandplay() {
        return handplay;
    }  
    
    public void setHandplay(String handplay) {
        this.handplay = handplay;
    }        

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.handplay);
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

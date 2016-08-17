package hogm.mongodb.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@AttributeOverride(name="age", column=@Column(name="baseball_player_age"))
public class BaseballPlayer extends Player implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    protected String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.position);
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
        final BaseballPlayer other = (BaseballPlayer) obj;
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        return true;
    }   
}

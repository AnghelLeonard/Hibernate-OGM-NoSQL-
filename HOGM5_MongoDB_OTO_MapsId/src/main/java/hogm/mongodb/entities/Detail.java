package hogm.mongodb.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Embeddable
@Table(name = "player_details")
public class Detail implements Serializable {
        
    private String birthplace;    
    private String residence;   
    private String height;    
    private String weight;    
    private String plays;    
    private int turnedpro;   
    private String coach;       
    @OneToOne(cascade={CascadeType.PERSIST}, fetch = FetchType.LAZY)
    private MoreDetails more;

    public MoreDetails getMore() {
        return more;
    }

    public void setMore(MoreDetails more) {
        this.more = more;
    }   
    
    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(String birthplace) {
        this.birthplace = birthplace;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }   

    public String getPlays() {
        return plays;
    }

    public void setPlays(String plays) {
        this.plays = plays;
    }

    public int getTurnedpro() {
        return turnedpro;
    }

    public void setTurnedpro(int turnedpro) {
        this.turnedpro = turnedpro;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }  

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.birthplace);
        hash = 43 * hash + Objects.hashCode(this.residence);
        hash = 43 * hash + Objects.hashCode(this.height);
        hash = 43 * hash + Objects.hashCode(this.weight);
        hash = 43 * hash + Objects.hashCode(this.plays);
        hash = 43 * hash + this.turnedpro;
        hash = 43 * hash + Objects.hashCode(this.coach);
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
        final Detail other = (Detail) obj;
        if (this.turnedpro != other.turnedpro) {
            return false;
        }
        if (!Objects.equals(this.birthplace, other.birthplace)) {
            return false;
        }
        if (!Objects.equals(this.residence, other.residence)) {
            return false;
        }
        if (!Objects.equals(this.height, other.height)) {
            return false;
        }
        if (!Objects.equals(this.weight, other.weight)) {
            return false;
        }
        if (!Objects.equals(this.plays, other.plays)) {
            return false;
        }
        if (!Objects.equals(this.coach, other.coach)) {
            return false;
        }
        return true;
    }        
}

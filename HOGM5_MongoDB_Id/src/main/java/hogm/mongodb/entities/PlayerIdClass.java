package hogm.mongodb.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 *
 * @author Anghel Leonard
 */
@Entity
@Table(name = "player_idclass_table")
@IdClass(hogm.mongodb.entities.RankingAndPrizeIdClassPK.class)
public class PlayerIdClass implements Serializable {

    private static final long serialVersionUID = 1L;    
    
    //********** Composite Key (IdClass) ************    
    @Id
    private int ranking;
    @Id
    private String prize;
    //**************************************************
    
    private String name;
    private String surname;
    private int age;
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }        

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.ranking;
        hash = 67 * hash + Objects.hashCode(this.prize);
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.surname);
        hash = 67 * hash + this.age;
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
        final PlayerIdClass other = (PlayerIdClass) obj;
        if (this.ranking != other.ranking) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.prize, other.prize)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        return true;
    }  
}

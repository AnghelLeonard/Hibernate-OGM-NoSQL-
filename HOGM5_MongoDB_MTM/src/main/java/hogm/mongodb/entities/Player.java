package hogm.mongodb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "atp_players")
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "player_name")
    private String name;
    @Column(name = "player_surname")
    private String surname;
    @Column(name = "player_age")
    private int age;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "player_birth")
    private Date birth;
    // for 
    // <property name="hibernate.ogm.datastore.document.association_storage" value="ASSOCIATION_DOCUMENT"/>    
    // <property name="hibernate.ogm.mongodb.association_document_storage" value="COLLECTION_PER_ASSOCIATION"/>
    // we can use the below structure:
    //@JoinTable(name = "PLAYERS_AND_TOURNAMENTS",joinColumns=
    //        @JoinColumn(name="PLAYER_ID", referencedColumnName="id"),
    //    inverseJoinColumns=
    //        @JoinColumn(name="TOURNAMENT_ID", referencedColumnName="id"))
    @ManyToMany(fetch = FetchType.LAZY)
    Set<Tournament> tournaments = new HashSet<>();

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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Set getTournaments() {
        return tournaments;
    }

    public void setTournaments(Set tournaments) {
        this.tournaments = tournaments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.id;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.surname);
        hash = 89 * hash + this.age;
        hash = 89 * hash + Objects.hashCode(this.birth);
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
        final Player other = (Player) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.age != other.age) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.birth, other.birth)) {
            return false;
        }
        return true;
    }        
}

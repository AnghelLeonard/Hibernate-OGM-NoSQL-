package hogm.mongodb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.ExcludeDefaultListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;

@MappedSuperclass
@ExcludeDefaultListeners
public abstract class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int id;
    @Column(name = "player_name")
    protected String name;
    @Column(name = "player_surname")
    protected String surname;
    @Column(name = "player_age")
    protected int age;
    @Temporal(javax.persistence.TemporalType.DATE)
    protected Date birth;

    @PrePersist
    void onPrePersist() {
        Logger.getLogger(Player.class.getName()).log(Level.INFO, "PREPARING THE PERSIST A (BASEBALL) PLAYER OBJECT ...");
    }

    @PostPersist
    void onPostPersist() {
        Logger.getLogger(Player.class.getName()).log(Level.INFO, "THE (BASEBALL) PLAYER OBJECT WAS PERSISTED ...");
    }

    @PostLoad
    void onPostLoad() {
        Logger.getLogger(Player.class.getName()).log(Level.INFO, "THE FIRST (BASEBALL) PLAYER OBJECT WAS LOADED ...");
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.id;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.surname);
        hash = 47 * hash + this.age;
        hash = 47 * hash + Objects.hashCode(this.birth);
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

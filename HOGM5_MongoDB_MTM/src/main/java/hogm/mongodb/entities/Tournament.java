package hogm.mongodb.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "atp_tournaments")
public class Tournament implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String tournament;
    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "tournaments", fetch = FetchType.LAZY)
    Set<Player> players = new HashSet<>();

    public void addPlayer(Player player) {
        this.players.add(player);
        player.tournaments.add(this);
    }

    public void removePlayer(Player player) {
        this.players.remove(player);
        player.tournaments.remove(this);
    }

    public Set getPlayers() {
        return players;
    }

    public void setPlayers(Set players) {
        this.players = players;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
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
        hash = 11 * hash + this.id;
        hash = 11 * hash + Objects.hashCode(this.tournament);
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
        final Tournament other = (Tournament) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.tournament, other.tournament)) {
            return false;
        }
        return true;
    }
}

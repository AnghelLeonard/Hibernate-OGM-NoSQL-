package hogm.mongodb.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Anghel Leonard
 */
@Embeddable
public class RankingAndPrizeEmbeddedPK implements Serializable {
    
    private int ranking;
    private String prize;

    public RankingAndPrizeEmbeddedPK() {
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
        int hash = 5;
        hash = 53 * hash + this.ranking;
        hash = 53 * hash + Objects.hashCode(this.prize);
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
        final RankingAndPrizeEmbeddedPK other = (RankingAndPrizeEmbeddedPK) obj;
        if (this.ranking != other.ranking) {
            return false;
        }
        if (!Objects.equals(this.prize, other.prize)) {
            return false;
        }
        return true;
    }
}

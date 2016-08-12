package hogm.mongodb.entities;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Anghel Leonard
 */
public class RankingAndPrizeIdClassPK implements Serializable {

    private int ranking;
    private String prize;

    public RankingAndPrizeIdClassPK() {
    }        

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.ranking;
        hash = 17 * hash + Objects.hashCode(this.prize);
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
        final RankingAndPrizeIdClassPK other = (RankingAndPrizeIdClassPK) obj;
        if (this.ranking != other.ranking) {
            return false;
        }
        if (!Objects.equals(this.prize, other.prize)) {
            return false;
        }
        return true;
    }        
}

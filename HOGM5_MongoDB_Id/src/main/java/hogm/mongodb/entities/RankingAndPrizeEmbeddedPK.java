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
    
}

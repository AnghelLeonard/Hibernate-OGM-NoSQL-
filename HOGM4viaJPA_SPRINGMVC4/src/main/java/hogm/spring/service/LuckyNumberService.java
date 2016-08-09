package hogm.spring.service;

import hogm.spring.model.LuckyNumberEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anghel Leonard
 */
@Service
public interface LuckyNumberService {
    
    public void persistLuckyNumber(LuckyNumberEntity luckyNumberEntity);
}

package hogm.spring.controllers;

import hogm.spring.model.LuckyNumberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hogm.spring.service.LuckyNumberService;
import java.util.Random;

/**
 *
 * @author Anghel Leonard
 */
@Controller
@RequestMapping("/")
public class SHController {

    @Autowired
    private LuckyNumberService luckyNumberService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage() {
        return "home";
    }

    @RequestMapping(value = "/storeln", method = RequestMethod.GET)
    public String storeLN() {

        LuckyNumberEntity luckyNumberEntity = new LuckyNumberEntity();
        luckyNumberEntity.setLuckynumber(new Random().nextInt(1000000));
        
        luckyNumberService.persistLuckyNumber(luckyNumberEntity);
        
        return "home";
    }
}

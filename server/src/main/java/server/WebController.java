package server;

import model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by home on 06/02/2017.
 */

@RestController
public class WebController {

    @Autowired
    private PlayerRepository playerRepository;

    @RequestMapping("/player/{id}")
    Player.User user(@PathVariable Integer id) {
        return playerRepository.findById(id);
    }
}

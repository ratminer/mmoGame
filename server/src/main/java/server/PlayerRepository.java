package server;

import model.Player;

/**
 * Created by home on 06/02/2017.
 */
public interface PlayerRepository {
    Player.User findById(int id);
}

package server;

import model.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by home on 06/02/2017.
 */
@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    private Player.User user(int id, String name, int x, int y) {
        return Player.User.newBuilder()
                .setId(id)
                .setUserName(name)
                .setX(x)
                .setY(y)
                .build();
    }

    @Bean
    PlayerRepository playerRepository() {
        Map<Integer, Player.User> players = new ConcurrentHashMap<>();
        Arrays.asList(
                user(1, "ratminer", 100, 100),
                user(2, "musdem", 200, 200)
        ).forEach(p -> players.put(p.getId(), p));

        return players::get;
    }
}

package client;

import model.Player;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;

/**
 * Created by home on 06/02/2017.
 */

public class ClientApplication {

    public static void main(String[] args) {
        ClientApplication app = new ClientApplication();

        System.out.println(app.user(1).getUserName());
    }

    int port = 8080;

    public Player.User user(int id) {

        URI uri = URI.create("http://localhost:" + port + "/player/" + id);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setMessageConverters(Arrays.asList(new ProtobufHttpMessageConverter()));

        ResponseEntity<Player.User> user = restTemplate.getForEntity(uri, Player.User.class);
        return user.getBody();
    }
}

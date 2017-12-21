package com.example.client.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestOperations;

import com.example.client.model.Player;

@Repository
public class PlayerRepository {
    private static final String BASE_API_URL = "http://localhost:8082/";
    private static final String PLAYER_API_URL = BASE_API_URL + "players/";

    @Autowired
    RestOperations restOperations;

    @SuppressWarnings("unchecked")
    public List<Player> findAll() {
        return restOperations.getForObject(PLAYER_API_URL, List.class);
    }

    public Player findOne(Long id) {
        return restOperations.getForObject(PLAYER_API_URL + "{id}", Player.class, id);
    }

    public void save(Player player) {
        restOperations.postForObject(PLAYER_API_URL, player, Player.class);
    }

    public void update(Player player) {
        restOperations.put(PLAYER_API_URL + "{id}", player, player.getId());
    }

    public void delete(Long id) {
        restOperations.delete(PLAYER_API_URL + "{id}", id);
    }
}

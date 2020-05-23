package com.manchkin.app.api.controller;

import com.manchkin.app.api.dto.PlayerDto;
import com.manchkin.app.jpa.models.Player;
import com.manchkin.app.jpa.repositories.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    private final ModelMapper modelMapper = new ModelMapper();
    private final PlayerRepository playerRepository;
    private List<Player> players = new ArrayList<>();


    public Controller(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @GetMapping
    public List<Player> get() {
        return players;
    }

    @PostMapping("/registration")
    @ResponseStatus(HttpStatus.CREATED)

    public void registration(@Valid @RequestBody PlayerDto playerDto) { //TODO: запилить шифрование паролей
        if (!playerRepository.existsByLogin(playerDto.getLogin())) {
            Player player = convertDtoToEntity(playerDto);
            playerRepository.save(player);
            players.add(player);
        }
    }

    private Player convertDtoToEntity(PlayerDto playerDto) {
        return modelMapper.map(playerDto, Player.class);
    }
}

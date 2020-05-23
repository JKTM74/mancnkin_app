package com.manchkin.app.api.controller;

import com.manchkin.app.api.dto.BooleanResponseDto;
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
public class PlayerController {

    private final ModelMapper modelMapper = new ModelMapper();
    private final PlayerRepository playerRepository;

    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    /**
     * Метод на регистрацию игрока
     * @param playerDto дто на создание игрока
     * @return в случае успешной регистрации - тру, иначе фолс
     */
    @PostMapping("/registration")
    public BooleanResponseDto registration(@Valid @RequestBody PlayerDto playerDto) { //TODO: запилить шифрование паролей
        if (!playerRepository.existsByLogin(playerDto.getLogin())) {
            Player player = convertDtoToEntity(playerDto);
            playerRepository.save(player);
            return new BooleanResponseDto(true);
        } else {
            return new BooleanResponseDto(false);
        }
    }

    private Player convertDtoToEntity(PlayerDto playerDto) {
        return modelMapper.map(playerDto, Player.class);
    }
}

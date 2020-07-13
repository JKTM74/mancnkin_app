package com.manchkin.app.api.controller;


import com.manchkin.app.jpa.models.Player;
import com.manchkin.app.jpa.models.Room;
import com.manchkin.app.jpa.repositories.RoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    private final ModelMapper modelMapper = new ModelMapper();
    private final RoomRepository roomRepository;

    public RoomController(RoomRepository roomRepository) {

        this.roomRepository = roomRepository;
    }

    @GetMapping("/room")
    public List<Room> rooms() {
        return roomRepository.findAll();
    }
}


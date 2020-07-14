package com.manchkin.app.api.controller;


import com.manchkin.app.jpa.models.Room;
import com.manchkin.app.jpa.repositories.RoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @PostMapping("/room")
    public void testSaveRoom() {
        roomRepository.save(Room.builder()
                .name("huy")
                .isActive(true)
                .info("huy")
                .build());
    }
}


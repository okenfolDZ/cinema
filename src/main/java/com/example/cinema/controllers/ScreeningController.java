package com.example.cinema.controllers;

import com.example.cinema.dto.incoming.ScreeningCommand;
import com.example.cinema.services.ScreeningService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/screenings")
public class ScreeningController {
    private ScreeningService screeningService;


    public ScreeningController(ScreeningService screeningService) {
        this.screeningService = screeningService;
    }


    @PostMapping
    public ResponseEntity addScreeening(@RequestBody ScreeningCommand command) {
        screeningService.addScreening(command);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

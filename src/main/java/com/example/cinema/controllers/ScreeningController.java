package com.example.cinema.controllers;

import com.example.cinema.dto.incoming.ScreeningCommand;
import com.example.cinema.dto.outgoing.ScreeningListItem;
import com.example.cinema.services.ScreeningService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/list-all")
    public ResponseEntity<List<ScreeningListItem>> getAllProducts() {
        List<ScreeningListItem> productListItems = screeningService.getAllScreenings();
        return  new ResponseEntity<>(productListItems, HttpStatus.OK);
    }


}

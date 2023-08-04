package com.example.cinema.dto.incoming;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ScreeningCommand {
    private String title;
    private LocalDateTime screeningDate;
    private Integer totalSeat;
    private String pictureUrl;

}

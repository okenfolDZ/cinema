package com.example.cinema.dto.outgoing;

import com.example.cinema.domains.Screening;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ScreeningListItem {


    private String title;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime screeningDate;
    private Integer totalSeats;
    private Integer freeSeats;
    private String pictureUrl;

    public ScreeningListItem(Screening screening) {
        this.title = screening.getTitle();
        this.screeningDate = screening.getScreeningDate();
        this.totalSeats = screening.getTotalSeats();
        this.pictureUrl = screening.getPictureUrl();
        this.freeSeats = this.totalSeats-0; //TODO
    }
}

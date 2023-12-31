package com.example.cinema.services;

import com.example.cinema.domains.Screening;
import com.example.cinema.dto.incoming.ScreeningCommand;
import com.example.cinema.dto.outgoing.ScreeningListItem;
import com.example.cinema.repositories.ScreeningRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class ScreeningService {

    private ScreeningRepository screeningRepository;

    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    public void addScreening(ScreeningCommand command) {
        screeningRepository.save(new Screening(command));

    }

    public List<ScreeningListItem> getAllScreenings() {
        return screeningRepository.findAllOrderByScreeningDate().stream().map(ScreeningListItem::new)
                .collect(Collectors.toList());
    }
}

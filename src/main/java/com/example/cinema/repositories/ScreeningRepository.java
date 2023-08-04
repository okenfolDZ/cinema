package com.example.cinema.repositories;

import com.example.cinema.domains.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreeningRepository extends JpaRepository<Screening, Long> {

    @Query("SELECT s FROM Screening s ORDER BY s.screeningDate ASC")
    List<Screening> findAllOrderByScreeningDate();

}

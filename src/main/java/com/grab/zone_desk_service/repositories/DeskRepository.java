package com.grab.zone_desk_service.repositories;

import com.grab.zone_desk_service.models.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeskRepository extends JpaRepository<Desk, Long> {
    boolean existsByDeskNumber(String deskNumber);

    List<Desk> findAllByZoneId(Long zoneId);

    Desk getDeskByDeskId(Long deskId);

    List<Desk> getDeskByZoneId(Long zoneId);
}

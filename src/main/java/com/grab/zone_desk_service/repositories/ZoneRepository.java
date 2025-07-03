package com.grab.zone_desk_service.repositories;

import com.grab.zone_desk_service.models.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZoneRepository extends JpaRepository<Zone, Long> {

    List<Zone> findAllByFloorId(Long floorId);
}

package com.grab.zone_desk_service.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "zones")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long zoneId;
    @NotBlank
    private String zoneNumber;
    @NotBlank
    private Long floorId;

    public Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(Long zone_id) {
        this.zoneId = zone_id;
    }

    public @NotBlank String getZoneNumber() {
        return zoneNumber;
    }

    public void setZoneNumber(@NotBlank String zoneNumber) {
        this.zoneNumber = zoneNumber;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floor_id) {
        this.floorId = floor_id;
    }
}

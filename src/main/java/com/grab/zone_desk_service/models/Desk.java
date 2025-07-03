package com.grab.zone_desk_service.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "desks")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Desk {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long deskId;
    @NotBlank
    @Size(min = 1, max = 10)
    private String deskNumber;
    @NotBlank
    private Long zoneId;
    @Enumerated(EnumType.STRING)
    private Status status;

    public Long getDeskId() {
        return deskId;
    }

    public void setDeskId(Long desk_id) {
        this.deskId = desk_id;
    }

    public @NotBlank @Size(min = 1, max = 10) String getDeskNumber() {
        return deskNumber;
    }

    public void setDeskNumber(@NotBlank @Size(min = 1, max = 10) String desk_number) {
        this.deskNumber = desk_number;
    }

    public @NotBlank Long getZoneId() {
        return zoneId;
    }

    public void setZoneId(@NotBlank Long zone_id) {
        this.zoneId = zone_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}

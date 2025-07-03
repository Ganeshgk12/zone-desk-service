package com.grab.zone_desk_service.feignclients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "BUILDING-FLOOR-SERVICE")
public interface BuildingFloorService {
}

package com.grab.zone_desk_service.wrappers;

public interface Utils {
    String generateDeskNumber(String zoneNumber, int noOfPreviousDesks);
    String generateZoneNumber(String floorNumber, int zoneCount);
}

package com.grab.zone_desk_service.wrappers;

public class UtilsImpl implements Utils {

    @Override
    public String generateDeskNumber(String zoneNumber, int noOfPreviousDesks) {
        noOfPreviousDesks += 1;
        return zoneNumber+ "-" +noOfPreviousDesks;
    }

    @Override
    public String generateZoneNumber(String floorNumber, int zoneCount) {
        zoneCount += 1;
        return floorNumber+ "-" +zoneCount;
    }
}

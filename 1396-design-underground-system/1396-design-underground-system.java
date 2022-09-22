class UndergroundSystem {
    Map<String, Map<String, Integer[]>> stationAverage;
    Map<Integer, StationCheckIn> checkInTime;
    public UndergroundSystem() {
        stationAverage = new HashMap<>();
        checkInTime = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInTime.put(id, new StationCheckIn(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        StationCheckIn checkedInStation = checkInTime.get(id);
        int timeToTravel = t - checkedInStation.checkInTime;
        Map<String, Integer[]> timeTravel = stationAverage.getOrDefault(checkedInStation.station, new HashMap<>());
        Integer[] times = timeTravel.getOrDefault(stationName, new Integer[2]);
        if (times[0] == null) {
            times[0] = 0;
            times[1] = 0;
        }
        times[0] += timeToTravel;
        times[1]++;
        timeTravel.putIfAbsent(stationName, times);
        stationAverage.putIfAbsent(checkedInStation.station, timeTravel);
        checkInTime.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        Integer[] sumAndCount = stationAverage.get(startStation).get(endStation);
        return (double) sumAndCount[0] / sumAndCount[1];
    }
    
    class StationCheckIn {
        String station;
        int checkInTime;
        StationCheckIn(String station, int checkInTime) {
            this.station =  station;
            this.checkInTime = checkInTime;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
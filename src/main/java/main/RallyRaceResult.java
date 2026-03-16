package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * RallyRaceResult class handles the rally races.
 * Also implements the interface RaceResult
 */
public class RallyRaceResult implements RaceResult {
  
  private String raceName;
  private String location;
  private Map<Driver,Integer> results;
  private Map<Integer, Driver> driverPositions;

  /**
   * 
   * @param raceName is the name of the race.
   * @param location is the location of the race.
   */
  public RallyRaceResult(String raceName, String location) {
    this.raceName = raceName;
    this.location = location;
    this.results = new HashMap<>(); // A hashmap for managing results
    this.driverPositions = new LinkedHashMap<Integer,Driver>(); // A Linked hash map to manage the postions of the drivers for the method getResults.
  }

  public String getRaceName() {
    return raceName;
  }
  public String getLocation() {
    return location;
  }

  /**
   * recordResult records the relevant details about the race that driver did.
   * @param driver is the driver that raced.
   * @param position is the position of the driver in that race.
   * @param points are the points that the driver has got from the race.
   */
  @Override
  public void recordResult(Driver driver, int position, int points) {
    results.put(driver, points);
    driver.addPoints(points);
    driverPositions.put(position, driver);
  }

  /**
   * This funtion return the points of a specific driver.
   * @param driver is the driver whose points are being returned
   * @return the points of the specific driver.
   */
  @Override
  public int getDriverPoints(Driver driver) {
    return results.get(driver);
  }

  /**
   * @return the list of all the drivers in order.
   */
  @Override
  public List<Driver> getResults() {
    List<Driver> orderedResults = new ArrayList<>();
    for (Driver d : driverPositions.values()) {
      orderedResults.add(d);
    }
    return orderedResults;
  }

}

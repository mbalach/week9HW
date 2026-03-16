package main;

import java.util.ArrayList;
import java.util.List;

/**
 * Manages championships.
 */
public class ChampionshipManager {
  
  static ChampionshipManager instance;
  private List<Driver> drivers;
  private List<RallyRaceResult> races;
  static int totalDrivers; // Keeps the count of the total drivers
  static int totalRaces; // Keeps the count of the total races.

  /**
   * Creates a Championship Manager.
   */
  private ChampionshipManager() {
    this.drivers = new ArrayList<>();
    this.races = new ArrayList<>();
  }

  /**
   * Creates a singleton instance of the championship manager.
   * 
   * @return singleton instance of the championship manager.
   */
  public static ChampionshipManager getInstance() {
    if (instance == null) {
      instance = new ChampionshipManager();
    }
    return instance;
  }

  /**
   * Registers a driver.
   * 
   * @param driver driver to register.
   */
  public void registerDriver(Driver driver) {
    drivers.add(driver);
    totalDrivers += 1;
  }

  /**
   * Adds the results of the race.
   * 
   * @param result result to add.
   */
  public void addRaceResult(RallyRaceResult result) {
    races.add(result);
    totalRaces += 1;
  }

  public List<RallyRaceResult> getRaceResults() {
    return races;
  }

  /**
   * Returns the driver standings.
   * 
   * @return driver standings.
   */
  public List<Driver> getDriverStandings() {
    return drivers;
  }

  /**
   * Returns the leading driver.
   * 
   * @return leading driver.
   */
  static Driver getLeadingDriver() {
    Driver leader = null;
    for (Driver d : getInstance().drivers) {
        if (leader == null || d.getPoints() > leader.getPoints()) {
            leader = d;
        }
    }
    return leader;
  }

  /**
   * Returns the total championship points
   * 
   * @return total championship points.
   */
  static int getTotalChampionshipPoints() {
    int total = 0;
    for (Driver d : getInstance().drivers) {
        total += d.getPoints();
    }
    return total;
  }

}


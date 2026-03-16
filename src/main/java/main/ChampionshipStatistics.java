package main;

import java.util.HashMap;
import java.util.List;

// I used AI to understand and use HashMaps and to conceptualize this class.

/**
 * Class that manages championship statistics.
 */
public class ChampionshipStatistics {
  
  /**
   * Calculates average points per driver.
   * 
   * @param drivers list of drivers.
   * @return average points per driver.
   */
  public static double calculateAveragePointsPerDriver(List<Driver> drivers) {
    int totalDriverPoints = 0;
    for (Driver d : drivers) {
      totalDriverPoints += d.getPoints();
    }
    return (double) totalDriverPoints / ChampionshipManager.totalDrivers;
  }

  /**
   * Finds the most successful country
   * 
   * @param drivers list of drivers
   * @return the most successful country.
   */
  public static String findMostSuccessfulCountry(List<Driver> drivers) {
    HashMap<String, Integer> countryPoints = new HashMap<>();
    for (Driver d : drivers) {
      if (countryPoints.containsKey(d.getCountry())) {
        countryPoints.put(d.getCountry(), countryPoints.get(d.getCountry())+d.getPoints()); 
      } else {
        countryPoints.put(d.getCountry(),d.getPoints());
      }
    }
    int maxPoints = 0;
    String bestCountry = "";
    for (String country : countryPoints.keySet()) { 
      if (countryPoints.get(country) > maxPoints) {
        maxPoints = countryPoints.get(country);
        bestCountry = country;
      }
    }
    return bestCountry;
  }

  public static int getTotalRacesHeld() {
   return ChampionshipManager.totalRaces; 
  }

}

package main;

import java.util.List;

/**
 * Hello world!
 *
 */
public class RallyChampionship 
{
    public static void main( String[] args )
    {

        GravelCar gravelCar = new GravelCar("Toyota", "Corrolla", 342, 40); // Since there is no info given on what should I have as parameters I am using my own.
        AsphaltCar asphaltCar = new AsphaltCar("Mitsubishi", "Lancer", 412, 90);

        Driver driver1 = new Driver("Sébastien Ogier", "France", 0, gravelCar);
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland", 0, gravelCar);
        Driver driver3 = new Driver("Ott Tänak", "Estonis", 0, gravelCar);
        Driver driver4 = new Driver("Thierry Neuville", "Belgium", 0, gravelCar);

        ChampionshipManager championshipManager = ChampionshipManager.getInstance();

       //ChampionshipStatistics championshipStatistics = new ChampionshipStatistics();
       //Didn't use it because we do not need an instance to use the static functions and variables.

        championshipManager.registerDriver(driver1);
        championshipManager.registerDriver(driver2);
        championshipManager.registerDriver(driver3);
        championshipManager.registerDriver(driver4);

        RallyRaceResult rallyRaceResult1 = new RallyRaceResult("Rally Finland", "Jyväskylä");
        RallyRaceResult rallyRaceResult2 = new RallyRaceResult("Monte Carlo Rally", "Monaco");

        rallyRaceResult1.recordResult(driver1, 1, 25);
        rallyRaceResult1.recordResult(driver3, 2, 18);
        rallyRaceResult1.recordResult(driver2, 3, 15);
        rallyRaceResult1.recordResult(driver4, 4, 12);

        championshipManager.addRaceResult(rallyRaceResult1);

        driver1.setCar(asphaltCar);
        driver2.setCar(asphaltCar);
        driver3.setCar(asphaltCar);
        driver4.setCar(asphaltCar);

        rallyRaceResult2.recordResult(driver2, 1, 25);
        rallyRaceResult2.recordResult(driver4, 2, 18);
        rallyRaceResult2.recordResult(driver1, 3, 15);
        rallyRaceResult2.recordResult(driver3, 4, 12);

        championshipManager.addRaceResult(rallyRaceResult2);

        //I have written the driver standings in both ways just in case:)

        //System.out.println("1. " + driver1.getName() + " (" + driver1.getCountry() + ") : " + driver1.getPoints() + " points");
        //System.out.println("2. " + driver2.getName() + " (" + driver2.getCountry() + ") : " + driver2.getPoints() + " points");
        //System.out.println("3. " + driver3.getName() + " (" + driver3.getCountry() + ") : " + driver3.getPoints() + " points");
        //System.out.println("4. " + driver4.getName() + " (" + driver4.getCountry() + ") : " + driver4.getPoints() + " points");

        List<Driver> raceDrivers = championshipManager.getDriverStandings();
        for (int i = 0; i < raceDrivers.size() ; i++) {
            Driver driver = raceDrivers.get(i);
            System.out.println((i+1) + ". " + driver.getName() + " (" + driver.getCountry() + "): " + driver.getPoints() + " points");
        }

        System.out.println("===== CHAMPIONSHIP LEADER =====");

        System.out.println(ChampionshipManager.getLeadingDriver().getName() + " with " + ChampionshipManager.getLeadingDriver().getPoints() + " points.\n");

        System.out.println("===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + ChampionshipManager.totalDrivers);
        System.out.println("Total Races: " + ChampionshipManager.totalRaces);
        System.out.printf("Average Points Per Driver: %.2f%n", ChampionshipStatistics.calculateAveragePointsPerDriver(championshipManager.getDriverStandings())); // Used AI here to know how to make the answer in 2 decimal places.
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(raceDrivers));
        System.out.println("Total Championship Points: " + ChampionshipManager.getTotalChampionshipPoints());

        System.out.println("\n===== RACE RESULTS =====");
        
    for (RallyRaceResult race : championshipManager.getRaceResults()) { // Outer loop is used to access each race / RallyRaceResult
        System.out.println("Race: " + race.getRaceName() + " (" + race.getLocation() + ")");
        for (int i = 0; i < race.getResults().size(); i++) { // Inner loop gets the drivers data from the race got from the upper loop.
            System.out.println("Position " + (i+1) + ": " + race.getResults().get(i).getName() + " - " + race.getDriverPoints(race.getResults().get(i)) + " points");
        }
        System.out.println("");
    }

    System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
    // The resuls are not same because I didn't new the exact value and the formula to calculate the performance.
    System.out.printf("Gravel Car Performance: %.1f%n", gravelCar.calculatePerformane());
    System.out.printf("Asphalt Car Performance: %.1f%n", asphaltCar.calculatePerformane());



    }
}

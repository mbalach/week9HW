package main;


/**
 * Driver class instantiates a driver instance.
 */
public class Driver {

  private String name;
  private String country;
  private int points;
  private RallyCar car;

  /**
   * Creates a new driver instance.
   * 
   * @param name is the drivers name.
   * @param country is the drivers country.
   * @param points are the drivers total points.
   * @param car is the car that the driver drives.
   */
  public Driver(String name, String country, int points, RallyCar car) {
    this.name = name;
    this.country = country;
    this.points = points;
    this.car = car;
  }

  public void setName(String name) {
    this.name = name;
  }
  public void setCountry(String country) {
    this.country = country;
  }
  public void setTotalPoints(int points) {
    this.points = points;
  }
  public void setCar(RallyCar car) {
    this.car = car;
  }

  public String getName() {
    return this.name;
  }
  public String getCountry() {
    return this.country;
  }
  public int getPoints() {
    return this.points;
  }
  public RallyCar getCar() {
    return car;
  }

  /**
   * Adds points of the driver to total points.
   * 
   * @param points points to add.
   */
  public void addPoints(int points) {
    this.points += points;
  }

}

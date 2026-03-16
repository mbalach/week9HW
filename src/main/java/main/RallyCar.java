package main;

/**
 * Abstract parent class for instantiating a Rally Car
 */
public abstract class RallyCar {
  
  protected String make;
  protected String model;
  protected int horsepower;

  /**
   * Creates a instance of a Rally car.
   * 
   * @param make
   * @param model
   * @param horsepower
   */
  public RallyCar(String make, String model, int horsepower) {
    this.make = make;
    this.model = model;
    this.horsepower = horsepower;
  }

  public String getMake() {
    return make;
  }
  public String getModel() {
    return model;
  }
  public int getHorsepower() {
    return horsepower;
  }

  abstract double calculatePerformane();

}

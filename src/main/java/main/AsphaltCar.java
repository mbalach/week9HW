package main;

public class AsphaltCar extends RallyCar{
  
  private double downForce;

  /**
   * Creates a new asphalt car.
   * 
   * @param make make of the asphalt car.
   * @param model model of the asphalt car.
   * @param horsepower horsepower of the asphalt car.
   * @param downForce down force of the asphalt car.
   */
  public AsphaltCar(String make, String model, int horsepower, double downForce) {
    super(make, model, horsepower);
    this.downForce = downForce;
  }

  public double getDownForce() {
    return downForce;
  }

  /**
   * Calculates the performance of the asphalt car
   * 
   * @return performance of the asphalt car.
   */
  @Override
  double calculatePerformane() {
    return (this.horsepower * 0.7) + (this.downForce * 0.3);
  }

}

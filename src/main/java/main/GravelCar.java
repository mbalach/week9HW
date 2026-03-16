package main;

/**
 * Creates a Gravel Car instance.
 */
public class GravelCar extends RallyCar {
  
  private double suspensionTravel;

  /**
   * Creates a new Gravel car.
   * 
   * @param make make of the gravel car.
   * @param model model of the gravel car.
   * @param horsepower horsepower of the gravel car.
   * @param suspensionTravel suspension travel of the gravel car.
   */
  public GravelCar(String make, String model, int horsepower, double suspensionTravel) {
    super(make, model, horsepower);
    this.suspensionTravel = suspensionTravel;
  }

  public double getSuspensionTravel() {
    return this.suspensionTravel;
  }

  /**
   * Calculates the performance of the gravel car
   * 
   * @return performance of the gravel car.
   */
  @Override
  public double calculatePerformane() {
    return (this.horsepower * 0.7) + (this.suspensionTravel * 0.3);
  }

}

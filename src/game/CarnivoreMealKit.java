package game;

public class CarnivoreMealKit extends Food {

  public CarnivoreMealKit(int foodLevelPoint, String name, char displayChar, boolean portable) {
    super(foodLevelPoint, name, displayChar, portable);
  }

  public CarnivoreMealKit(int foodLevelPoint, String name, char displayChar, boolean portable,
      double percentPickUp) {
    super(foodLevelPoint, name, displayChar, portable, percentPickUp);
  }
}

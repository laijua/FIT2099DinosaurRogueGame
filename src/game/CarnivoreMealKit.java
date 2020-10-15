package game;

public class CarnivoreMealKit extends Food {

  public CarnivoreMealKit(int foodLevelPoint, String name, char displayChar, boolean portable) {
    super(foodLevelPoint, name, displayChar, portable);
    addCapability(GameCapability.CARNIVOREEDIBLE);
  }
}

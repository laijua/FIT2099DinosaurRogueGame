package game;

/**
 * An Food Item that can be eaten/feed by Player to VEGANS
 */
public class VegetarianMealKit extends Food {

  public VegetarianMealKit(int foodLevelPoint, String name, char displayChar, boolean portable) {
    super(foodLevelPoint, name, displayChar, portable);
    addCapability(GameCapability.HERBIVOREEDIBLE);
  }


}

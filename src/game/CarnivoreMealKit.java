package game;
/**
 * An Item that can be eaten/feed by Player to Carnivores
 */
public class CarnivoreMealKit extends Food {
  /***
   * Constructor.
   * @param foodLevelPoint How much points of food does it give to an animal
   * @param name the name of this Food
   * @param displayChar the character to use to represent this item if it is on the ground
   * @param portable true if and only if the Item can be picked up
   */
  public CarnivoreMealKit(int foodLevelPoint, String name, char displayChar, boolean portable) {
    super(foodLevelPoint, name, displayChar, portable);
    addCapability(GameCapability.CARNIVOREEDIBLE);
  }
}

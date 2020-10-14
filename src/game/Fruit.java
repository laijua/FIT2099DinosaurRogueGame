package game;

import edu.monash.fit2099.engine.Item;

public class Fruit extends Food {
  private int fruitDecay = 20;
  /***
   * Constructor.
   *  @param name the name of this Item
   * @param displayChar the character to use to represent this item if it is on the ground
   * @param portable true if and only if the Item can be picked up
   */
  public Fruit(int foodLevelPoint,String name, char displayChar, boolean portable) {
    super(foodLevelPoint,name, displayChar, portable);
  }
  public void decayFruit() {
    fruitDecay--;
  }

  public int getDecay() {
    return fruitDecay;
  }
}

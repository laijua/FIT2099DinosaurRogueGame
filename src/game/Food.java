package game;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.PickUpItemAction;

public abstract class Food extends Item {
  private int foodLevelPoint;
  private double percentPickUp = 1.5;

  public Food(int foodLevelPoint,String name, char displayChar, boolean portable) {
    super(name, displayChar, portable);
    this.foodLevelPoint = foodLevelPoint;

  }
  public Food(int foodLevelPoint,String name, char displayChar, boolean portable,double percentPickUp) {
    super(name, displayChar, portable);
    this.foodLevelPoint = foodLevelPoint;
    this.percentPickUp = percentPickUp;
  }
  @Override
  public PickUpItemAction getPickUpAction() {
    if(portable && Math.random()< percentPickUp)
      return new PickUpItemAction(this);
    return new FailPickUpItemAction(this);
  }

  public int getFoodLevelPoint() {
    return foodLevelPoint;
  }
}


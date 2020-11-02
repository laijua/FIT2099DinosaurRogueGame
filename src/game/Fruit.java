package game;


import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/**
 * An Food item class that can be dropped via Trees or purchaseable.
 */
public class Fruit extends Food {
  private int fruitDecay = 20;
  /***
   * Constructor.
   * Also adds capability if the type of dinosaur is able to eat it.
   *  @param name the name of this Item
   * @param displayChar the character to use to represent this item if it is on the ground
   * @param portable true if and only if the Item can be picked up
   */
  public Fruit(String name, char displayChar, boolean portable) {
    super(30,name, displayChar, portable,0.6,15);
    addCapability(GameCapability.HERBIVOREEDIBLE);
  }

  /**
   * Decay the fruits age as it may rot
   */
  public void decayFruit() {
    fruitDecay--;
  }

  /**
   * Simple Getter that returns the Fruits Age
   * @return Integer value
   */
  public int getDecay() {
    return fruitDecay;
  }

  /**
   * Inform a carried Item of the passage of time.
   *
   * This method is called once per turn, if the Item is being carried.
   * @param currentLocation The location of the actor carrying this Item.
   * @param actor The actor carrying this Item.
   */
  @Override
  public void tick(Location currentLocation, Actor actor) {
    System.out.println("Decats Fruit"+getDecay());
    if (actor instanceof  Player){
      this.decayFruit();
      if (this.getDecay()==0){
        actor.removeItemFromInventory(this);
      }
    }
  }
  /**
   * Inform an Item on the ground of the passage of time.
   * This method is called once per turn, if the item rests upon the ground.
   * @param currentLocation The location of the ground on which we lie.
   */
  public void tick(Location currentLocation) {
    if (currentLocation.getItems().contains(this)) {
      this.decayFruit();
      if (this.getDecay() == 0) {
        currentLocation.removeItem(this);
        if (currentLocation.getGround() instanceof Tree){
          currentLocation.getGround().addCapability(GameCapability.DROPFRUIT);
        }
      }
    }


  }
}


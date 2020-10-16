package game;

import edu.monash.fit2099.engine.WeaponItem;

/**
 * A class that represents a LaserGun that Player can use
 * only purchasable via VendingMachine
 */
public class LaserGun extends WeaponItem {

  /**
   * Constructor.
   * Initialize all the params in Weapon item,
   * @param name        name of the item
   * @param displayChar character to use for display when item is on the ground
   * @param damage      amount of damage this weapon does
   * @param verb        verb to use for this weapon, e.g. "hits", "zaps"
   */
  public LaserGun(String name, char displayChar, int damage, String verb) {
    super(name, displayChar, damage, verb);
  }

}

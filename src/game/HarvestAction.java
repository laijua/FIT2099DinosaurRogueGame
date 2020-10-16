package game;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.PickUpItemAction;

/**
 * An action class that represents an item from the Ground type to be harvested.
 */
public class HarvestAction extends PickUpItemAction {

  /**
   * Constructor.
   * Given an item to harvest.
   * @param item the item to pick up
   */
  public HarvestAction(Item item) {
    super(item);
  }

  /**
   * Action to be executed, removes current Ground type to Dirt since were harvesting it,
   * and adds that onto the players inventory
   * @param actor The actor performing the action.
   * @param map The map the actor is on.
   * @return The descriptions of what has occurred
   */
  @Override
  public String execute(Actor actor, GameMap map) {
    map.locationOf(actor).setGround(new Dirt());
    actor.addItemToInventory(item);
    return menuDescription(actor);
  }

  /**
   * Returns a string ,which will be shown as a menu item given to the Player
   * @param actor The actor performing the action.
   * @return String of menu item.
   */
  @Override
  public String menuDescription(Actor actor) {
    return super.menuDescription(actor);
  }
}

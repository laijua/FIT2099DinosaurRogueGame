package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.PickUpItemAction;

public class FailPickUpItemAction extends PickUpItemAction {

  /**
   * Constructor.
   *
   * @param item the item to pick up
   */
  public FailPickUpItemAction(Item item) {
    super(item);
  }
  /**
   * Add the item to the actor's inventory.
   *
   * @see Action#execute(Actor, GameMap)
   * @param actor The actor performing the action.
   * @param map The map the actor is on.
   * @return a suitable description to display in the UI
   */
  @Override
  public String execute(Actor actor, GameMap map) {
    return actor + "dasdsadsadasdsa";
  }

  /**
   * Describe the action in a format suitable for displaying in the menu.
   *
   * @see Action#menuDescription(Actor)
   * @param actor The actor performing the action.
   * @return a string, e.g. "Player picks up the rock"
   */
  @Override
  public String menuDescription(Actor actor) {
    return actor + " picks up the " + item;
    //return actor + " searched the tree for " + item+ ", but could not find any ripe ones.";
  }
}

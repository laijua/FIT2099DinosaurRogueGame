package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * Class that describes an actor feeding to a dinosaur action
 */
public class FeedAction extends Action {
  protected Food item;
  protected Dinosaur dinosaur;


  /**
   * Constructor that initializes the item and dinosaur in which the item is given to
   * @param item An Food item that can be edible
   * @param dinosaur The actor in which gets the food
   */
  public FeedAction(Food item,Dinosaur dinosaur) {
    this.item = item;
    this.dinosaur = dinosaur;
  }

  /**
   * Executes action, increases ecopoints and remove from player inventory and feeds to dinosaur.
   *
   * @see Action#execute(Actor, GameMap)
   * @param actor The actor performing the action.
   * @param map The map the actor is on.
   * @return a suitable description to display in the UI
   */
  @Override
  public String execute(Actor actor, GameMap map) {
    String getFoodLevelPoint = ""+item.getFoodLevelPoint();
    // MAke sure to check if it reaches max
    dinosaur.increaseFoodLevel(item.getFoodLevelPoint());
    actor.removeItemFromInventory(item);
    return dinosaur + " has been fed " + getFoodLevelPoint + " points";
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
    return actor + " feeds "+item +" to " + dinosaur;
  }
}

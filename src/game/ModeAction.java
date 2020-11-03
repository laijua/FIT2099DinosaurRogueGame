package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

/**
 * Class that describes what mode the player should take
 */
public class ModeAction extends Action {
  private Enum<?> modeType;

  /**
   * Constructor that initializes mode of game
   * @param modeType Type of mode
   */
  public ModeAction(Enum<?> modeType){
    this.modeType = modeType;

  }
  /**
   * Executes action, returns a string in which indicate which mode has been selected.
   *
   * @see Action#execute(Actor, GameMap)
   * @param actor User
   * @param map The map the actor is on.
   * @return a suitable description to display in the UI
   */
  @Override
  public String execute(Actor actor, GameMap map) {
    if (modeType ==GameCapability.CHALLENGEMODE){
      return "C";
    }
    else if (modeType == GameCapability.SANDBOXMODE){
      return "S";
    }
    else if (modeType == GameCapability.QUITMODE){
      if (map != null)
      map.removeActor(actor);
      return "Q";
    }
    return null;
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
    if (modeType ==GameCapability.CHALLENGEMODE){
      return "Choose Challenge MODE";
    }
    else if (modeType == GameCapability.SANDBOXMODE){
     return "Choose sandbox mode";
    }
    else if (modeType == GameCapability.QUITMODE){
      return "Quit";
    }
    return null;
  }
}

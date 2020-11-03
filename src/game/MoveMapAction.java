package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import java.util.ArrayList;

/**
 * Class that represents movement from one map to the other other
 */
public class MoveMapAction extends Action {
  private WorldModified worldModified;
  private Boolean goTop ;
  public MoveMapAction(WorldModified worldModified, Boolean goTop){
    this.worldModified = worldModified;
    this.goTop = goTop;

  }
  /**
   * Moves actor from one map to the other
   *
   * @see Action#execute(Actor, GameMap)
   * @param actor User
   * @param map The map the actor is on.
   * @return a suitable description to display in the UI
   */
  @Override
  public String execute(Actor actor, GameMap map) {
    ArrayList<GameMap> list = worldModified.getGameMap();
    int current_x = map.locationOf(actor).x();
    int current_y = map.locationOf(actor).y();
    if (goTop){
      // First Index will display the top map thus minus one to the current index
      GameMap currentMap = list.get(list.indexOf(map)-1);
      map.removeActor(actor);
      currentMap.addActor(actor, currentMap.at(current_x,24));
      // Check if above has an actor already
    }
    else {
      GameMap currentMap = list.get(list.indexOf(map)+1);
      map.removeActor(actor);
      currentMap.addActor(actor, currentMap.at(current_x,0));

    }
    return "Player moved to a different map";
  }
  /**
   * Describe the action in a format suitable for displaying in the menu.
   * i.e what map there moving to
   * @see Action#menuDescription(Actor)
   * @param actor The actor performing the action.
   * @return a string, e.g. "Player picks up the rock"
   */
  @Override
  public String menuDescription(Actor actor) {
    if (goTop)
    return "Player moves to North Map";
    return "Player moves to South Map";
  }
}

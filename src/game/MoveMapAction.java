package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;
import java.util.ArrayList;

public class MoveMapAction extends Action {
  private WorldModified worldModified;
  private Boolean goTop ;
  public MoveMapAction(WorldModified worldModified, Boolean goTop){
    this.worldModified = worldModified;
    this.goTop = goTop;

  }

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

  @Override
  public String menuDescription(Actor actor) {
    if (goTop)
    return "Player moves to North Map";
    return "Player moves to South Map";
  }
}

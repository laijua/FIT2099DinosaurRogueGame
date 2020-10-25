package game;

import edu.monash.fit2099.engine.Action;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.GameMap;

public class ModeAction extends Action {
  private Enum<?> modeType;


  public ModeAction(Enum<?> modeType){
    this.modeType = modeType;

  }

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

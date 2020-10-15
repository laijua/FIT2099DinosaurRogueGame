package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;
import edu.monash.fit2099.engine.PickUpItemAction;

public class Grass extends Ground {

  public Grass() {
    super('G');
  }

  @Override
  public void tick(Location location) {

//    for (exits:location.getExits()){
//      System.out.println(exits);
//    }

  }
//  public PickUpItemAction getPickUpAction() {
//    if(portable)
//      return new PickUpItemAction(this);
//
//    return null;
//  }
}

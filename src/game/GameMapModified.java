package game;

import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.GroundFactory;
import edu.monash.fit2099.engine.Location;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class GameMapModified extends GameMap {
  private Ecopoints ecopoints;
  private Integer grassGrown = 0;

  public GameMapModified(GroundFactory groundFactory, List<String> lines) {
    super(groundFactory,lines);
    beginnngGrowGrass(groundFactory, lines);
  }

  /**
   * Converts all dirt a chance for it to be grown into Grass at the beginning of the game.
   *
   * @param groundFactory Factory to create Ground objects
   * @param lines         List of Strings representing rows of the map
   */
  private void beginnngGrowGrass(GroundFactory groundFactory, List<String> lines) {
    int width = lines.get(0).length();
    int height = lines.size();
    initMap(width, height);

    for (int x : widths) {
      for (int y : heights) {
        char groundChar = lines.get(y).charAt(x);
        if (groundChar == '.' && Math.random()<0.02){

          at(x, y).setGround(groundFactory.newGround('G'));
          grassGrown++;

        }else
          at(x, y).setGround(groundFactory.newGround(groundChar));
      }
    }
  }

  /**
   * Grabs reference to Ecopoints through the World Class
   * @param ecopoints
   */
  public void initializeEcopoints(Ecopoints ecopoints){
    this.ecopoints = ecopoints;
    this.ecopoints.addEcopoints(grassGrown);
  }

  /**
   * Increases Ecopoints balance
   * @param val Integer added onto the current ecopoints balance
   */
  public void increaseEcopoints(Integer val) {
    this.ecopoints.addEcopoints(val);
  }

  /**
   * Getters methods that returns the total amount of ecopoints balance the current player has
   * @return Integer Value representing the current balance
   */
  public Integer getEcopoints(){
    return ecopoints.getEcopoints();
  }
}

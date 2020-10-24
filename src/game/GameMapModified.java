package game;

import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.GroundFactory;
import java.util.List;

public class GameMapModified extends GameMap {
  private Ecopoints ecopoints;
  private Integer grassGrown = 0;
  private Boolean topMap= false;

  public GameMapModified(GroundFactory groundFactory, List<String> lines,Boolean topMap) {
    super(groundFactory,lines);
    beginnngGrowGrass(groundFactory, lines);
    this.topMap = topMap;
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

  /**
   * Tells us whether or not we are in the top map or not.
   * @return
   */
  public Boolean isTopMap() {
    return topMap;
  }
}

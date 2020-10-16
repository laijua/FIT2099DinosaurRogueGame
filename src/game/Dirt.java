package game;

import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

/**
 * A class that represents bare dirt.
 */
public class Dirt extends Ground {
	private final  double GRASSGROWNNEXTTOTREE = 0.02;
	private final  double GRASSGROWNOTHERGRASS = 0.1;
	/**
	 * Constructor.
	 * Ground type with display char of . to indicate its dirt
	 *
	 */
	public Dirt() {
		super('.');
	}


	/**
	 * Has a chance to grow grass if surrounded by 2 grass, every turn
	 *
	 * @param location The location of the Ground
	 */
	@Override
	public void tick(Location location) {
		Integer counter = 0;
		for(Exit exit:location.getExits()){
			if (exit.getDestination().getGround() instanceof Grass){
				counter ++;
			}
			if (counter ==2 && Math.random()<GRASSGROWNOTHERGRASS){
				((GameMapModified)location.map()).increaseEcopoints(1);
				location.setGround(new Grass());
				break;
			}
			if(exit.getDestination().getGround() instanceof Tree && Math.random()<GRASSGROWNNEXTTOTREE){
				location.setGround(new Grass());
				break;
			}


		}
	}
}

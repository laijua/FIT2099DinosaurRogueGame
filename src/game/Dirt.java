package game;

import edu.monash.fit2099.engine.Exit;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Location;

/**
 * A class that represents bare dirt.
 */
public class Dirt extends Ground {

	public Dirt() {
		super('.');
	}

	@Override
	public void tick(Location location) {

		//System.out.println(location.getExits());
		Integer counter = 0;
		for(Exit exit:location.getExits()){
			if (exit.getDestination().getGround() instanceof Grass){
				counter ++;
			}
			if (counter ==2 && Math.random()<0.1){
//				System.out.println("set Ground" + location.x()+" "+ location.y()+" "+counter+" "+test);
				location.setGround(new Grass());
				// No point continuing with the for loop
				break;
			}
			if(exit.getDestination().getGround() instanceof Tree && Math.random()<0.02){
				location.setGround(new Grass());
				break;
			}

			//System.out.println('j');

		}
	}
}

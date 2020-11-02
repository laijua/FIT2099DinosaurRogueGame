package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

/**
 * A class that represents a type ground that can be seen in the map
 */
public class Tree extends Ground {
	private final double DROPFRUITPERCENT = 0.1;
	private int age = 0;
	public Tree() {
		super('+');
		this.addCapability(GameCapability.DROPFRUIT);
	}

	/**
	 * A chance to Drop Fruit, a decays a fruit if it already exists and ages Trees depending on
	 * its age
	 * @param location The location of the Ground
	 */
	@Override
	public void tick(Location location) {
		super.tick(location);

		age++;
		if (age == 10)
			displayChar = 't';
		if (age == 20)
			displayChar = 'T';




		if (this.hasCapability(GameCapability.DROPFRUIT) && Math.random()<DROPFRUITPERCENT){
			Fruit fruit = new Fruit("Fruit",'F',true);
			location.addItem(fruit);
			this.removeCapability(GameCapability.DROPFRUIT);
		}
	}
}




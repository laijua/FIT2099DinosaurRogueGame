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
	private boolean droppedFruit = false;
	public Tree() {
		super('+');
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

		if (droppedFruit) {
			for (Integer i = 0;i<location.getItems().size();i++) {
				Item item = location.getItems().get(i);
				if (item instanceof Fruit) {
					((Fruit) item).decayFruit();
					if (((Fruit) item).getDecay() == 0) {
						location.removeItem(item);
						droppedFruit = false;
					}
				}
			}
		}
		if (!droppedFruit && Math.random()<DROPFRUITPERCENT){
			Fruit fruit = new Fruit("Fruit",'F',true);
			location.addItem(fruit);
			droppedFruit = true;
		}
	}
}




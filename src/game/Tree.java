package game;

import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;

public class Tree extends Ground {
	private int age = 0;
	private boolean droppedFruit = false;
	public Tree() {
		super('+');
	}

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
//				System.out.println("test");
				if (item instanceof Fruit) {
					((Fruit) item).decayFruit();
//					System.out.println("Time until Fruit Decayed:" + ((Fruit) item).getDecay()+", x= "+location.x()+"y= "+location.y());
					if (((Fruit) item).getDecay() == 0) {
						location.removeItem(item);
						droppedFruit = false;
					}
				}
			}
		}
		if (!droppedFruit && Math.random()<0.1){
			Fruit fruit = new Fruit(10,"Fruit",'F',true);
			location.addItem(fruit);
			droppedFruit = true;
		}
	}
}

//		if (Math.random()<0.05 && location.getItems().){
//
//		}


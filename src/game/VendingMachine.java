package game;

import edu.monash.fit2099.engine.Actions;
import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Ground;
import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.Location;
import java.util.HashMap;

public class VendingMachine extends Ground {

  /**
   * Constructor.
   *
   *
   */
  public VendingMachine() {
    super('V');
  }

  @Override
  public Actions allowableActions(Actor actor, Location location, String direction) {
    Actions actions = new Actions();
//    ArrayList<Item> sellableItems = new ArrayList<>();
//
//    sellableItems.add(new Egg(new Allosaur("Allosaur",10,1,Math.random()<0.5?true:false)));
//    sellableItems.add(new Egg(new Stegosaur("Stegosaur",10,1,Math.random()<0.5?true:false)));
//    sellableItems.add(new VegetarianMealKit(100,"VegetarianMealKit",'M',true));
//    sellableItems.add(new CarnivoreMealKit(100,"CarnivoreMealKit",'M',true));
//    sellableItems.add(new Hay());
//    sellableItems.add(new Fruit(10,"Fruit",'F',true));
//    sellableItems.add(new LaserGun("LaserGun",'L',100,"shoots"));

    HashMap<Item,Integer> prices = new HashMap<>();
    prices.put(new Egg(new Allosaur("Allosaur",10,1,Math.random()<0.5?true:false)),100);
    prices.put(new Egg(new Stegosaur("Stegosaur",10,1,Math.random()<0.5?true:false)),200);
    prices.put(new VegetarianMealKit(100,"VegetarianMealKit",'M',true),100);
    prices.put(new CarnivoreMealKit(100,"CarnivoreMealKit",'M',true),500);
    prices.put(new Hay(),20);
    prices.put(new Fruit(10,"Fruit",'F',true),30);
    prices.put(new LaserGun("LaserGun",'L',100,"shoots"),500);

    for(Item item :prices.keySet()){
      if (prices.get(item)< ((GameMapModified)location.map()).getEcopoints())
      actions.add(new BuyAction(item,prices.get(item)));
    }
    return actions;
  }
}

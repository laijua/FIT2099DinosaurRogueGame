package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;

/**
 * A herbivorous dinosaur.
 */
public class Stegosaur extends Dinosaur {
//    private static ArrayList<Behaviour> behaviour = new ArrayList<>();
//    private static Capabilities capabilities = new Capabilities();

    public Stegosaur(String name, int foodLevel, int turnAge, boolean male ) {
        super(name, foodLevel, turnAge, male, stegosaurBehaviour(), GameCapability.HERBIVOREEDIBLE, 'S');
        addCapability(GameCapability.ALLOSAURATTACKABLE);
        addCapability(GameCapability.CARNIVOREEDIBLE);
    }

//    private static ArrayList<Capabilities >stegosaurCapabilities(){
//        Capabilities capabilities = new Capabilities();
//        capabilities.addCapability(GameCapability.ALLOSAURATTACKABLE);
//        capabilities.addCapability(GameCapability.CARNIVOREEDIBLE);
//        return capabilities;
//    }

    private static ArrayList<Behaviour> stegosaurBehaviour(){
        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new WanderBehaviour());
//        behaviours.add(new SeekFoodBehaviour());
        return behaviours;
    }
}

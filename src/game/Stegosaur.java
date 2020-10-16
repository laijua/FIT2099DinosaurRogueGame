package game;

import edu.monash.fit2099.engine.*;

import java.util.ArrayList;

/**
 * A herbivorous dinosaur.
 */
public class Stegosaur extends Dinosaur {

    public Stegosaur(String name, int foodLevel, int turnAge, boolean male ) {
        super(name, foodLevel, turnAge, male, stegosaurBehaviour(), GameCapability.HERBIVOREEDIBLE, 'S');
        addCapability(GameCapability.ALLOSAURATTACKABLE);
        addCapability(GameCapability.CARNIVOREEDIBLE);
    }

    private static ArrayList<Behaviour> stegosaurBehaviour(){
        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new SeekFoodBehaviour());
        behaviours.add(new BreedingBehaviour());
        behaviours.add(new WanderBehaviour());
        return behaviours;
    }
}

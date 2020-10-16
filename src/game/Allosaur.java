package game;

import edu.monash.fit2099.engine.Capabilities;
import edu.monash.fit2099.engine.IntrinsicWeapon;

import java.util.ArrayList;

/**
 * A carnivorous dinosaur.
 */
public class Allosaur extends Dinosaur {

    public Allosaur(String name, int foodLevel, int turnAge, boolean male) {
        super(name, foodLevel, turnAge, male, allosaurBehaviour(), GameCapability.CARNIVOREEDIBLE, 'A');
    }

    private static ArrayList<Behaviour> allosaurBehaviour(){
        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new SeekFoodBehaviour());
        behaviours.add(new BreedingBehaviour());
        behaviours.add(new AttackBehaviour());
        behaviours.add(new WanderBehaviour());
        return behaviours;
    }

    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(40, "bites");
    }
}

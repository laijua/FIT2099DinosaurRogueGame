package game;

import edu.monash.fit2099.engine.IntrinsicWeapon;

import java.util.ArrayList;

public class Archaeopteryx extends Dinosaur {
    public Archaeopteryx(String name, int foodLevel, int turnAge, boolean male, int thirstLevel) {
        super(name, foodLevel, turnAge, male, archaeopteryxBehaviour(), archaeopteryxEdibleType(), 'C', 1000, thirstLevel, 10);
        addCapability(GameCapability.FLY);
    }

    /**
     * Method to input an array list of Archaeopteryx behaviours into the parent constructor
     *
     * @return an ArrayList of behaviours
     */
    private static ArrayList<Behaviour> archaeopteryxBehaviour() {
        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new SeekFoodBehaviour());
        behaviours.add(new ThirstBehaviour());
        behaviours.add(new BreedingBehaviour());
        behaviours.add(new AttackBehaviour());
        behaviours.add(new WanderBehaviour());
        return behaviours;
    }

    private static ArrayList<Enum<?>> archaeopteryxEdibleType() {
        ArrayList<Enum<?>> edibleTypes = new ArrayList<>();
        edibleTypes.add(GameCapability.CARNIVOREEDIBLE);
        return edibleTypes;
    }

    /**
     * Returns the weapon available for the Archaeopteryx
     *
     * @return Returns the weapon available for the Archaeopteryx
     */
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(20, "claws");
    }

}

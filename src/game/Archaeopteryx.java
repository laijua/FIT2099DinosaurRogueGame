package game;

import edu.monash.fit2099.engine.IntrinsicWeapon;

import java.util.ArrayList;

/**
 * An Archaeopteryx, a carnivorous dinosaur.
 */
public class Archaeopteryx extends Dinosaur {
    
    /**
     * Constructs an Archaeopteryx
     *
     * @param name        String to name the Archaeopteryx
     * @param foodLevel   Int representing food level of Archaeopteryx
     * @param turnAge     Int representing age of Archaeopteryx
     * @param male        Boolean to tell if Archaeopteryx is male or not
     * @param thirstLevel Int representing thirst level of Archaeopteryx
     */
    public Archaeopteryx(String name, int foodLevel, int turnAge, boolean male, int thirstLevel) {
        super(name, foodLevel, turnAge, male, archaeopteryxBehaviour(), archaeopteryxEdibleType(), 'X', 1000, thirstLevel, 10, GameCapability.TIERTWOATTACKABLE);
        addCapability(GameCapability.FLY);
        addCapability(GameCapability.TIERONEATTACKABLE);
        addCapability(GameCapability.TIERTWOATTACKABLE);
        addCapability(GameCapability.CARNIVOREEDIBLE);
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

    /**
     * Method to input an array list of Archaeopteryx diet type
     *
     * @return an ArrayList of Enum representing edible types
     */
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

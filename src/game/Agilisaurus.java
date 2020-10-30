package game;

import edu.monash.fit2099.engine.IntrinsicWeapon;

import java.util.ArrayList;

/**
 * An Agilisaurus, a omnivorous dinosaur.
 */
public class Agilisaurus extends Dinosaur {

    /**
     * Constructs an Agilisaurus
     *
     * @param name        String to name the Agilisaurus
     * @param foodLevel   Int representing food level of Agilisaurus
     * @param turnAge     Int representing age of Agilisaurus
     * @param male        Boolean to tell if Agilisaurus is male or not
     * @param thirstLevel Int representing thirst level of Agilisaurus
     */
    public Agilisaurus(String name, int foodLevel, int turnAge, boolean male, int thirstLevel) {
        super(name, foodLevel, turnAge, male, agilisaurusBehaviour(), agilisaurusEdibleType(), 'Z', 100, thirstLevel, 15, GameCapability.TIERTWOATTACKABLE);
        addCapability(GameCapability.TIERONEATTACKABLE);
        addCapability(GameCapability.TIERTWOATTACKABLE);
        addCapability(GameCapability.CARNIVOREEDIBLE);
    }

    /**
     * Method to input an array list of Agilisaurus behaviours into the parent constructor
     *
     * @return an ArrayList of behaviours
     */
    private static ArrayList<Behaviour> agilisaurusBehaviour() {
        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new SeekFoodBehaviour());
        behaviours.add(new ThirstBehaviour());
        behaviours.add(new BreedingBehaviour());
        behaviours.add(new AttackBehaviour());
        behaviours.add(new WanderBehaviour());
        return behaviours;
    }

    /**
     * Method to input an array list of Agilisaurus diet type
     *
     * @return an ArrayList of Enum representing edible types
     */
    private static ArrayList<Enum<?>> agilisaurusEdibleType() {
        ArrayList<Enum<?>> edibleTypes = new ArrayList<>();
        edibleTypes.add(GameCapability.HERBIVOREEDIBLE);
        edibleTypes.add(GameCapability.CARNIVOREEDIBLE);
        return edibleTypes;
    }

    /**
     * Returns the weapon available for the Agilisaurus
     *
     * @return Returns the weapon available for the Agilisaurus
     */
    protected IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(25, "bites");
    }

}

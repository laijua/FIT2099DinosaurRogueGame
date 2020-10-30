package game;

import java.util.ArrayList;

/**
 * An Stegosaur, a herbivorous dinosaur.
 */
public class Stegosaur extends Dinosaur {
    /**
     * Constructs an Stegosaur
     *
     * @param name        String to name the Stegosaur
     * @param foodLevel   Int representing food level of Stegosaur
     * @param turnAge     Int representing age of Stegosaur
     * @param male        Boolean to tell if Stegosaur is male or not
     * @param thirstLevel Int representing thirst level of Stegosaur
     */
    public Stegosaur(String name, int foodLevel, int turnAge, boolean male, int thirstLevel) {
        super(name, foodLevel, turnAge, male, stegosaurBehaviour(), stegosaurEdibleType(), 'S', 100, thirstLevel, 45, GameCapability.PASSIVE);
        addCapability(GameCapability.TIERONEATTACKABLE);
        addCapability(GameCapability.CARNIVOREEDIBLE);
    }

    /**
     * Method to input an array list of Stegosaur behaviours into the parent constructor
     *
     * @return an ArrayList of behaviours
     */
    private static ArrayList<Behaviour> stegosaurBehaviour() {
        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new SeekFoodBehaviour());
        behaviours.add(new ThirstBehaviour());
        behaviours.add(new BreedingBehaviour());
        behaviours.add(new WanderBehaviour());
        return behaviours;
    }

    /**
     * Method to input an array list of Stegosaur diet type
     *
     * @return an ArrayList of Enum representing edible types
     */
    private static ArrayList<Enum<?>> stegosaurEdibleType() {
        ArrayList<Enum<?>> edibleTypes = new ArrayList<>();
        edibleTypes.add(GameCapability.HERBIVOREEDIBLE);
        return edibleTypes;
    }
}

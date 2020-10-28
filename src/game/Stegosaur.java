package game;

import java.util.ArrayList;

/**
 * A herbivorous dinosaur.
 */
public class Stegosaur extends Dinosaur {
    /**
     * Constructor for the Stegosaur
     *
     * @param name      name of the Stegosaur in String
     * @param foodLevel food level of the Stegosaur in int
     * @param turnAge   age of the Stegosaur in int
     * @param male      boolean to determine gender of the Stegosaur
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

    private static ArrayList<Enum<?>> stegosaurEdibleType() {
        ArrayList<Enum<?>> edibleTypes = new ArrayList<>();
        edibleTypes.add(GameCapability.HERBIVOREEDIBLE);
        return edibleTypes;
    }
}

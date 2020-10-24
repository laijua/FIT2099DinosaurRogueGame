package game;

import java.util.ArrayList;

/**
 * A herbivorous dinosaur.
 */
public class Stegosaur extends Dinosaur {
    /**
     * Constructor for the Stegosaur
     * @param name name of the Stegosaur in String
     * @param foodLevel food level of the Stegosaur in int
     * @param turnAge age of the Stegosaur in int
     * @param male boolean to determine gender of the Stegosaur
     */
    public Stegosaur(String name, int foodLevel, int turnAge, boolean male ) {
        super(name, foodLevel, turnAge, male, stegosaurBehaviour(), GameCapability.HERBIVOREEDIBLE, 'S',100);
        addCapability(GameCapability.CARNIVOREATTACKABLE);
        addCapability(GameCapability.CARNIVOREEDIBLE);
    }

    /**
     * Method to input an array list of Stegosaur behaviours into the parent constructor
     *
     * @return an ArrayList of behaviours
     */
    private static ArrayList<Behaviour> stegosaurBehaviour(){
        ArrayList<Behaviour> behaviours = new ArrayList<>();
        behaviours.add(new SeekFoodBehaviour());
        behaviours.add(new BreedingBehaviour());
        behaviours.add(new WanderBehaviour());
        return behaviours;
    }
}

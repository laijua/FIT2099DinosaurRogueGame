package game;

import edu.monash.fit2099.engine.Item;
import edu.monash.fit2099.engine.PickUpItemAction;

import java.util.ArrayList;

/**
 * A class that represents an Item that is edible to the dinosaurs
 */
public abstract class Food extends Item {
    private int foodLevelPoint;
    private double percentPickUp = 1.5;
    private int ecopoints = 0;

    /**
     * Constructor.
     * Params for the Item constructor, foodlevelpoints indicate how much should it replenish the dinosaur
     *
     * @param foodLevelPoint Integer replenishing Dinosaur amount
     * @param name           Name of the Food
     * @param displayChar    Char that represents the food
     * @param portable       IF it is portable or if it is not
     * @param ecopoints      represents how much it is worth
     */
    public Food(int foodLevelPoint, String name, char displayChar, boolean portable, Integer ecopoints) {
        super(name, displayChar, portable);
        this.foodLevelPoint = foodLevelPoint;
        this.ecopoints = ecopoints;

    }

    /**
     * Constructor.
     * Params for the Item constructor, foodlevelpoints indicate how much should it replenish the dinosaur
     *
     * @param foodLevelPoint Integer replenishing Dinosaur amount
     * @param name           Name of the Food
     * @param displayChar    Char that represents the food
     * @param portable       IF it is portable or if it is not
     */
    public Food(int foodLevelPoint, String name, char displayChar, boolean portable) {
        super(name, displayChar, portable);
        this.foodLevelPoint = foodLevelPoint;
    }

    /**
     * Constructor.
     * Similar to the constructor above, but with another param percentPickUp, which fails to pick up item
     *
     * @param percentPickUp Double that represents the chances of picking up an Item
     */
    public Food(int foodLevelPoint, String name, char displayChar, boolean portable, double percentPickUp, Integer ecopoints) {
        super(name, displayChar, portable);
        this.foodLevelPoint = foodLevelPoint;
        this.percentPickUp = percentPickUp;
        this.ecopoints = ecopoints;
    }

    /**
     * There is is a chance that picking up an Food item might fail, which returns a different Action
     *
     * @return an Action that either Picks up item or does not
     */
    @Override
    public PickUpItemAction getPickUpAction() {
        if (portable && Math.random() < percentPickUp)
            return new PickUpItemAction(this);
        return new FailPickUpItemAction(this);
    }

    /**
     * Simpler Getter that tells us how much it replrenish the animals
     *
     * @return Integer Val
     */
    public int getFoodLevelPoint() {
        return foodLevelPoint;
    }

    /**
     * Simply Getting for adding onto to current ecopoints balance.
     *
     * @return Integer Value of ecopoints
     */
    public int getEcopoints() {
        return ecopoints;
    }

    /**
     * method to check if food can be eaten by dinosaur
     * @param edibleTypes the type the dinosaur eats
     * @return true if it can be eaten, false otherwise
     */
    public boolean canBeEaten(ArrayList<Enum<?>> edibleTypes) {
        for (Enum<?> edibleType : edibleTypes) {
            if (super.hasCapability(edibleType)) {
                return true;
            }
        }
        return false;
    }
}


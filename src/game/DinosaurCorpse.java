package game;

/**
 * Class for a dead dinosaur that is now edible by carnivores.
 */
public class DinosaurCorpse extends Food {
    /**
     * * Constructor for the food
     * @param foodLevelPoint food level the corpse is worth, varies depending on the type of dinosaur dying
     */
    public DinosaurCorpse(int foodLevelPoint) {
        super(foodLevelPoint, "corpse", 'C', true);
        addCapability(GameCapability.CARNIVOREEDIBLE);
    }
}

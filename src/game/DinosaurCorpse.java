package game;

/**
 * Class for a dead dinosaur that is now edible by carnivores.
 */
public class DinosaurCorpse extends Food {
    /**
     * Constructor for the food
     */
    public DinosaurCorpse() {
        super(50, "corpse", 'C', true);
        addCapability(GameCapability.CARNIVOREEDIBLE);
    }
}

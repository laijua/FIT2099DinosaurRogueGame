package game;

public class DinosaurCorpse extends Food {
    public DinosaurCorpse() {
        super(30, "corpse", 'C', true);
        addCapability(GameCapability.CARNIVOREEDIBLE);
    }
}

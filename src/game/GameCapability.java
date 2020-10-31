package game;

/**
 * Capabilities within the game
 */
public enum GameCapability {
    CARNIVOREEDIBLE,
    HERBIVOREEDIBLE,
    TIERONEATTACKABLE,
    TIERTWOATTACKABLE,
    PASSIVE,
    FLY,
    CHALLENGEMODE,
    SANDBOXMODE,
    QUITMODE,
    BREED, // used for reason to breed in findDinosaur
    ATTACK // used for reason to attack in findDinosaur
}
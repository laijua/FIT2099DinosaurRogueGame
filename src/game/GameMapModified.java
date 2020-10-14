package game;

import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.GroundFactory;
import edu.monash.fit2099.engine.Location;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class GameMapModified extends GameMap {

    public GameMapModified(GroundFactory groundFactory, char groundChar,
                           int width,
                           int height) {
        super(groundFactory, groundChar, width, height);
    }

    public GameMapModified(GroundFactory groundFactory, List<String> lines) {
        super(groundFactory,lines);

        beginnngGrowGrass(groundFactory, lines);
    }

    public GameMapModified(GroundFactory groundFactory, String mapFile) throws IOException {
        super(groundFactory, mapFile);
    }

    /**
     * Converts all dirt a chance for it to be grown into Grass at the beginning of the game.
     *
     * @param groundFactory Factory to create Ground objects
     * @param lines         List of Strings representing rows of the map
     */
    private void beginnngGrowGrass(GroundFactory groundFactory, List<String> lines) {
        int width = lines.get(0).length();
        int height = lines.size();
        initMap(width, height);

        for (int x : widths) {
            for (int y : heights) {
                char groundChar = lines.get(y).charAt(x);
                if (groundChar == '.' && Math.random()<0.02){
                    at(x, y).setGround(groundFactory.newGround('G'));
                }else
                    at(x, y).setGround(groundFactory.newGround(groundChar));
            }
        }
    }


}
package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.Actor;
import edu.monash.fit2099.engine.Display;
import edu.monash.fit2099.engine.FancyGroundFactory;
import edu.monash.fit2099.engine.GameMap;
import edu.monash.fit2099.engine.World;

/**
 * The main class for the Jurassic World game.
 *
 */
public class Application {

	public static void main(String[] args) {

		WorldModified world = new WorldModified(new Display());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Tree(),new Grass());
		
		List<String> map = Arrays.asList(
		"................................................................................",
		"................................................................................",
		".....#######....................................................................",
		".....#_____#....................................................................",
		".....#_____#....................................................................",
		".....###G###....................................................................",
		"................................................................................",
		"......................................+++.......................................",
		".......................................++++.....................................",
		"...................................+++++........................................",
		".....................................++++++.....................................",
		"......................................+++.......................................",
		".....................................+++........................................",
		"................................................................................",
		"............+++.................................................................",
		".............+++++..............................................................",
		"...............++........................................+++++..................",
		".............+++....................................++++++++....................",
		"............+++.......................................+++.......................",
		"................................................................................",
		".........................................................................++.....",
		"........................................................................++.++...",
		".........................................................................++++...",
		"..........................................................................++....",
		"...............................................................................+");
		GameMapModified gameMap = new GameMapModified(groundFactory, map );
		world.addGameMap(gameMap);
		
		Actor player = new Player("Player", '@', 100);
		world.addPlayer(player, gameMap.at(9, 4));
		
		// Place a pair of stegosaurs in the middle of the map
//		gameMap.at(30, 12).addActor(new Stegosaur("Stegosaur",50 , 10, true));
//		gameMap.at(32, 12).addActor(new Stegosaur("Stegosaur", 50, 10, false));
//		gameMap.at(33, 12).addActor(new Allosaur("Allosaur", 3, 10, false));
		gameMap.at(8, 7).addActor(new Stegosaur("Allosaur", 3, 10, false));

		gameMap.at(8,4).addItem(new Egg(new Stegosaur("Allosaur",3,10,false)));
		gameMap.at(10,4).setGround(new VendingMachine());

		gameMap.at(30, 12).addActor(new Stegosaur("Stegosaur",99 , 50, true));
		gameMap.at(32, 12).addActor(new Stegosaur("Stegosaur", 99, 50, false));
		gameMap.at(32, 2).addActor(new Stegosaur("Stegosaur", 10, 50, false));


//		gameMap.at(30,10).addItem(new Fruit(10, "Fruit", 'F', true));
//		gameMap.at(30,10).setGround(new Grass());
//		gameMap.at(30, 12).addActor(new Stegosaur("Stegosaur",14 , 10, true));
//		gameMap.at(32, 12).addActor(new Stegosaur("Stegosaur", 14, 10, false));
//		gameMap.at(36, 12).addActor(new Allosaur("Allosaur", 14, 10, false));
//		gameMap.at(38,20).addItem(new Egg(new Allosaur("Allosaur",3,10,false)));
//		gameMap.at(36,10).addItem(new Egg(new Allosaur("Allosaur",3,10,false)));
//
//
//		gameMap.at(79,24).addItem(new Egg(new Stegosaur("Allosaur",3,10,false)));
//		gameMap.at(79, 24).addActor(new Stegosaur("Stegosaur", 100, 10, false));
//



		world.run();
	}
}

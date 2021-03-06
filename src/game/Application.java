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

		WorldModified world = new WorldModified(new DisplayModified());

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new Tree(),new Grass(),new Water());
		
		List<String> map = Arrays.asList(
		"................................................................................",
		"................................................................................",
		".....#######....................................................................",
		".....#_____#..............................................~~~~..................",
		".....#_____#..............................................~~~~..................",
		".....###G###..............................................~~~~..................",
		"................................................................................",
		"......................................+++.......................................",
		"...........~~~~........................++++.....................................",
		"...........~~~~....................+++++........................................",
		"...........~~~~......................++++++.....................................",
		"......................................+++.....................~~~~..............",
		".....................................+++......................~~~~..............",
		"..............................................................~~~~..............",
		"............+++.................................................................",
		".............+++++..............................................................",
		"...............++........................................+++++..................",
		".............+++....................................++++++++....................",
		"............+++..................~~~~.................+++.......................",
		".................................~~~~...........................................",
		".................................~~~~....................................++.....",
		"........................................................................++.++...",
		".........................................................................++++...",
		"..........................................................................++....",
		"...............................................................................+");
		List<String> topmap = Arrays.asList(
				"................................................................................",
				"................................................................................",
				".....#######....................................~~~~~~~~~~~~~~..................",
				".....#_____#....................................~~~~~~~~~~~~~~..................",
				".....#_____#....................................~~~~~~~~~~~~~~..................",
				".....###G###....................................................................",
				"................................................................................",
				"......................................+++.......................................",
				".......................................++++.....................................",
				"...................................+++++........................................",
				".....................................++++++.....................................",
				"................................................................................",
				"................................................................................",
				"........~~~~~~~.............................~~~~~~~.............................",
				"........~~~~~~~.............................~~~~~~~.............................",
				"........~~~~~~~.............................~~~~~~~.............................",
				"........~~~~~~~.............................~~~~~~~.............................",
				"................................................................................",
				"................................................................................",
				"................................................................................",
				".........................................~~~~~~~~~~~~~~~~~~~~~~~~~~~~...........",
				".........................................~~~~~~~~~~~~~~~~~~~~~~~~~~~~...........",
				".........................................~~~~~~~~~~~~~~~~~~~~~~~~~~~~...........",
				"................................................................................",
				"......G.........................................................................");
		GameMapModified gameMap = new GameMapModified(groundFactory, map,false );

		GameMapModified topgameMap = new GameMapModified(groundFactory, topmap,true );

		world.addGameMap(topgameMap);
		world.addGameMap(gameMap);
		
		Actor player = new Player("Player", '@', 100);
		world.addPlayer(player, gameMap.at(9, 0));
		

		gameMap.at(27,12).setGround(new VendingMachine());
		gameMap.at(54,13).setGround(new VendingMachine());

		topgameMap.at(30, 12).addActor(new Stegosaur("Stegosaur",50 , 50, true, 50));
		topgameMap.at(32, 12).addActor(new Stegosaur("Stegosaur", 50, 50, false, 50));

		topgameMap.at(27,12).setGround(new VendingMachine());
		topgameMap.at(54,13).setGround(new VendingMachine());

		gameMap.at(30, 12).addActor(new Stegosaur("Stegosaur",50 , 50, true, 50));
		gameMap.at(32, 12).addActor(new Stegosaur("Stegosaur", 50, 50, false, 50));

		world.run();
	}
}

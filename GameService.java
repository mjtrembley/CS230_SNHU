package com.gamingroom;

import java.util.ArrayList;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	// task 1 completed
	// The singleton pattern is a way to create 1 instance of an object. It involves a single class which creates an object, 
	//while only ONE single object gets created. It provides a way to access its only object without needing to instantiate the object of the class.
	//the purpose of this pattern in this application is to provide 1 instance of a game, and to be able to prove that it exists when a new game is started.
	private static GameService instance = new GameService();
		private GameService() {}
		
		public static GameService getInstance() {
			return instance;
		}
		public void showMessage() {
			System.out.println("I am a singleton! I hope!");
		}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// task 5 completed
		//uses an iterator to add a new game, if game exists, it will start the existing game.
		if (getGame(name) != null) {
			game = getGame(name);
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;
		
		// Goes through list of games and checks to see if there is an instance of it. If there is, it will return game with specified id.
		for (int i=0; i < getGameCount(); ++i) {
			if (games.get(i).getId() == id) {
				game = games.get(i);
			}
			
		}
			
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// iterates through existing games and returns the game instance with the specified name
		for (int i = 0; i < getGameCount(); i++) {
			if (games.get(i).getName() == name) {
				game = games.get(i);
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}

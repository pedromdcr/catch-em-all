package com.premiumminds.challenge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CatchEmAll {
	
	public static void main(String[] args) {
		
		CatchEmAll adventure = new CatchEmAll();
		
		Player ash = new Player();
		
		// Ash checks his map to find the path of his journey
		char[] steps = adventure.checkTrainerMap();
		
		try {
			// Ash begins to explore the world of Pokemon to catch 'em all
			adventure.exploreWorld(ash, steps);
			System.out.print(ash.getNumPokemon());
		} catch(InvalidDirectionException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public char[] checkTrainerMap() {
		
		// Ash is too excited to *scan* the map... he just wants a quick read!
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String movementSequence;
		try {
			movementSequence = reader.readLine();
		} catch (IOException e) {
			throw new RuntimeException(
				"Ash couldn't read the map... give him a break, he's 10 years old... always!", e);				
		}
		if(movementSequence != null)
			return movementSequence.toCharArray();
		else return null;
	}
	
	public void exploreWorld(Player player, char[] pathToTake) {
		
		if(pathToTake != null) {
			Coordinate location = null;
			for(int i = 0; i < pathToTake.length; i++) {
				
				if(pathToTake[i] == 'N')
					location = player.moveNorth();
				else if(pathToTake[i] == 'S')
					location = player.moveSouth();
				else if(pathToTake[i] == 'E')
					location = player.moveEast();
				else if(pathToTake[i] == 'O')
					location = player.moveWest();
				else throw new InvalidDirectionException(
					"Ash is confused! The path must only contain the letters N, S, E and O for directions!");
				
				if(!player.isVisitingOldLocation(location)) {
					player.catchPokemon(location);
				}
			}
		}
		
	}

}

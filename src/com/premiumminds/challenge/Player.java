package com.premiumminds.challenge;

import java.util.HashMap;

public class Player {

	private Coordinate position;
	private int numPokemon;
	private HashMap<String, Boolean> visitedLocations;

	public Player() {
		this.position = new Coordinate(0, 0);
		this.numPokemon = 1;
		this.visitedLocations = new HashMap<>();
		this.visitedLocations.put("0;0", true);
	}
	
	public Coordinate moveNorth() {
		position.setY(position.getY() + 1);
		return position;
	}
	public Coordinate moveSouth() {
		position.setY(position.getY() - 1);
		return position;
	}
	public Coordinate moveWest() {
		position.setX(position.getX() - 1);
		return position;
	}
	public Coordinate moveEast() {
		position.setX(position.getX() + 1);
		return position;
	}
	
	public void catchPokemon(Coordinate location) {
		numPokemon = numPokemon + 1;
		String s = location.getX() + ";" + location.getY();
		this.visitedLocations.put(s, true);
	}

	public boolean isVisitingOldLocation(Coordinate location) {
		String s = location.getX() + ";" + location.getY();
		return this.visitedLocations.containsKey(s);
	}
	
	// Getters
	public Coordinate getPosition() {
		return position;
	}
	
	public int getNumPokemon() {
		return numPokemon;
	}

	public HashMap<String, Boolean> getVisitedLocations() {
		return this.visitedLocations;
	}
}

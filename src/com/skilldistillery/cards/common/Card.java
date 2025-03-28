package com.skilldistillery.cards.common;

import java.util.Objects;

public class Card {
//fields
	private Suit suit;
	private Rank rank;

//Constructors
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	//getters/setters
	public int getValue() {
		return rank.getValue();
	}
	//other methods

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}
	@Override
	public String toString() {
		return (rank + " of " + suit);
	}
	
}

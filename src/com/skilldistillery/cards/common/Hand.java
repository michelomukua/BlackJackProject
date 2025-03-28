package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	
	// NO GETTER for CardsInHand
	// whoever wants to use the card must call the method...
	//public void addCard(Card card) {
	//}
	
	protected List<Card> cardsInHand;
	
	public Hand() {
		cardsInHand = new ArrayList<>();
	}
	
	public void addCard(Card card) {
		cardsInHand.add(card);
		
	}
	public void clear() {
		//cardsInHand = new ArrayList<>();
		cardsInHand.clear();
	}
	public abstract int getHandValue();

	@Override
	public String toString() {
		return "Hand [cardsInHand =" + cardsInHand;
	}
}

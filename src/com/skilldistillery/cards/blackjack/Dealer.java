package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Dealer extends Player {

	// NO MORE FIELDS
	// NO GETTER FOR THE DECK

	private Deck deck;

	public Dealer() {
		super();
		deck = new Deck();
	}

	public Card dealCard() {
		return deck.dealCard();
		
	}
	
	public void shuffleCards() {
		deck.shuffle();
	}
	
	public int deckSize() {
		return deck.checkDeckSize();
	}

}

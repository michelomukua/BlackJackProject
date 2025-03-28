package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;

public class Player {

	// NO MORE FIELDS
	// NO GETTER FOR THE HAND

	protected BlackjackHand hand;

	public Player() {
		hand = new BlackjackHand();
	}

	public void hit(Card card) {
		this.hand.addCard(card);
	}

	public int getHandValue() {
		// TOD FINISH
		return 0;
	}
}

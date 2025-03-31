package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Hand;

public class BlackjackHand extends Hand {

	@Override
	public int getHandValue() {
		int value = 0;
		
		for(Card card: cardsInHand) {			
			value = value + card.getValue();
		}		
		return value;
	}
	
	public int getHandSize() {
		return cardsInHand.size();
	}
	
	
	

	// NO FIELDS

}

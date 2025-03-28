package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	// DO NOT GENERATE A GETTER FOR CARDS

	// THE JOB OF THE DECK CLASS IS TO PROTECT THE CARDS.

	private List<Card> cards;

	public Deck() {
		cards = new ArrayList<>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card card = new Card(suit, rank);
				cards.add(card);
			}
		}
	}

	public int checkDeckSize() {
		return cards.size();
	}

	public Card dealCard() {
		return cards.remove(0);
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}
}

//	Create a class Deck. It will hold a List of Cards.
//	In the constructor, initialize the List with all 52 cards.
//	Add a method checkDeckSize which returns the number of cards still in the deck.
//	Add a method dealCard that removes a Card from the deck.
//	Add a method shuffle to shuffle the deck.

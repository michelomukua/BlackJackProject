# BlackJackProject
	This application used classes to create a working commandline blackjack game. The game was played by the Dealer and the Player. Each had a hand of cards.


## Overview
	A deck of cards was created by initializing an ArrayList of all 52 cards.
	Each card had a suit and a value. Collections.Shuffle method was used to shuffle the deck of cards.
	To start the blackjack round,  two cards each were dealt to the Player and the Dealer (who was also a player) as follows:
	- 1st card - face up (displayed) to Player
	- 2nd card - face down (not displayed) to Dealer
	- 3rd card - face up (displayed) to Player
	- 4th card - face up (displayed) to Dealer
	
	The value of cards at hand was calculated by adding up the point values of those held cards.
	The Player took turns hitting (H) or standing (S).
	If the Player’s hand exceeded 21, they automatically lost (or “busted”).
	Once the Players chose to stand, the Dealer’s face-down card was revealed. The Dealer then continued hitting until/ unless their hand value was 	17 or more. Then they had to Stand.
	The winner was then determined by comparing the value in the Player’s hand to that in the Dealer’s hand. The player with the hand closest to 21 without going over won. If the Dealer busted, the Player won automatically.





## Technologies / Concepts Used
	- Enum data type for constant classes of Suit and Rank
	- For loop
	- Boolean
	- Collections.shuffle for ArrayLists





## Lessons Learned
	



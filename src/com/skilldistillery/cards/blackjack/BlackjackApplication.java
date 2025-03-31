package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

import com.skilldistillery.cards.common.Card;

public class BlackjackApplication {

	// NO MORE FIELDS
	// NO DECK TYPE VARIABLES AT ALL

	private Scanner sc;
	private Dealer dealer;
	private Player player;
	private boolean skipDealerHitOrStand = false; 

	public BlackjackApplication() {
		this.sc = new Scanner(System.in);
		this.dealer = new Dealer();
		this.player = new Player();
	}

	public static void main(String[] args) {
		new BlackjackApplication().launch();
	}

	public void launch() {
		//Start a round and play more rounds if player chooses
		playBlackJackRound();
		while(playAnotherRound()) {
			playBlackJackRound();
		}		
	}
	
	
	public void playBlackJackRound() {
		skipDealerHitOrStand = false;  //boolean value to track if dealer shop hit or stand if player has already won
		dealer.shuffleCards();
		System.out.println(" Starting a round of BlackJack ....");
		System.out.println(" Dealing cards");
		System.out.println(" ==================================== ");
		System.out.println("                                      ");
		Card card = dealer.dealCard();
		System.out.println(" First Card to Player is : " + card.toString());
		player.hit(card);
		System.out.println(" Second Card to Dealer is : not displayed");
		dealer.hit(dealer.dealCard());
		card = dealer.dealCard();
		System.out.println(" Third Card to Player is : " + card.toString());
		player.hit(card);
		card = dealer.dealCard();
		System.out.println(" Fourth Card to Dealer is : " + card.toString());
		dealer.hit(card);
		playerHitOrStand();
		//skipDealerHitOrStand is true, skip dealer turn and evaluate winner		
		if(!skipDealerHitOrStand) {
			dealerHitOrStand();
		}
		evaluateWinner();
		
		System.out.println(" Cards in Deck  : " + dealer.deckSize());		
	}
	
	private void playerHitOrStand() {
		String option = "0";
		System.out.println("                                       ");		
		System.out.println(" =======Player Hit or Stand ============ ");
					
		while(!"S".equalsIgnoreCase(option)) {
			System.out.println(" Player's hand is :  " + player.hand.toString());
			System.out.println(" Player's hand value is :  " + player.getHandValue());
			//handle black jack
			//check if it a black jack or player hand has already exceeded 21
			if((isBlackJack(this.player)) || player.getHandValue() > 21	) {
				skipDealerHitOrStand = true;
				break;
			}
					
			System.out.println(" Select H for HIT or S for STAND ");
			option = sc.nextLine();
		
			if("H".equals(option.toUpperCase())) {
				player.hit(dealer.dealCard());
			}else if ("S".equals(option.toUpperCase())) {
				break;
			}else {
				System.out.println("Invalid selection please select H or S");
			}
		
		}
		
	}
	
	private boolean isBlackJack(Player player) {
		if(player.getHandValue() == 21 && player.hand.getHandSize() == 2) {
			return true;
		}else {
			return false;
		}
	}
	
	private void dealerHitOrStand() {
		
		System.out.println("                                       ");		
		System.out.println(" =======Dealer Hit or Stand ============ ");
			
		if(dealer.getHandValue() <= 16) {
			do {
				System.out.println(" Dealer has selected to Hit");
				dealer.hit(dealer.dealCard());
			}while(dealer.getHandValue() <= 16);
		}else {
			System.out.println(" Dealer has selected to Stand");
		}
		
			
		
	}
	
	private void evaluateWinner() {
		String results = "";
		System.out.println("                                         ");		
		System.out.println(" =======Evaluate Winner ================ ");
		
		if(isBlackJack(this.player) && !isBlackJack(this.dealer)) {
			results = " PLAYER WINS . Player wins with a BlackJack!!!!";
		}else if(!isBlackJack(this.player) && isBlackJack(this.dealer)){
			results = " DEALER WINS . Dealer wins with a BlackJack!!!!";
		}else if( player.getHandValue() > 21) {
			results = " DEALER WINS . Player Hand Value is greater than 21!";
		}else if(dealer.getHandValue() > 21) {
			results = " PLAYER WINS . Dealer Hand Value is greater than 21!";
		}else if(player.getHandValue() > dealer.getHandValue()) {
			results = " PLAYER WINS . Player's Hand Value is greater than Dealer's hand value!";
		}else if(dealer.getHandValue() > player.getHandValue()) {
			results = " DEALER WINS . Dealer's Hand Value is greater than Player's hand value!";
		}else {
			results = " This Round is a TIE!";
		}
		
		System.out.println(" Player's hand is :  " + player.hand.toString());
		System.out.println(" Player's hand value is :  " + player.getHandValue());
		System.out.println(" Dealer's hand is :  " + dealer.hand.toString());
		System.out.println(" Dealer's hand value is :  " + dealer.getHandValue());	
		System.out.println(results);
		
	}
	
	private boolean playAnotherRound() {
		boolean anotherRound = false;
		System.out.println("                                         ");		
		System.out.println(" Do you want to play another round ? Press Y for Yes or press any other key to Exit");
		String choice = sc.nextLine();
		
		
		if("Y".equalsIgnoreCase(choice)) {
			if( dealer.deckSize() <= 4) { //check size of the deck
				
				//TODO FIX ME for stretch goal. Code needed to eliminate out of bound exception when player continues to Hit while the number of cards in the Deck cannot sustain more hits.
				
				System.out.println("Cancelling Round. There is insufficeint number of cards in the deck for the next round");				
			}else {			
				player.hand.clear();
				dealer.hand.clear();
				anotherRound  = true;
			} 
		}else {
			System.out.println("Thanks for playing BlackJack. You are now exiting the Game");
		}
		return anotherRound;		
		
	}
	
}

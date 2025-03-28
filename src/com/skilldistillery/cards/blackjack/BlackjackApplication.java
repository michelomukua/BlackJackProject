package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class BlackjackApplication {
	
	// NO MORE FIELDS
	// NO DECK TYPE VARIABLES AT ALL
	
		private Scanner sc;
		private Dealer dealer;
		private Player player;
		
		public BlackjackApplication() {
			this.sc = new Scanner(System.in);
			this.dealer= new Dealer();
			this.player= new Player();
		}
		
	public static void main(String[] args) {
		new BlackjackApplication().launch();

	}
	public void launch( ) {
		
	}
}

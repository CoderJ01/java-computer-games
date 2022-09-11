package programmer.coderj.crazyeights;

import java.util.ArrayList;
import java.util.Random;

import programmer.coderj.cards.Card;
import programmer.coderj.cards.Deck;
import programmer.coderj.cards.Hand;
import programmer.coderj.mywindow.MyWindow;

public class CrazyEights extends MyWindow {
	
	private Deck deck = new Deck();
	private Hand myHand = new Hand();
	private Hand computerHand = new Hand();
	private Card discard;
	private ArrayList<Card> discardPile = new ArrayList<Card>();
	private Random rand = new Random();
	private char activeSuit = ' ';
	private int countHearts = 0;
	private int countDiamonds = 0;
	private int countClubs = 0;
	private int countSpades = 0;
	

	public CrazyEights() {
		// deal 7 cards to each of us
		for(int i = 0; i < 7; i++) {
			Card card1 = deck.deal();
			myHand.add(card1);
			Card card2 = deck.deal();
			computerHand.add(card2);
		}
		
		// turn up the discard
		discard = deal();
		
		// if the discard is an 8, set the active suit
		if(discard.getRank() == '8') {
			activeSuit = discard.getSuit();
		}
		else {
			activeSuit = ' ';
		}
		
		// who goes first?
		int turn = rand.nextInt(2);
		if(turn == 1) {
			print("Computer goes first");
			playComputerCard();
		}
		else {
			print("You go first");
		}
		
		// play until either of us runs out of cards
		boolean done = false;
		
		while(!done) {
			playMyCard();
			// are there any cards left in my hand
			if(myHand.size() == 0) {
				done = true;
			}
			else {
				playComputerCard();
				// are there any cards left in the computer hand?
				if(computerHand.size() == 0) {
					done = true;
				}
			}
		}
		
		print();
		// who played all their cards
		if(myHand.size() == 0) {
			print("Congratulations! You won! The computer has " + computerHand.size() + " cards.");
		}
		else {
			print("You lose.");
			print("My Hand: " + myHand.size());
			print("Discard: " + discard);
		}
	}

	public static void main(String[] args) {
		new CrazyEights();
	}
	
	private Card deal() {
		// if end of deck. reuse the discard pile and shuffle it.
		if(deck.size() == 0) {
			deck.reuse(discardPile);
			deck.shuffle();
			discardPile.clear();
			print();
			print("Reshuffled the discard pile.");
		}
		
		// deal a card from the deck
		Card card = deck.deal();
		return card;
	}
	
	private void showStatus() {
		print();
		print("Computer has " + computerHand.size() + " cards");
		print("My Hand: " + myHand);
		print("Discard: " + discard);
		if(discard.getRank() == '8') {
			print("Suit is " + activeSuit);
		}
	}
	
	private void drawMyCard() {
		Card drewcard = deck.deal();
		print();
		print("You drew " + drewcard);
		myHand.add(drewcard);
		
		// if I can play drawn card, play it
		if(isValidPlay(drewcard.toString())) {
			print("You played " + drewcard);
			discardMyCard(drewcard);
		}
	}
	
	private void discardMyCard(Card myCard) {
		myHand.remove(myCard);
		discardPile.add(discard);
		discard = myCard;
		if(myCard.getRank() == '8') {
			activeSuit = promptForSuit();
		}
	}
	
	private void playMyCard() {
		showStatus();
		boolean validPlay = false;
		while(!validPlay) {
			String rankSuit = promptForString("Which card would you like to play?");
			rankSuit = rankSuit.toUpperCase();
			// if draw, draw a card
			if(rankSuit.equals("D")) {
				drawMyCard();
				validPlay = true;
			} 
			// if valid play, play the card
			else if(!isValidPlay(rankSuit)){
				Card selectedCard = new Card(rankSuit);
				discardMyCard(selectedCard);
				validPlay = true;
			}
		}
	}
	
	private boolean isValidPlay(String rankSuit) {
		boolean validPlay = true;
		Card card = new Card(rankSuit);
		 
		// is the card a valid card?
		if(!card.isValid()) {
			print(rankSuit + " is not a valid card");
			validPlay = false;
		}
		// is that card in my hand?
		else if(!myHand.contains(card)) {
			print(rankSuit + " is not in your hand");
			validPlay = false;
		}
		
		// 8s are always valid. If the card is not an 8...
		else if(card.getRank() != '8') {
			// is the discard an 8
			if(discard.getRank() == '8') {
				// does this card match the active suit?
				if(card.getSuit() != activeSuit) {
					print(rankSuit + " cannot be played on " + discard + " beacuse the suit"
							+ "was set to " + activeSuit);
					validPlay = false;
				}
			}
			
			// if discard is not 8,
			// does that discard match the rank or suit?
			else if(card.getSuit() != discard.getSuit() && card.getRank() != discard.getRank()) {
				print(rankSuit + " cannot be played on " + discard + ".");
				validPlay = false;
			}
		}
		
		return validPlay;
	}
	
	private void discardComputerCard(Card computerCard) {
		computerHand.remove(computerCard);
		discardPile.add(discard);
		discard = computerCard;
		
		if(discard.getRank() == '8') {
			int highestCount = countHearts;
			activeSuit = 'H';
			if(countDiamonds > highestCount) {
				highestCount = countDiamonds;
				activeSuit = 'D';
			}
			if(countClubs > highestCount) {
				highestCount = countClubs;
				activeSuit = 'C';
			}
			if(countSpades > highestCount) {
				highestCount = countSpades;
				activeSuit = 'S';
			}
		}
	}
	
	private void playComputerCard() {
		System.out.println(computerHand.toString());
		ArrayList<Card> playableCards = new ArrayList<Card>();
	    ArrayList<Card> eights = new ArrayList<Card>();
	    
	    // count eights and number of each unit
	    for(int i = 0; i < computerHand.size(); i++) {
	    	Card card = computerHand.cardAt(i);
	    	
	    	// if it's an eight, save it
	    	if(card.getRank() == '8') {
	    		eights.add(card);
	    	}
	    	// otherwise, count the number of each suit
	    	else {
	    		switch(card.getSuit()) {
	    			case 'H':
	    				countHearts++;
	    				break;
	    			case 'D':
	    				countDiamonds++;
	    				break;
	    			case 'C':
	    				countClubs++;
	    				break;
	    			case 'S':
	    				countSpades++;
	    				break;
	    		}
	    	}
	    }
		
		// make list of playable cards
		for(int i = 0; i < computerHand.size(); i++) {
			Card card = computerHand.cardAt(i);
			// if discard is an 8, all cards of active suit are playable
			if(discard.getRank() == '8') {
				if(card.getSuit() == activeSuit) {
					playableCards.add(card);
				}
			}
			
			// else if discard is not 8
			else if(card.getSuit() == (discard.getRank()) || card.getRank() == (discard.getRank())) {
				playableCards.add(card);
			}
		}
		
		// pick a random playable card
		int numberOfPlayableCards = playableCards.size();
		if(numberOfPlayableCards > 0) {
			int pick = rand.nextInt(numberOfPlayableCards);
			Card playedCard = playableCards.get(pick);
			discardComputerCard(playedCard);
		}
		
		// otherwise, if have an eight, play an 8
		else if(eights.size() > 0) {
			Card playedCard = eights.get(0);
			discardComputerCard(playedCard);
		}
		
		// if nothing could play, draw a card
		else {
			Card drewCard = deal();
			computerHand.add(drewCard);
			print();
			print("Computer drew a card.");
			
			// if it plays, play it
			if(drewCard.getSuit() == discard.getSuit() || drewCard.getRank() == discard.getRank()) {
				discardComputerCard(drewCard);
			}
		}
	}
	
	private char promptForSuit() {
		char suit = ' ';
		boolean validSuit = false;
		while(!validSuit) {
			suit = promptForChar("Change suit to H, D, C or S?");
			suit = Character.toUpperCase(suit);
			if(Card.isValidSuit(suit)) {
				validSuit = true;
			}
		}
		return suit;
	}
	
}

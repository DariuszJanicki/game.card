package pl.jamnic.game.card.model;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * Deck containing a list of {@link Card}s.
 * 
 * @author Dariusz Janicki
 */
public final class Deck {

	private List<Card> cards = Lists.newArrayList();

	public Deck(List<Card> cards) {
		this.cards = cards;
	}
	
	public List<Card> getCards() {
		return cards;
	}
	
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
}

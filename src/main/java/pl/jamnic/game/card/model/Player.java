package pl.jamnic.game.card.model;

import java.util.Optional;

/**
 * Entity representing a living {@link Player}.
 * 
 * @author Dariusz Janicki
 */
public final class Player {

	private String name;
	private Optional<Deck> deck;

	public Player(String name) {
		this.name = name;
		this.deck = Optional.empty();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Optional<Deck> getDeck() {
		return deck;
	}

	public void setDeck(Optional<Deck> deck) {
		this.deck = deck;
	}
}

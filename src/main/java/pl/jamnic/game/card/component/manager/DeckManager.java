package pl.jamnic.game.card.component.manager;

import java.util.List;

import pl.jamnic.game.card.model.Card;
import pl.jamnic.game.card.model.Deck;

public interface DeckManager {

	void addCards(Deck deck, List<Card> winnersCards);

	void addCard(Deck deck, Card card);

	Card drawCard(Deck deck);

	void shuffleDeck(Deck deckToShuffle);

	void shuffleDeck(Deck warDeck, int times);

	List<Deck> splitDeck(Deck deckToSplit, int numberOfNewDecks);

	String getDeckInfo(Deck deck);

}
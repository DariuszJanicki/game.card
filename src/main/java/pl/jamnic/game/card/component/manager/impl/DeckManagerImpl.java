package pl.jamnic.game.card.component.manager.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.jamnic.game.card.component.manager.CardManager;
import pl.jamnic.game.card.component.manager.DeckManager;
import pl.jamnic.game.card.model.Card;
import pl.jamnic.game.card.model.Deck;

import com.google.common.collect.Lists;

@Component
public final class DeckManagerImpl implements DeckManager {

	@Autowired
	private CardManager cardManager;

	private Random random = new Random();

	@Override
	public List<Deck> splitDeck(Deck deckToSplit, int numberOfNewDecks) {
		return splitCards(deckToSplit, createDecks(numberOfNewDecks));
	}

	@Override
	public void shuffleDeck(Deck warDeck, int times) {
		for (int i = 0; i < times; ++i) {
			shuffleDeck(warDeck);
		}
	}

	@Override
	public void shuffleDeck(Deck deckToShuffle) {
		List<Card> cardsToShuffle = deckToShuffle.getCards();
		List<Card> result = Lists.newArrayList();

		while (!cardsToShuffle.isEmpty()) {
			result.add(pickRandomCard(cardsToShuffle));
		}

		deckToShuffle.setCards(result);
	}

	@Override
	public Card drawCard(Deck deck) {
		return deck.getCards().remove(0);
	}

	@Override
	public void addCard(Deck deck, Card card) {
		deck.getCards().add(card);
	}

	@Override
	public void addCards(Deck deck, List<Card> winnersCards) {
		deck.getCards().addAll(winnersCards);
	}

	@Override
	public String getDeckInfo(Deck deck) {
		List<Card> cards = deck.getCards();

		StringBuilder builder = new StringBuilder("Deck contains ");
		builder.append(cards.size());
		builder.append(" cards.\n\t");

		for (Card card : cards) {
			builder.append(" ");
			builder.append(cardManager.getCardInfo(card));
		}

		builder.append("\n");

		return builder.toString();
	}

	private List<Deck> createDecks(int numberOfNewDecks) {
		List<Deck> newDecks = new ArrayList<>(numberOfNewDecks);

		for (int i = 0; i < numberOfNewDecks; ++i) {
			newDecks.add(new Deck(Lists.newLinkedList()));
		}

		return newDecks;
	}

	private List<Deck> splitCards(Deck deckToSplit, List<Deck> newDecks) {
		int i = 0;

		for (Card card : deckToSplit.getCards()) {
			addCard(newDecks.get(i++ % newDecks.size()), card);
		}

		return newDecks;
	}

	private Card pickRandomCard(List<Card> cardsToShuffle) {
		return cardsToShuffle.remove(random.nextInt(cardsToShuffle.size()));
	}
}

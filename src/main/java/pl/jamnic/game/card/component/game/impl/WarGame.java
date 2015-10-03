package pl.jamnic.game.card.component.game.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pl.jamnic.game.card.component.factory.DeckFactory;
import pl.jamnic.game.card.component.game.Game;
import pl.jamnic.game.card.component.manager.DeckManager;
import pl.jamnic.game.card.model.Card;
import pl.jamnic.game.card.model.Deck;
import pl.jamnic.game.card.model.Player;

import com.google.common.collect.Lists;

@Component
public class WarGame implements Game {

	@Autowired
	@Qualifier("smallDeckFactoryImpl")
	private DeckFactory deckFactory;

	@Autowired
	private DeckManager deckManager;

	private int round = 0;

	@Override
	public void initializeGame(Player firstPlayer, Player secondPlayer) {
		deckManager.toString();
		Deck warDeck = deckFactory.createNew();

		deckManager.shuffleDeck(warDeck, 10);

		List<Deck> twoDecks = deckManager.splitDeck(warDeck, 2);

		firstPlayer.setDeck(Optional.of(twoDecks.get(0)));
		secondPlayer.setDeck(Optional.of(twoDecks.get(1)));
	}

	@Override
	public boolean performGame(Deck firstDeck, Deck secondDeck) {
		List<Card> firstCards = firstDeck.getCards();
		List<Card> secondCards = secondDeck.getCards();

		return roundConditionsPassed(firstCards, secondCards) ? compareCards(
				firstDeck, secondDeck, Lists.newLinkedList()) : false;
	}

	private boolean roundConditionsPassed(List<Card> firstCards,
			List<Card> secondCards) {
		boolean firstPlayerHasCardsToPlay = !firstCards.isEmpty();
		boolean secondPlayerHasCardsToPlay = !secondCards.isEmpty();
		boolean roundLimitIsNotAchievedYet = ++round < 1000;

		return roundLimitIsNotAchievedYet && firstPlayerHasCardsToPlay
				&& secondPlayerHasCardsToPlay;
	}

	private boolean compareCards(Deck firstDeck, Deck secondDeck,
			List<Card> winnersCards) {
		Card firstCard = deckManager.drawCard(firstDeck);
		Card secondCard = deckManager.drawCard(secondDeck);

		winnersCards.add(firstCard);
		winnersCards.add(secondCard);

		int comparison = WarGame.compare(firstCard, secondCard);

		if (comparison > 0) {
			deckManager.addCards(firstDeck, winnersCards);
		} else if (comparison < 0) {
			deckManager.addCards(secondDeck, winnersCards);
		} else {
			return performWar(firstDeck, secondDeck, winnersCards);
		}

		return true;
	}

	private boolean performWar(Deck firstDeck, Deck secondDeck,
			List<Card> winnersCards) {
		if (firstDeck.getCards().size() < 2) {
			deckManager.addCards(secondDeck, winnersCards);
		} else if (secondDeck.getCards().size() < 2) {
			deckManager.addCards(firstDeck, winnersCards);
		} else {
			winnersCards.add(deckManager.drawCard(firstDeck));
			winnersCards.add(deckManager.drawCard(secondDeck));

			return compareCards(firstDeck, secondDeck, winnersCards);
		}

		return false;
	}

	private static int compare(Card firstCard, Card secondCard) {
		int firstCardValue = firstCard.getCardNumber().getValue();
		int secondCardValue = secondCard.getCardNumber().getValue();

		return Integer.compare(firstCardValue, secondCardValue);
	}
}

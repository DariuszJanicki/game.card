package pl.jamnic.game.card.component.game;

import pl.jamnic.game.card.model.Deck;
import pl.jamnic.game.card.model.Player;

public interface Game {

	void initializeGame(Player firstPlayer, Player secondPlayer);

	boolean performGame(Deck firstDeck, Deck secondDeck);

}

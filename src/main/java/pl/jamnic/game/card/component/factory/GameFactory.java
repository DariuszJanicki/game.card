package pl.jamnic.game.card.component.factory;

import pl.jamnic.game.card.component.game.Game;

@FunctionalInterface
public interface GameFactory {

	Game createGame();
}

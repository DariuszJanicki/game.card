package pl.jamnic.game.card.component.factory.game;

import org.springframework.stereotype.Component;

import pl.jamnic.game.card.component.factory.GameFactory;
import pl.jamnic.game.card.component.game.Game;
import pl.jamnic.game.card.component.game.impl.WarGame;

@Component
public final class WarGameFactoryImpl implements GameFactory {

	@Override
	public Game createGame() {
		return new WarGame();
	}
}

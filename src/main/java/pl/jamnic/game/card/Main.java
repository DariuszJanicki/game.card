package pl.jamnic.game.card;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.jamnic.game.card.component.factory.DeckFactory;
import pl.jamnic.game.card.component.factory.GameFactory;
import pl.jamnic.game.card.component.factory.deck.SmallDeckFactoryImpl;
import pl.jamnic.game.card.component.factory.game.WarGameFactoryImpl;
import pl.jamnic.game.card.component.game.Game;
import pl.jamnic.game.card.component.manager.PlayerManager;
import pl.jamnic.game.card.component.manager.impl.PlayerManagerImpl;
import pl.jamnic.game.card.model.Player;

public final class Main {

	private PlayerManager playerManager;
	private GameFactory gameFactory;
	private DeckFactory deckFactory;

	public static void main(String[] args) {
		new Main().play();
	}

	private void play() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();

		ctx.register(SpringConfiguration.class);
		ctx.refresh();

		playerManager = ctx.getBean(PlayerManagerImpl.class);
		gameFactory = ctx.getBean(WarGameFactoryImpl.class);
		deckFactory = ctx.getBean(SmallDeckFactoryImpl.class);

		Player player1 = new Player("Karol");
		Player player2 = new Player("Mateusz");

		Game game = gameFactory.createGame();

		game.initializeGame(player1, player2);

		printPlayers(player1, player2);

		while (game.performGame(player1.getDeck().get(), player2.getDeck().get())) {
		}

		printPlayers(player1, player2);
		ctx.close();
	}

	private void printPlayers(Player player1, Player player2) {
		System.out.println(playerManager.getPlayerInfo(player1));
		System.out.println("================");
		System.out.println(playerManager.getPlayerInfo(player2));
	}

}

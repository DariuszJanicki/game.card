package pl.jamnic.game.card;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.jamnic.game.card.component.factory.GameFactory;
import pl.jamnic.game.card.component.game.Game;
import pl.jamnic.game.card.component.manager.PlayerManager;
import pl.jamnic.game.card.model.Player;

public final class Main {

	private PlayerManager playerManager;
	private GameFactory gameFactory;

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		new Main(ctx);
	}
	
	public Main(ApplicationContext ctx) {
		playerManager = (PlayerManager) ctx.getBean("playerManagerImpl");
		gameFactory = (GameFactory) ctx.getBean("warGameFactoryImpl");

		Player player1 = new Player("Karol");
		Player player2 = new Player("Mateusz");
		
		Game game = gameFactory.createGame();

		game.initializeGame(player1, player2);

		printPlayers(player1, player2);

		while (game.performGame(player1.getDeck().get(), player2.getDeck().get())) {
		}

		printPlayers(player1, player2);
	}

	private void printPlayers(Player player1, Player player2) {
		System.out.println(playerManager.getPlayerInfo(player1));
		System.out.println("================");
		System.out.println(playerManager.getPlayerInfo(player2));
	}

}

package pl.jamnic.game.card.component.manager.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.jamnic.game.card.component.manager.DeckManager;
import pl.jamnic.game.card.component.manager.PlayerManager;
import pl.jamnic.game.card.model.Deck;
import pl.jamnic.game.card.model.Player;

@Component
public class PlayerManagerImpl implements PlayerManager {

	@Autowired
	private DeckManager deckManager;
	
	@Override
	public String getPlayerInfo(Player player) {
		StringBuilder builder = new StringBuilder(player.getName());

		Optional<Deck> deckOptional = player.getDeck();
		if (deckOptional.isPresent()) {
			builder.append("\t");
			Deck deck = deckOptional.get();
			builder.append(deckManager.getDeckInfo(deck));
		}

		return builder.toString();
	}
	
}

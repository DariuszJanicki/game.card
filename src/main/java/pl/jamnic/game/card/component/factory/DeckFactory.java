package pl.jamnic.game.card.component.factory;

import pl.jamnic.game.card.model.Deck;

/**
 * Interface for {@link DeckFactory} classes. It is used to create {@link Deck}s of cards.
 * 
 * @author Dariusz Janicki
 */
@FunctionalInterface
public interface DeckFactory {

	Deck createNew();
}

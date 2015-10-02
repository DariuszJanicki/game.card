package pl.jamnic.game.card.model.type;

public enum CardSuit {

	SPADES('\u2660'), HEARTS('\u2764'), DIAMONDS('\u2666'), CLUBS('\u2663');

	private char symbol;

	private CardSuit(char symbol) {
		this.symbol = symbol;
	}

	public char getSymbol() {
		return symbol;
	}
}

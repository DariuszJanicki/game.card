package pl.jamnic.game.card.model.type;

/**
 * 
 * @author Jamnic
 *
 */
public enum CardNumber {

	TWO(2, "2"), THREE(3, "3"), FOUR(4, "4"), FIVE(5, "5"), SIX(6, "6"), SEVEN(7, "7"), EIGHT(8, "8"), NINE(9, "9"), TEN(
			10, "10"), JACK(11, "J"), QUEEN(12, "Q"), KING(13, "K"), ACE(14, "A");

	private int value;
	private String number;

	private CardNumber(int value, String number) {
		this.value = value;
		this.number = number;
	}

	public int getValue() {
		return value;
	}

	public String getNumber() {
		return number;
	}
}

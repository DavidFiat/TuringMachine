package model;

public class BandElement {

	private String symbol;
	private BandElement nextBandElement;
	private BandElement previousBandElement;

	public BandElement(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public BandElement getNextBandElement() {
		return nextBandElement;
	}

	public void setNextBandElement(BandElement nextBandElement) {
		this.nextBandElement = nextBandElement;
	}

	public BandElement getPreviousBandElement() {
		return previousBandElement;
	}

	public void setPreviousBandElement(BandElement previousBandElement) {
		this.previousBandElement = previousBandElement;
	}

}

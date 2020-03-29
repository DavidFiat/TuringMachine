package model;

public class Machine {

	private BandElement first;
	private BandElement middle;
	private BandElement last;
	private int numberOfElements;

	public Machine() {
		first = null;
		middle = null;
		last = null;
		numberOfElements = 0;
	}

	public BandElement getFirst() {
		return first;
	}

	public void setFirst(BandElement first) {
		this.first = first;
	}

	public BandElement getMiddle() {
		return middle;
	}

	public void setMiddle(BandElement middle) {
		this.middle = middle;
	}

	public BandElement getLast() {
		return last;
	}

	public void setLast(BandElement last) {
		this.last = last;
	}

	public int getNumberOfElements() {
		return numberOfElements;
	}

	public void setNumberOfElements(int numberOfElements) {
		this.numberOfElements = numberOfElements;
	}

	public void c0Add(String b) {
		BandElement bE = new BandElement(b);
		if (first == null) {
			first = bE;
			middle = bE;
			last = bE;
		} else {
			BandElement temp = first;
			first = bE;
			first.setNextBandElement(temp);
			temp.setPreviousBandElement(first);
		}
		if (numberOfElements % 2 != 0) {
			middle = middle.getPreviousBandElement();
		}
		numberOfElements++;
	}

	public void c1Add(String b) {
		BandElement bE = new BandElement(b);
		if (middle == null) {
			middle = bE;
			first = bE;
			last = bE;
		} else {
			if (numberOfElements % 2 != 0) {
				BandElement temp = middle;

				middle.setNextBandElement(bE);
				// bE.setNextBandElement(temp);
				bE.setPreviousBandElement(middle);
				if (middle == last) {
					last = bE;
				}
			} else {
				BandElement temp1 = middle;
				BandElement temp2 = middle.getNextBandElement();
				temp1.setNextBandElement(bE);

				bE.setNextBandElement(temp2);
				temp2.setPreviousBandElement(bE);

				bE.setPreviousBandElement(temp1);
				middle = bE;
			}
		}
		numberOfElements++;
	}

	public void c2Add(String b) {
		BandElement bE = new BandElement(b);
		if (last == null) {
			middle = bE;
			first = bE;
			last = bE;

		} else {
			BandElement temp = last;
			last = bE;
			last.setPreviousBandElement(temp);
			if (temp != null) {
				temp.setNextBandElement(last);
			}
			if (numberOfElements % 2 == 0) {
				if (middle != null) {
					middle = middle.getNextBandElement();
				}
			}

		}
		numberOfElements++;
	}

	public void c0Remove() {
		if (first != null) {
			BandElement current = first;
			if (current == null) {
				first = null;
				middle = null;
				last = null;
			} else {
				current.setPreviousBandElement(null);
				first = current;
				if (numberOfElements % 2 == 0) {
					middle = middle.getNextBandElement();
				}
			}
			numberOfElements--;

		}
	}

	public void c1Remove() {
		if (middle != null) {
			if (middle == first) {
				c0Remove();
			} else {
				BandElement p = middle.getPreviousBandElement();
				BandElement n = middle.getNextBandElement();
				if (p != null) {
					p.setNextBandElement(n);
				}
				if (n != null) {
					n.setPreviousBandElement(p);
				}
				numberOfElements--;

			}

		}
	}

	public void c2Remove() {
		if (last != null) {
			if (last == first) {
				c0Remove();
			} else {

				BandElement current = last.getPreviousBandElement();
				if (current != null) {
					current.setNextBandElement(null);
				}
				last = current;
				if (numberOfElements % 2 != 0) {
					middle = middle.getPreviousBandElement();
				}
				numberOfElements--;

			}

		}
	}

	public String c0Read() {
		String a = "#";
		if (first != null) {
			a = first.getSymbol();
		}
		return a;
	}

	public String c1Read() {
		String a = "#";
		if (middle != null) {
			a = middle.getSymbol();
		}
		return a;
	}

	public String c2Read() {
		String a = "#";
		if (last != null) {
			a = last.getSymbol();
		}
		return a;
	}

}

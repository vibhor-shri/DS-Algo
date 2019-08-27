package array;

public class Pair {

	int pairItemOne;
	int pairItemTwo;

	public Pair(int itemOne, int itemTwo) {
		this.pairItemOne = itemOne;
		this.pairItemTwo = itemTwo;
	}

	@Override
	public String toString() {
		String str = "" + pairItemOne + " , " + pairItemTwo;
		return str;
	}

}

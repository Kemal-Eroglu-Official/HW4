public class CountableBox extends Box implements Countable {
	private int itemCount;
	
	public CountableBox(String boxCode, int volume, int boxSerialNumber, int itemCount) {
		super(boxCode, volume, boxSerialNumber);
		this.itemCount = itemCount;
	}
}

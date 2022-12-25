public class CountableItem extends Item implements Countable {
	private int itemCount;

	public CountableItem(String itemCode, int volume, String itemSerialNumber, int itemCount) {
		super(itemCode, volume, itemSerialNumber);
		this.itemCount = itemCount;
	}
}

package Item;
public class UncountableItem extends Item {
	
	private int itemMass;

	public UncountableItem(String itemCode, int volume, String itemSerialNumber, int itemMass) {
		super(itemCode, volume, itemSerialNumber);
		this.itemMass = itemMass;
	}
}

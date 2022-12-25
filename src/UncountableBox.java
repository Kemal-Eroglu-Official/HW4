public class UncountableBox extends Box{
	private int itemMass;

	public UncountableBox(String boxCode, int volume, int boxSerialNumber, int itemMass) {
		super(boxCode, volume, boxSerialNumber);
		this.itemMass = itemMass;
	}
}

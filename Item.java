package FinalProject;

public abstract class Item implements Comparable<Item> {

// Declare attributes here
	private String strClass;
	private String strName;
	private int intDurability;
	private int intWeight;
	private int intValue;
	private int intID;

	public Item(String strClass, String strName, int intWeight, int intValue, int intDurability, int intID) {
		this.strClass = strClass;
		this.strName = strName;
		this.intDurability = intDurability;
		this.intWeight = intWeight;
		this.intValue = intValue;
		this.intID = intID;
	}

	public String getStrClass() {
		return strClass;
	}

	public void setStrClass(String strClass) {
		this.strClass = strClass;
	}

	public String getStrName() {
		return strName;
	}

	public void setStrName(String strName) {
		this.strName = strName;
	}

	public int getIntDurability() {
		return intDurability;
	}

	public void setIntDurability(int intDurability) {
		this.intDurability = intDurability;
	}

	public int getIntWeight() {
		return intWeight;
	}

	public void setIntWeight(int intWeight) {
		this.intWeight = intWeight;
	}

	public int getIntValue() {
		return intValue;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	public int getIntID() {
		return intID;
	}

	public void setIntID(int intID) {
		this.intID = intID;
	}

	public int getValueRatio() {
		return this.intValue / this.intWeight;
	}

	public int compareTo(Item o) {
		return ((this.getIntValue()) - (o.getIntValue()));
	}

	@Override

	public String toString() {
		return "Class: " + strClass + " Name: " + strName + " Weight: " + intWeight + " Value: " + intValue
				+ " Durability: " + intDurability + " ID: " + intID;
	}

//	+ " Damage: " + intDamage + " Defense: " + intDefense + " Color: " + strColor
//	+ " Metal: " + strMetal + " Plastic: " + strPlastic + " Fabric: " + strFabric
//	+ " Food Type: " + strFoodType + " Medicinal: " + strMedicinal + " Expiration Year: " + intExpireYear

}
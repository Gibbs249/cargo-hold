package FinalProject;

public class Equipment extends Item {
	// How much damage does the item do?
	private int intDamage;
	// How much defense does the item provide?
	private int intDefense;
	// What color is the item?
	private String strColor;

	public Equipment(String strClass, String strName, int intDurability, int intWeight, int intValue, int intID) {
		super(strClass, strName, intDurability, intWeight, intValue, intID);
	}

	public Equipment(String strClass, String strName, int intDurability, int intWeight, int intValue, int intID,
			int intDamage, int intDefense, String strColor) {
		super(strClass, strName, intDurability, intWeight, intValue, intID);
		this.intDamage = intDamage;
		this.intDefense = intDefense;
		this.strColor = strColor;
	}

	public int getIntDamage() {
		return intDamage;
	}

	public void setIntDamage(int intDamage) {
		this.intDamage = intDamage;
	}

	public int getIntDefense() {
		return intDefense;
	}

	public void setIntDefense(int intDefense) {
		this.intDefense = intDefense;
	}

	public String getStrColor() {
		return strColor;
	}

	public void setStrColor(String strColor) {
		this.strColor = strColor;
	}
}
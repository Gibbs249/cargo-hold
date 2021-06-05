package FinalProject;

public class Consumable extends Item {
	// If any, what type of food is this item? (vegetable, meat, snack, none...)
	private String strFoodType;
	// Is the item medicinal?
	private String strMedicinal;
	// What year does the item expire?
	private int intExpireYear;

	public Consumable(String strClass, String strName, int intDurability, int intWeight, int intValue, int intID) {
		super(strClass, strName, intWeight, intValue, intDurability, intID);
	}

	public Consumable(String strClass, String strName, int intDurability, int intWeight, int intValue, int intID,
			String strFoodType, String strMedicinal, int intExpireYear) {
		super(strClass, strName, intDurability, intWeight, intValue, intID);
		this.strFoodType = strFoodType;
		this.strMedicinal = strMedicinal;
		this.intExpireYear = intExpireYear;
	}

	public String getStrFoodType() {
		return strFoodType;
	}

	public void setStrFoodType(String strFoodType) {
		this.strFoodType = strFoodType;
	}

	public String getStrMedicinal() {
		return strMedicinal;
	}

	public void setStrMedicinal(String strMedicinal) {
		this.strMedicinal = strMedicinal;
	}

	public int getIntExpireYear() {
		return intExpireYear;
	}

	public void setIntExpireYear(int intExpireYear) {
		this.intExpireYear = intExpireYear;
	}
}
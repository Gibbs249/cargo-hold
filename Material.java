package FinalProject;

public class Material extends Item implements Comparable<Item> {
	// If item is made of metal
	private String strMetal;
	// If item is made of plastic
	private String strPlastic;
	// If item is made of Fabric
	private String strFabric;

	public Material(String strClass, String strName, int intDurability, int intWeight, int intValue, int intID) {
		super(strClass, strName, intDurability, intWeight, intValue, intID);
	}

	public Material(String strClass, String strName, int intDurability, int intWeight, int intValue, int intID,
			String strMetal, String strPlastic, String strFabric) {
		super(strClass, strName, intDurability, intWeight, intValue, intID);
		this.strMetal = strMetal;
		this.strPlastic = strPlastic;
		this.strFabric = strFabric;
	}

	public String getStrMetal() {
		return strMetal;
	}

	public void setStrMetal(String strMetal) {
		this.strMetal = strMetal;
	}

	public String getStrPlastic() {
		return strPlastic;
	}

	public void setStrPlastic(String strPlastic) {
		this.strPlastic = strPlastic;
	}

	public String getStrFabric() {
		return strFabric;
	}

	public void setStrFabric(String strFabric) {
		this.strFabric = strFabric;
	}
}
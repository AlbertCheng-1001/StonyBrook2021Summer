package cs.homework2;
import java.math.*;

/**
 * Contains various information about a specific item that can or has been sold in a given department store.
 * 
 * Author Albert Cheng 
 * AuthorID 113332562 
 * Recitation R30
 */
public class ItemInfo {
	private String productName;
	private double price;
	private String rfidTagNumber;
	private String originalLocation;
	private String currentLocation;

	/**
	 * 
	 * @param productName
	 * 		productName of the ItemInfo
	 * @param price
	 * 		Price of the ItemInfo
	 * @param rfidTagNumber
	 * 		rfidTagNumber of the ItemInfo
	 * @param originalLocation
	 * 		originalLocation of the ItemInfo
	 * @throws Exception
	 * 		Exception for originalLocation and rfidTagNumber
	 */
	public ItemInfo(String productName, double price, String rfidTagNumber, String originalLocation) throws Exception {
		setProductName(productName);
		setPrice(price);
		setRfidTagNumber(rfidTagNumber);
		setOriginalLocation(originalLocation);
		setCurrentLocation(originalLocation);

	}

	/**
	 * Retrieves the ProductName of the ItemInfo
	 * @return
	 * 		ProductName of ItemInfo
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * Sets the ProductName of the ItemInfo
	 * @param productName
	 * 		Sets the productName of the ItemInfo
	 * @throws Exception
	 * 		Checks to see if productName is valid
	 */
	public void setProductName(String productName) throws Exception {
		if (productName == null || productName.trim().length() == 0) {
			throw new Exception("Invalid productName");
		}
		this.productName = productName;
	}

	/**
	 * Retrieves the Price of the ItemInfo
	 * @return
	 * 		Price of ItemInfo
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * sets the Price of the ItemInfo
	 * @param price
	 * 		Sets the Price of the ItemInfo
	 * @throws Exception
	 * 		Checks if price is negative
	 */
	public void setPrice(double price) throws Exception {
		if (price < 0) {
			throw new Exception("Price can't be negative");
		}
		this.price = price;
	}

	/**
	 * Retrieves the rfidTagNumber of the ItemInfo
	 * @return
	 * 		rfidTagNumber of ItemInfo
	 */		
	public String getRfidTagNumber() {
		return rfidTagNumber;
	}

	/**
	 * Sets the rfidTagNumber of the ItemInfo
	 * @param rfidTagNumber
	 * 		Sets the rfidTagNumber of the ItemInfo
	 */
	public void setRfidTagNumber(String rfidTagNumber) {
		BigInteger bigInt = new BigInteger(rfidTagNumber, 16);
		this.rfidTagNumber = rfidTagNumber;
	}

	/**
	 * Retrieves the OriginalLocation of the ItemInfo
	 * @return
	 * 		OriginalLocation of ItemInfo
	 */
	public String getOriginalLocation() {
		return originalLocation;
	}

	/**
	 * Sets OriginalLocation of the ItemInfo
	 * @param originalLocation
	 * 		Sets the OriginalLocation of the ItemInfo
	 * @throws Exception
	 * 		Checks if originalLocation is valid 
	 */
	public void setOriginalLocation(String originalLocation) throws Exception {
		if (originalLocation.charAt(0) == 's' && originalLocation.length() == 6 ) {
			String check = originalLocation.substring(1);
			Integer.parseInt(check);
			this.originalLocation = originalLocation;
		}
		else {
			throw new Exception ("Invalid OriginalLocation");
		
		}
	}

	/**
	 * Retrieves the CurrentLocation of the ItemInfo
	 * @return
	 * 		CurrentLocation of ItemInfo
	 */
	public String getCurrentLocation() {
		return currentLocation;
	}

	/**
	 * Sets CurrentLocation of the ItemInfo
	 * @param currentLocation
	 * 		Sets CurrentLocation of the ItemInfo
	 */
	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	/**
	 * toString method to print out the ItemInfo
	 */
	public String toString() {
		return String.format("%-21s%-21s%-21s%-21s%-21.2f", this.getProductName(), this.getRfidTagNumber(),
				this.getOriginalLocation(), this.getCurrentLocation(), this.getPrice());

	}

}

package mmmi.Domain;

public class Citizen {

	private String name;
	private String cprNumber;
	private String address;
	private int phoneNumber;

	/**
	 * 
	 * @param name
	 */
	public Citizen(String name) {
		// TODO - implement Citizen.Citizen
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return this.name;
	}

	public String getCprNumber() {
		return this.cprNumber;
	}

	/**
	 * 
	 * @param cprNumber
	 */
	public void setCprNumber(String cprNumber) {
		this.cprNumber = cprNumber;
	}

	public String getAddress() {
		return this.address;
	}

	/**
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return this.phoneNumber;
	}

	/**
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
package model;


public class Password {
	
	private long id;
	private String password;
	private String status;
	private double weakWeight;
	private double mediumWeight;
	private double strongWeight;
	
	
	public Password() {
		this.weakWeight = 0;
		this.mediumWeight = 0;
		this.strongWeight = 0;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setMessageStatus(String status) {
		this.status = status;
	}
	
	public double getWeakWeight() {
		return weakWeight;
	}

	public void setWeakWeight(double weakWeight) {
		this.weakWeight = weakWeight;
	}

	public double getMediumWeight() {
		return mediumWeight;
	}

	public void setMediumWeight(double mediumWeight) {
		this.mediumWeight = mediumWeight;
	}

	public double getStrongWeight() {
		return strongWeight;
	}
	
	public void setStrongWeigth(double strongWeight) {
		this.strongWeight = strongWeight;
	}
	
}

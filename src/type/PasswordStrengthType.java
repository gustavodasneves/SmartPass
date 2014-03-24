package type;


public enum PasswordStrengthType {
	
	WEAK("Senha fraca"),
	MEDIUM("Senha m�dia"),
	STRONG("Senha forte");
	
	private String status;
	
	private PasswordStrengthType(String status){
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}
}

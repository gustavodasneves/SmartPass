package type;


public enum PasswordStrengthType {
	
	WEAK("Senha fraca"),
	MEDIUM("Senha m�dia"),
	STRONG("Senha forte");
	
	private String messageStatus;
	
	private PasswordStrengthType(String messageStatus){
		this.messageStatus = messageStatus;
	}
	
	public String getMessageStatus() {
		return messageStatus;
	}
}

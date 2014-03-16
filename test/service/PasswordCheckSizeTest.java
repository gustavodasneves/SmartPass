package service;

import static org.junit.Assert.assertEquals;
import static service.PasswordStrengthType.MEDIUM;
import static service.PasswordStrengthType.STRONG;
import static service.PasswordStrengthType.WEAK;
import model.Password;

import org.junit.Before;
import org.junit.Test;

public class PasswordCheckSizeTest {
	
	private PasswordCheckSize checkSize;
	private Password password;
	
	@Before
	public void setUp() {
		checkSize = new PasswordCheckSize();
		password = new Password();
	}
	
	@Test
	public void shouldReturnWeakWhenPasswordLengthIsLessOfFour() {
		password.setPassword("123");
		assertEquals(WEAK, checkSize.checkPassword(password));
	}
	
	@Test
	public void shouldReturnMediumWhenPasswordLengthIsBiggerToFourAndLessToEigth() {
		password.setPassword("12345");
		assertEquals(MEDIUM, checkSize.checkPassword(password));
	}
	
	@Test
	public void shouldReturnStrongWhenPasswordLengthIsBiggerToSeven() {
		password.setPassword("12345678");
		assertEquals(STRONG, checkSize.checkPassword(password));
	}
}
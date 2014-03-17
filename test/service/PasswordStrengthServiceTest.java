package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.MockitoAnnotations.initMocks;
import static service.PasswordStrengthType.WEAK;
import model.Password;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import fixture.PasswordFixture;

public class PasswordStrengthServiceTest {
	
	private PasswordStrengthService service;
	private Password password;
	@Mock
	private PasswordCheck checker;
	
	@Before
	public void setUp() {
		service = new PasswordStrengthService();
		initMocks(this);
	}
	
	@Test
	public void shouldReturnTrueWhenPasswordWeakPercentualIsMoreSignificativeWithMediumAndStrongPercentuals() {
		password = PasswordFixture.get().withPercentualWeak(50).withPercentualMedium(30).withPercentualStrong(20).build();
		assertTrue(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenPasswordWeakPercentualNotIsMoreSignificativeWithMediumAndStrongPercentuals() {
		password = PasswordFixture.get().withPercentualWeak(20).withPercentualMedium(50).withPercentualStrong(30).build();
		assertFalse(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenPasswordWeakPercentualIsMoreSignificativeWithStrongPercentualButNotIsMoreSignificativeWithMediumPercentual() {
		password = PasswordFixture.get().withPercentualWeak(30).withPercentualMedium(50).withPercentualStrong(20).build();
		assertFalse(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenPasswordWeakPercentualIsMoreSignificativeWithMediumPercentualButNotIsMoreSignificativeWithStrongPercentual() {
		password = PasswordFixture.get().withPercentualWeak(30).withPercentualMedium(20).withPercentualStrong(50).build();
		assertFalse(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnTrueWhenPasswordWeakPercentualDrawWithMediumPercentual() {
		password = PasswordFixture.get().withPercentualWeak(50).withPercentualMedium(50).build();
		assertTrue(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnTrueWhenPasswordWeakPercentualDrawWithStrongPercentual() {
		password = PasswordFixture.get().withPercentualWeak(50).withPercentualStrong(50).build();
		assertTrue(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnTrueWhenPasswordWeakPercentualDrawWithMediumPercentualAndWithStrongPercentual() {
		password = PasswordFixture.get().withPercentualWeak(33.3).withPercentualMedium(33.3).withPercentualStrong(33.3).build();
		assertTrue(service.isWeakPassword(password));
	}
	
	@Test
	public void shouldReturnTrueWhenPasswordMediumPercentualIsMoreSignificativeWithWeakAndStrongPercentuals() {
		password = PasswordFixture.get().withPercentualWeak(30).withPercentualMedium(50).withPercentualStrong(20).build();
		assertTrue(service.isMediumPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenPasswordMediumPercentualNotIsMoreSignificativeWithWeakAndStrongPercentuals() {
		password = PasswordFixture.get().withPercentualWeak(50).withPercentualMedium(20).withPercentualStrong(30).build();
		assertFalse(service.isMediumPassword(password));
	}
	
	@Test
	public void shouldReturnTrueWhenPasswordMediumPercentualDrawWithStrongPercentual() {
		password = PasswordFixture.get().withPercentualMedium(50).withPercentualStrong(50).build();
		assertTrue(service.isMediumPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenPasswordMediumPercentualIsMoreSignificativeWithWeakPercentualButNotIsMoreSignificativeWithStrongPercentual() {
		password = PasswordFixture.get().withPercentualWeak(20).withPercentualMedium(30).withPercentualStrong(50).build();
		assertFalse(service.isMediumPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenPasswordMediumPercentualIsMoreSignificativeWithStrongPercentualButNotIsMoreSignificativeWithWeakPercentual() {
		password = PasswordFixture.get().withPercentualWeak(50).withPercentualMedium(30).withPercentualStrong(20).build();
		assertFalse(service.isMediumPassword(password));
	}
	
	@Test
	public void shouldReturnTrueWhenPasswordStrongPercentualIsMoreSignificativeWithWeakAndMediumPercentuals() {
		password = PasswordFixture.get().withPercentualWeak(30).withPercentualMedium(20).withPercentualStrong(50).build();
		assertTrue(service.isStrongPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenPasswordStrongPercentualNotIsMoreSignificativeWithWeakAndMediumPercentuals() {
		password = PasswordFixture.get().withPercentualWeak(50).withPercentualMedium(30).withPercentualStrong(20).build();
		assertFalse(service.isStrongPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenPasswordStrongPercentualIsMoreSignificativeWithWeakPercentualButNotIsMoreSignificativeWithMediumPercentual() {
		password = PasswordFixture.get().withPercentualWeak(20).withPercentualMedium(50).withPercentualStrong(30).build();
		assertFalse(service.isStrongPassword(password));
	}
	
	@Test
	public void shouldReturnFalseWhenPasswordStrongPercentualIsMoreSignificativeWithMediumPercentualButNotIsMoreSignificativeWithWeakPercentual() {
		password = PasswordFixture.get().withPercentualWeak(50).withPercentualMedium(20).withPercentualStrong(30).build();
		assertFalse(service.isStrongPassword(password));
	}
	
	@Test
	public void shouldPasswordWeakPercentualEquals50WhenSizeAndDictionaryCheckersAreWeak() {
		Password password = PasswordFixture.get().withPassword("p�o").build();
		
		//given(checker.checkPassword(any(Password.class))).willReturn(WEAK);
		
		service.applyPercentualStrong(password);
		
		assertEquals(50.0, password.getPercentualWeak(), 0.0);
	}

}

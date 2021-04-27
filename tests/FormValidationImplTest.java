import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import controller.FormValidation;
import controller.FormValidationImpl;
import model.QueryUser;
import model.QueryUserImpl;

class FormValidationImplTest {

	FormValidation formValidation = new FormValidationImpl();
	QueryUser queryUser = new QueryUserImpl();

	@Test
	void testCheckFormSubscribe() {
		int i = 0;
		boolean[] allvalidFields = formValidation.checkFormRegistration("Testnickname", "email@gmail.com", "Testpswd*1",
				"Testpswd*1");
		for (i = 0; i < allvalidFields.length; i++) {
			assertTrue("All fields are valid", allvalidFields[i]);
		}
		boolean[] nicknameFalse = formValidation.checkFormRegistration("Testnickname*", "email@gmail.com", "Testpswd*1",
				"Testpswd*1");
		for (i = 0; i < nicknameFalse.length; i++) {
			if (i == 0) {
				assertFalse("Nickname false", nicknameFalse[i]);
			} else {
				assertTrue("All other fields are true", nicknameFalse[i]);
			}
		}
		boolean[] allnotvalidFields = formValidation.checkFormRegistration("", "", "", "1");
		for (i = 0; i < allnotvalidFields.length; i++) {
			if (i == 8) {
				assertTrue("Not empty Pswd confirm", allnotvalidFields[i]);
			} else {
				assertFalse("All other fields are not valid", allnotvalidFields[i]);
			}
		}
	}
	
	@Test
	void testCheckFormSubscribeArray() {
		boolean[] allvalidFields = { true, true, true, true, true, true, true, true, true };
		assertTrue("All fields are valid", formValidation.checkFormRegistrationArray(allvalidFields));
		boolean[] oneNotValidField = { true, true, true, true, true, true, true, true, false };
		assertFalse("One not valid field", formValidation.checkFormRegistrationArray(oneNotValidField));
	}
	
	@Test
	void testCheckFormLoginArray() {
		ArrayList<Boolean> allvalidFields = new ArrayList<Boolean>();
		boolean valid = true;
		boolean notValid = false;
		for (int i = 0; i < 5 ; i++) {
			allvalidFields.add(valid);
		}
		ArrayList<Boolean> oneFieldNotValid = new ArrayList<Boolean>();
		for (int i = 0; i < 5 ; i++) {
			if (i == 4) {
				oneFieldNotValid.add(notValid);
			} else {
				oneFieldNotValid.add(valid);
			}
		}
		assertTrue("All fields are valid", formValidation.checkFormLoginArray(allvalidFields));
		assertFalse("One not valid field", formValidation.checkFormLoginArray(oneFieldNotValid));
	}

	@Test
	void testCkeckNotEmptyTextField() {
		assertTrue("Field valid", formValidation.ckeckNotEmptyTextField("Test"));
		assertFalse("Field not valid, empty", formValidation.ckeckNotEmptyTextField(""));
	}

	@Test
	void testCheckValidNickname() {
		assertTrue("Nickname valid", formValidation.checkValidNickname("Test"));
		assertFalse("Nickname not valid, empty", formValidation.checkValidNickname(""));
		assertFalse("Nickname not valid, min 3 caracters", formValidation.checkValidNickname("Ts"));
		assertFalse("Nickname not valid, max 20 caracters",
				formValidation.checkValidNickname("TestNicknameWithMore20Caraters"));
		assertFalse("Nickname not valid, no specials caracters", formValidation.checkValidNickname("TestNickname*"));
	}

	@Test
	void testCheckValidEmail() {
		assertTrue("Email valid, format xxx.xxx@xxx.xxx", formValidation.checkValidEmail("test.email@gmail.com"));
		assertTrue("Email valid, format xxx@xxx.xxx", formValidation.checkValidEmail("email@gmail.com"));
		assertTrue("Email valid, format xxx.@xxx.xxx", formValidation.checkValidEmail("test.@yahoo.fr"));
		assertFalse("Email not valid, format xxx@", formValidation.checkValidEmail("test@"));
		assertFalse("Email not valid, format @xxx.xxx", formValidation.checkValidEmail("@yahoo.fr"));
		assertFalse("Email not valid, format @xxx", formValidation.checkValidEmail("@yahoo"));
		assertFalse("Email not valid, format @xxx.", formValidation.checkValidEmail("@yahoo."));
	}

	@Test
	void testCkeckEmailNotAlreadyUse() {
		// Create an userTest for test
		queryUser.createUser("nicknameTest", "email@test.fr", "User", "Test", "Nesti", "testuserpsw1*");
		assertTrue("Email not already use", formValidation.ckeckEmailNotAlreadyUse("emailNotUse@test.fr"));
		assertFalse("Email already use", formValidation.ckeckEmailNotAlreadyUse("email@test.fr"));
		queryUser.deleteUserByEmail("email@test.fr");
	}

	@Test
	void testCkeckValidPassword() {
		assertTrue("Valid password", formValidation.ckeckValidPassword("Testuserpsw1*"));
		assertTrue("Valid password", formValidation.ckeckValidPassword("user*Testpsw3"));
		assertFalse("Not valid password, no special characters", formValidation.ckeckValidPassword("Testuserpsw1"));
		assertFalse("Not valid password, not number", formValidation.ckeckValidPassword("Testuserpsw*"));
		assertFalse("Not valid password, not min caracters 8", formValidation.ckeckValidPassword("Testu*1"));
		assertFalse("Not valid password, not min caracters 8", formValidation.ckeckValidPassword("Testu*1"));
		assertFalse("Not valid password, not max caracters 20",
				formValidation.ckeckValidPassword("Testu*1azertyuiopqsdfghjklm"));
		assertFalse("Not valid password, special characters not valid",
				formValidation.ckeckValidPassword("Testuserpsw1*&"));
	}

	@Test
	void testCkeckPswdConfirm() {
		assertTrue("Password confirm", formValidation.ckeckPswdConfirm("Testuserpsw1*", "Testuserpsw1*"));
		assertFalse("Password not confirm", formValidation.ckeckPswdConfirm("Testuserpsw1*", "Testuserpsw1"));
	}

}

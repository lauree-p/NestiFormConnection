import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entity.User;
import model.QueryUser;
import model.QueryUserImpl;

class QueryUserImplTest {
	
	QueryUser queryUser = new QueryUserImpl();

	@Test
	void testFindOneByNickname() {
		queryUser.createUser("nicknameTest","email@test.fr","User","Test","Nesti","testuserpsw1*");
		assertNotNull("User findbyNickname is not null",queryUser.findOneByNickname("nicknameTest").getNickname());
		assertEquals(queryUser.findOneByNickname("nicknameTest").getNickname(),"nicknameTest");
		queryUser.deleteUserByEmail("email@test.fr");
	}

	@Test
	void testFindOneByEmail() {
		queryUser.createUser("nicknameTest","email@test.fr","User","Test","Nesti","testuserpsw1*");
		assertNotNull("User findbyNickname is not null",queryUser.findOneByEmail("email@test.fr").getEmail());
		assertEquals(queryUser.findOneByEmail("email@test.fr").getEmail(),"email@test.fr");
		queryUser.deleteUserByEmail("email@test.fr");
	}

	@Test
	void testCreateUser() {
		queryUser.createUser("nicknameTest","email@test.fr","User","Test","Nesti","testuserpsw1*");
		assertNotNull("User findbyNickname is not null",queryUser.findOneByEmail("email@test.fr").getEmail());
		assertEquals("User findbyNickname",queryUser.findOneByEmail("email@test.fr").getEmail(),"email@test.fr");
		queryUser.deleteUserByEmail("email@test.fr");
	}

	@Test
	void testUpdateUser() {
		User user = queryUser.createUser("nicknameTest","email@test.fr","User","Test","Nesti","testuserpsw1*");
		queryUser.updateUser(user,"Testnickname","test@email.fr","Username","TestFistname","Nestiland");
		user = queryUser.findOneById(user.getIdUser());
		assertEquals("User nickname is equal to the new nickname",user.getNickname(),"Testnickname");
		assertFalse("User nickname is notequal to the new nickname",user.getNickname().equals("nicknameTest"));
		queryUser.deleteUserByEmail("test@email.fr");
	}

	@Test
	void testDeleteUserByEmail() {
		queryUser.createUser("nicknameTest","email@test.fr","User","Test","Nesti","testuserpsw1*");
		queryUser.deleteUserByEmail("email@test.fr");
		assertNull("User was delete",queryUser.findOneByEmail("email@test.fr"));
	}

}

package unit.service;

import com.revature.model.Role;
import com.revature.model.User;
import com.revature.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class UserServiceUnitTest {

    List<User> mockList = Mockito.mock(List.class);

    @Test
    public void whenGivenUserObjectCreateNewUserDoesNotThrowAnException(){
        User user = new User();
        UserService service = new UserService();

        // we've turned our service invocation into an executable that can be called by the assertion
        Assertions.assertDoesNotThrow(() -> service.createUser(user));
    }

    @Test
    public void whenGivenUserObjectCreateNewUserReturnsTrue(){
        User user = new User();
        UserService service = new UserService();

        Mockito.when(mockList.add(user)).thenReturn(true);

        boolean result = service.createUser(user);
        Assertions.assertTrue(result);
    }

    @Test
    public void whenGetAllUsersIsCalledReturnsListOfUsers(){
        // this method is also tricky as we can't really ensure the list returns itself
        // so instead, we once again just assert that this execution doesn't throw an exception

        UserService service = new UserService();
        Assertions.assertDoesNotThrow(() -> service.getAllUsers());
    }


    @Test
    public void whenGivenValidIdGetUserByIdReturnsUserWithThatId(){
        User user = new User(Role.CUSTOMER, "Me", 7);

        Mockito.when(mockList.get(0)).thenReturn(user);
        Mockito.when(mockList.size()).thenReturn(1);

        //TODO: Get Mockito to work correctly with For-each loop


        UserService service = new UserService(mockList);
        User result = service.getUserById(7);
        Assertions.assertEquals(user, result);
    }
}

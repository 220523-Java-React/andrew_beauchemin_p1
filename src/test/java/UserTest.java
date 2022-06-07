import com.revature.controller.UserController;
import com.revature.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    @Test
    public void ableToAddUsers(){
        UserController userController = new UserController();
        User temp1 = new User( User.Role.CUSTOMER, "Andrew");
        Assertions.assertEquals(temp1.getUsername(), "Andrew" );
        Assertions.assertEquals(temp1.getRole(), User.Role.CUSTOMER);
    }

    @Test
    public void ableToAddUserToUserService(){
        UserController userController = new UserController();
        User temp1 = new User( User.Role.CUSTOMER, "Andrew");

        //userController.setUser(temp1);

    }
}

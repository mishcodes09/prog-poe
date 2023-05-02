
package poe;

import org.junit.Test;
import static org.junit.Assert.*;

public class loginTest {
    
    public loginTest() {
    }

    @Test
    public void testCheckUserName() {
        System.out.println("checkUserName");
        String username = "";
        login instance = new login();
        boolean expResult = false;
        boolean result = instance.checkUserName(username);
        assertEquals(expResult, result);
        
    }

    @Test
    public void testCheckPasswordComplexity() {
        System.out.println("checkPasswordComplexity");
        String password = "";
        login instance = new login();
        boolean expResult = false;
        boolean result = instance.checkPasswordComplexity(password);
        assertEquals(expResult, result);
        
    }

    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String username = "";
        String password = "";
        login instance = new login();
        String expResult = "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length";
        String result = instance.registerUser(username, password);
        assertEquals(expResult, result);
        
    }

    @Test
    public void testLoginUser() {
        System.out.println("loginUser");
        String username = "kyl_1";
        String password = "mishsSpace34@"; 
        login instance = new login();
        instance.registerUser(username, password);
        boolean expResult = true;
        boolean result = instance.loginUser(username, password);
        assertEquals(expResult, result);
        
    }

    @Test
    public void testReturnLoginStatus() {
        System.out.println("returnLoginStatus");
        boolean LoggedIn = false;
        String firstName = "";
        String surname = "";
        login instance = new login();
        String expResult = "Welcome" + firstName + surname + "it is great to see you again";
        String result = instance.returnLoginStatus(LoggedIn, firstName, surname);
        assertEquals(expResult, result);
       
    }
    
}

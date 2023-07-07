
package poe;

import org.junit.Test;
import static org.junit.Assert.*;

public class loginTest {
    
    public loginTest() {
    }

    @Test
    public void testCheckUserName() {  //W3Schools, 2023
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
    public void testRegisterUser() {//(Farrell, 2019)
        System.out.println("registerUser");
        String username = "";
        String password = "";
        login instance = new login();
        String expResult = "Username is not correctly formatted, please ensure that your "
                + "username contains an underscore and is no more than 5 characters in length";
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
    public void testReturnLoginStatus() { //Mandiya, 2021
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

// Mandliya, A. 2021. Validate Password in Java, 11 January 2021. [Online]. Available at: https://java2blog.com/validate-password-java/[Accessed 2 May 2023]
// Farrel. J. 2018. Java Programming. 9th ed. Boston; Cengage.
// W3Schools.com. 2023. Java Methods. [Online]. Available at: https://www.w3schools.com/java/java_methods.asp.[Accessed 2 May 2023]
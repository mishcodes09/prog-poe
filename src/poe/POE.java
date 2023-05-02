
package poe;

import javax.swing.JOptionPane;

public class POE {

    public static void main(String[] args) {
        
// creating an account:         

        String firstName = JOptionPane.showInputDialog("Please enter your first name: "); // (Farrel, 2018)
        String surname = JOptionPane.showInputDialog("Please enter your surname: "); // (Farrel, 2018)
         
        login b1 = new login();
        boolean registration = false;
        boolean loggedIn = false; 
        
        //loop for checking the registration
        while (registration == false){
            String username = JOptionPane.showInputDialog("Please enter your username: ");
            String password = JOptionPane.showInputDialog("Please enter your password: ");
        
            registration = b1.registerUser(username, password).equals("User registered!!");
            
            JOptionPane.showMessageDialog(null, b1.registerUser(username, password));
        }
        
        while (loggedIn == false){
            String username = JOptionPane.showInputDialog("Please enter your username: ");
            String password = JOptionPane.showInputDialog("Please enter your password: ");

            loggedIn = b1.loginUser(username, password);
            
            JOptionPane.showMessageDialog(null,b1.returnLoginStatus(loggedIn, firstName, surname));
        }
    }
}

// Farrel. J. 2018. Java Programming. 9th ed. Boston; Cengage. 
    
           
         
        


    

    


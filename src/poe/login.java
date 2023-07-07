package poe;

public class login {

    String yourUsername, yourPassword;

    //entering the username 
    public boolean checkUserName(String username) { //W3Schools, 2023
        return username.length() <= 5 && (username.contains("_"));
    }

    //checking password
    public boolean checkPasswordComplexity(String password) {  
        boolean isValid = true;
        if (password.length() < 8) {
            isValid = false;
        }
        String capitals = "(.*[A-Z].*)";
        if (!password.matches(capitals)) {
            isValid = false;
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers)) {
            isValid = false;
        }
        String characters = "(.*[@,#,$,%].*$)";
        if (!password.matches(characters)) {
            isValid = false;
        }
        return isValid;
    }
    
    //checking register user
    public String registerUser(String username, String password) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length";
        } else if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character";
        } else {
            yourUsername = username;
            yourPassword = password;
            return "User registered!!";
        }
    }

    public boolean loginUser(String username, String password) {
        return (yourUsername.equals(username) && yourPassword.equals(password));
    }

    public String returnLoginStatus(boolean LoggedIn, String firstName, String surname) {
        if (LoggedIn = true) {
            return "Welcome" + firstName + surname + "it is great to see you again";
        } else {
            return "Username or password incorrect, please try again";
        }
    }

}

// Mandliya, A. 2021. Validate Password in Java, 11 January 2021. [Online]. Available at: https://java2blog.com/validate-password-java/[Accessed 2 May 2023]
// Farrel. J. 2018. Java Programming. 9th ed. Boston; Cengage.
// W3Schools.com. 2023. Java Methods. [Online]. Available at: https://www.w3schools.com/java/java_methods.asp.[Accessed 2 May 2023]
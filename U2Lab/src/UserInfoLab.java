import java.util.Scanner;
public class UserInfoLab {
    public static void main(String[] args) {
        // Part 1
        // Create a Scanner for keyboard input

        Scanner scanner = new Scanner(System.in);
        // Ask the user to enter their first and last name and pass these
        // values to the generateUsername method and save the returned result.
        System.out.println("Enter your first name");
        String firstName = scanner.nextLine();
        System.out.println("Enter your last name");
        String lastName = scanner.nextLine();
        String username = generateUsername(firstName,lastName);
        System.out.println(username);
        // Part 2
        // Ask the user to enter a password and pass this value to the validatePassword method.
        // The validatePassword method will check if the password meets the criteria:
        System.out.println("Enter your password");
        String password = scanner.nextLine();
        boolean passwordV = validatePassword(password);
        System.out.println(passwordV);
        // Part 3
        // If the user entered a valid password in step 2, then ask the user to enter their
        // credit card number and pass this value to the maskCreditCard method.
        if(passwordV){
            System.out.println("Enter your credit card number");
            String creditCard = scanner.nextLine();
            String maskCC = maskCreditCard(creditCard);
            System.out.println(maskCC);
        }
        // Part 4
        // If the user entered a valid password AND valid credit card number, display the output
        // as shown in the demo video
        // https://drive.google.com/file/d/1sMOw5wkOgSfuUcvQhFyZ5flnv_d9qQd3/view?usp=sharing

    }

    public static String generateUsername(String firstName, String lastName) {
        // Fill in this method and return an appropriate username

        if(firstName.length()<3&&lastName.length()<3){
            return firstName.toLowerCase()+lastName.toLowerCase();
        }else if(firstName.length()<3){
            return firstName.toLowerCase()+lastName.toLowerCase().substring(0,3);
        }else if(lastName.length()<3){
            return firstName.toLowerCase().substring(0,3)+lastName.toLowerCase();
        }else{
            return firstName.toLowerCase().substring(0,3)+lastName.toLowerCase().substring(0,3);
        }


    }
    public static boolean validatePassword(String password) {
        // Fill in this method and return true/false if the password is valid
        boolean isUpperCase = false;
        boolean isDigit = false;
        boolean islen = false;
        if(password.length()>=8){

            islen = true;
        }
        if(!islen){
            System.out.println("Less than 8 characters long");
            return false;
        }

        for(int i = 0; i<password.length();i++){
                if(Character.isUpperCase(password.charAt(i))) {
                    isUpperCase = true;
                }
                if(containsDigit(password)){
                    isDigit = true;
                }
        }
        if(!isUpperCase){
            System.out.println("Do no contain uppercase letter");
            return false;
        }
        if(!isDigit){
            System.out.println("Do not contain digit");
            return false;
        }

        return isUpperCase && isDigit && islen;
    }
    public static String maskCreditCard(String creditCardNumber) {
        // Fill in this method and if the credit card is valid, return a masked CC
        
        if(allDigits(creditCardNumber)&&creditCardNumber.length()==16){



            return "**** **** **** "+creditCardNumber.substring(12,16);
        }else{
            return "N/A";
        }




    }

    /**
     This method verifies that the string contains at least one numeric digit
     @param str The string to check
     @return true or false if a digit is present
     */
    public static boolean containsDigit(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (Character.isDigit(c))
                return true;
        }
        return false;
    }

    /**
     * Checks if the entire String is all numerical
     * @param str The string to check
     * @return true or false if the string is ALL digits
     */
    public static boolean allDigits(String str) {
        char[] chars = str.toCharArray();
        for (char c: chars) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

}

import java.util.Scanner;

public class tryCatch extends Exception{

    public static class Validation{
        public static void isValid(String password){

        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Password Make sure to have 1 Number and 1 Special Character");
        String password  = sc.nextLine();
        System.out.println("Password Entered: "+password);
        System.out.println("Closing vGuess game");
    }
}

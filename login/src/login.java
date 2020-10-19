import java.util.Scanner;
import java.util.regex.Pattern;

/**Write java program where user will enter loginid and password as input. 
 * The password should be 8 digit containing one digit and one special symbol. 
 * If user enter valid password satisfying above criteria then show “Login Successful" Message”. 
 * If user enter invalid Password then create InvalidPasswordException stating 
 * Please enter valid password of length 8 containing one digit and one Special Symbol. 
 *
 * @author Deepankar Bhade
 */
class login extends Exception{

    int passwordConditionViolated=0;

    public login(int conditionViolated) {
        passwordConditionViolated=conditionViolated;
    }

    public String printMessage() {
        switch(passwordConditionViolated) {
            case 1: return("Password Length should be 8 characters");
            case 2: return("Password should contain at least one digit(0-9)");
            case 3: return("Password should contain at least one special character");
        }
        return("");
    }

}


public class Password {
    public static void main(String[] args) {
        System.out.println("Enter your username");
        Scanner in=new Scanner(System.in);
        String username=in.nextLine();

        System.out.println("Enter your password");
        String password=in.nextLine();
        try {

            isValid(password);
            System.out.println("Login Successful ");
        }
        catch(login e) {
            System.out.println(e.printMessage());
        }


    }

    private static void isValid(String password) throws login {
        // TODO Auto-generated method stub
        if (password.length()<8) {
            throw new login(1);
        }
        if(true) {
            int count=0;
            //check digits from 0 to 9
            for (int i=0;i<=9;i++) {
                String str1=Integer.toString(i);
                if(password.contains(str1)) {
                    count=1;
                }
            }
            if(count==0) {
                throw new login(2);
            }
        }
        Pattern specialCharPattern=Pattern.compile("[^a-z0-9]",Pattern.CASE_INSENSITIVE);

        if(!specialCharPattern.matcher(password).find()) {
            throw new InvalidPasswordException(3);
        }
    }
}
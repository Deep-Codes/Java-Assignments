import java.util.Scanner;

public class recursionSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number: ");
        int number = sc.nextInt();
        int sum = addNumbers(number);
        System.out.println("Sum = " + sum);
    }

    public static int addNumbers(int num) {
            if (num != 0)
                return num + addNumbers(num - 1);
            else
                return num;
    }
}

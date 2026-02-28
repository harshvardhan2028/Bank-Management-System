import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();

        while(true) {

            System.out.println("\n1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.println("Enter Name:");
                    String name = sc.next();
                    System.out.println("Enter Balance:");
                    double bal = sc.nextDouble();
                    bank.createAccount(new Account(name, bal));
                    break;

                case 2:
                    System.out.println("Enter Account No:");
                    int accNo = sc.nextInt();
                    System.out.println("Enter Amount:");
                    double amt = sc.nextDouble();
                    bank.deposit(accNo, amt);
                    break;

                case 3:
                    System.out.println("Enter Account No:");
                    int accNo2 = sc.nextInt();
                    System.out.println("Enter Amount:");
                    double amt2 = sc.nextDouble();
                    bank.withdraw(accNo2, amt2);
                    break;

                case 4:
                    System.out.println("Enter Account No:");
                    bank.checkBalance(sc.nextInt());
                    break;

                case 5:
                    System.exit(0);
            }
        }
    }
}
import java.util.Scanner;

public class AtmMachine 

{

    private static Scanner in ;
    private static float balance = 5000; // initialising balance to 5000 ruppees
    private static int anotherTransaction;

    public static void main(String args[]) {
        in = new Scanner(System.in);
        transaction();
    }

    private static void transaction()
    
    {
        
    // taking choice from customer for atm machine
        int choice;

        System.out.println("Please select an option");
        System.out.println("1. Withdrawl");
        System.out.println("2. Deposit");
        System.out.println("3. Balance");

        choice = in .nextInt();

        switch (choice) 
        
        {
            case 1:
                float amount;
                System.out.println("Please enter amount to withdraw: ");
                amount = in .nextFloat();

                if (amount > balance || amount == 0)
                 {
                    System.out.println("You have insufficient funds\n\n");
                    anotherTransaction(); // For another transaction
                
                } 

                else {
                    // update the balance after transaction
                    balance = balance - amount;
                    System.out.println("You have withdrawn " + amount + " and your new balance is " + balance + "\n");
                    anotherTransaction();
                }
                break;

            case 2:
                // to deposit amount
                float deposit;
                System.out.println("Please enter amount you would wish to deposit: ");
                deposit = in .nextFloat();
                // update balance after depositing amount
                balance = deposit + balance;
                System.out.println("You have deposited " + deposit + " new balance is " + balance + "\n");
                anotherTransaction();
                break;

            case 3:
                // to check balance 
                System.out.println("Your balance is " + balance + "\n");
                anotherTransaction();
                break;

            default:

            //default message if invalid option
                System.out.println("Invalid option:\n\n");
                anotherTransaction();
                break;
        }

    }
//function for another transaction


    private static void anotherTransaction() 
    {
        System.out.println("Do you want another transaction?\n\nPress 1 for another transaction\n2 To exit");
        anotherTransaction = in .nextInt();
        if (anotherTransaction == 1) 
        {
            transaction(); // calling transaction method
        } 
        else if (anotherTransaction == 2)
        {
            System.out.println("Thanks for choosing us. Good Bye!");
        } 
        else 
        {
            System.out.println("Invalid choice\n\n");
            anotherTransaction();
        }
    }
}
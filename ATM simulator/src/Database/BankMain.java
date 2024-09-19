package Database;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        DatabaseUtility database = new DatabaseUtility(); 
        Scanner input = new Scanner(System.in);

        for(int i=0; i<3; i++) {
            System.out.print("What's you name: ");
            String name = input.nextLine();

            System.out.print("What's your salery: ");
            int salery = input.nextInt();
            input.nextLine();

            database.insertStudentData(name, salery);
        } 

        input.close();

    }
}

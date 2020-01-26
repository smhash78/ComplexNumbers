import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String menu = "Choose your choise: \n" +
                "0. Exit\n" +
                "01. Add or sub some numbers\n" +
                "02. Mul two numbers\n" +
                "03. Div two numbers\n" +
                "04. Calculate sin(z)\n" +
                "05. Calculate cos(z)\n" +
                "06. Calculate tan(z)\n" +
                "07. Calculate cot(z)\n" +
                "08. Calculate Len(z)\n" +
                "09. Calculate len(z)\n" +
                "10. Calculate z^n\n" +
                "11. Calculate radical(z)";
        System.out.println(menu);
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String input;
        int choice = scan.nextInt();
        while (choice != 0) { // Main Loop
            if (choice == 1) {
                System.out.println("Import numbers: ");
                input = bufferRead.readLine();
                Function.addNumbers(input);
            }
            else if (choice == 2) {
                Function.mulNumbers();
            }
            else if (choice == 3) {
                Function.divNumbers();
            }
            else if (choice == 4) {
                System.out.println("Enter number: ");
                input =bufferRead.readLine();
                Function.sin(input);
            }
            else if (choice == 5) {
                System.out.println("Enter number: ");
                input =bufferRead.readLine();
                Function.cos(input);
            }
            else if (choice == 6) {
                Function.divNumbers();
            }
            else if (choice == 7) {
                Function.divNumbers();
            }
            else if (choice == 8) {
                System.out.println("Enter number: ");
                input =bufferRead.readLine();
                Function.len(input, 0);
            }
            else if (choice == 9) {
                System.out.println("Enter number: ");
                input =bufferRead.readLine();
                System.out.println("Enter k:");
                choice = scan.nextInt();
                Function.len(input, choice);
            }
            else if (choice == 10) {
                System.out.println("Enter number: ");
                input =bufferRead.readLine();
                System.out.println("Enter n: ");
                choice = scan.nextInt();
                Function.power(input, choice);
            }
            else if (choice == 11) {
                System.out.println("Enter number: ");
                input =bufferRead.readLine();
                System.out.println("Enter n: ");
                choice = scan.nextInt();
                Function.radical(input, choice);
            }
            else {
                System.out.println("Invalid choice.");
            }
            System.out.println(menu);
            choice = scan.nextInt();
        }
        scan.close();

    }
}
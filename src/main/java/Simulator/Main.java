package Simulator;

import Ducks.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static Simulator.CounterSimulator.quackCounts;
import static Simulator.FlockSimulator.*;
import static Simulator.CreateDuckSimulator.*;

public class Main {
    public static Scanner scanner=new Scanner(System.in);;
    public static List<IQuackable> ducks = new ArrayList<IQuackable>();

    public static void prompt(){
        System.out.println("1. Create Duck");
        System.out.println("2. Add Duck to Flock");
        System.out.println("3. Make a Duck in Flock Quack");
        System.out.println("4. Make Ducks Quack");
        System.out.println("5. Show Quack Counts");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {
        init();
        while (true) {
            prompt();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    create();
                    break;

                case 2:
                    addToFlock();
                    break;

                case 3:
                    duckQuack();
                    break;
                case 4:
                    flockQuack();
                    break;

                case 5:
                    quackCounts();
                    break;

                case 6:
                    quackListenerFile.closeFile();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

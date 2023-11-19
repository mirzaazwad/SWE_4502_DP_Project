package Simulator;

import Ducks.*;
import Factory.CountingDuckFactory;
import Observer.QuackListenerConsole;
import Observer.QuackListenerFile;
import Wrappers.QuackIterator;
import Wrappers.QuackManagerDecorator;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner=new Scanner(System.in);;
    private static List<IQuackable> ducks = new ArrayList<IQuackable>();
    private static Flock flock = new Flock();
    private static CountingDuckFactory duckFactory = new CountingDuckFactory();
    private static QuackListenerConsole quackListenerConsole=new QuackListenerConsole();
    private static QuackListenerFile quackListenerFile = new QuackListenerFile("quack_log.txt");

    private static void prompt(){
        System.out.println("1. Create Duck");
        System.out.println("2. Add Duck to Flock");
        System.out.println("3. Make a Duck in Flock Quack");
        System.out.println("4. Make Ducks Quack");
        System.out.println("5. Show Quack Counts");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void init(){
        try {
            FileWriter fileWriter = new FileWriter("quack_log.txt", true);
            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            fileWriter.append(dtf.format(date) + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void duckQuack(){
        System.out.println("Make a Duck in Flock Quack");
        System.out.println(flock.getName());
        int flockIndex = scanner.nextInt();
        flock.getDucks().get(flockIndex - 1).quack();
    }

    private static void flockQuack(){
        System.out.println("Making Flock Quack:");
        System.out.println(flock.quack());
    }
    private static void addToFlock(){
        System.out.println("Select Duck to Add to Flock:");
        for (int i = 1; i <= ducks.size(); i++) {
            System.out.printf("%d: " + ducks.get(i - 1).getName() + "\n", i);
        }
        int duckIndex = scanner.nextInt();
        flock.add(ducks.get(duckIndex - 1));
        System.out.println(ducks.get(duckIndex - 1).getName() + " added to the flock.");
        ducks.remove(duckIndex - 1);
    }

    private static void create(){
        System.out.println("Enter Duck Type (mallard, marbled, alabio, rubber, wooden, goose): ");
        String duckType = scanner.nextLine().toLowerCase();
        System.out.println("Enter Duck Name: ");
        String duckName = scanner.nextLine();

        try {
            QuackManagerDecorator duck = new QuackManagerDecorator(duckFactory.createDuck(duckType, duckName));
            duck.subscribe(quackListenerConsole);
            duck.subscribe(quackListenerFile);
            ducks.add(duck);
            System.out.println("Duck created");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void quackCounts(){
        System.out.println("Quack Counts:");
        QuackIterator quackIterator = new QuackIterator(flock.getDucks());
        while (quackIterator.hasNext()) {
            QuackManagerDecorator currentDuck = (QuackManagerDecorator)quackIterator.next();
            System.out.println(currentDuck.getName() + ": " +
                    currentDuck.getDuck().getQuack_count() + " quacks");
        }
    }

    public static void main(String[] args) {

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

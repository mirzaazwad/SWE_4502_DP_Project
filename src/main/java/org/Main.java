package org;

import Ducks.*;
import Factory.CountingDuckFactory;
import Observer.QuackListenerFile;
import Wrappers.CounterDecorator;
import Wrappers.QuackIterator;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            FileWriter fileWriter = new FileWriter("quack_log.txt", true);
            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            fileWriter.append(dtf.format(date) + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        CountingDuckFactory duckFactory = new CountingDuckFactory();
        QuackListenerFile quackListenerFile = new QuackListenerFile("quack_log.txt");
        List<IQuackable> ducks = new ArrayList<IQuackable>();
        Flock flock = new Flock();

        while (true) {
            System.out.println("1. Create Duck");
            System.out.println("2. Add Duck to Flock");
            System.out.println("3. Make a Duck in Flock Quack");
            System.out.println("4. Make Ducks Quack");
            System.out.println("5. Show Quack Counts");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Duck Type (mallard, marbled, alabio, rubber, wooden, goose): ");
                    String duckType = scanner.nextLine().toLowerCase();
                    System.out.println("Enter Duck Name: ");
                    String duckName = scanner.nextLine();

                    try {
                        IQuackable duck = duckFactory.createCountingDuck(duckType, duckName);
                        duck.addSubscriber(quackListenerFile);
                        ducks.add(duck);
                        System.out.println("Duck created");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Select Duck to Add to Flock:");
                    for (int i = 1; i <= ducks.size(); i++) {
                        System.out.printf("%d: " + ducks.get(i - 1).getName() + "\n", i);
                    }
                    int duckIndex = scanner.nextInt();
                    flock.add(ducks.get(duckIndex - 1));
                    System.out.println(ducks.get(duckIndex - 1).getName() + " added to the flock.");
                    ducks.remove(duckIndex - 1);
                    break;

                case 3:
                    System.out.println("Make a Duck in Flock Quack");
                    System.out.println(flock.getName());
                    ;
                    int flockIndex = scanner.nextInt();
                    flock.getDucks().get(flockIndex - 1).quack();
                    break;
                case 4:
                    System.out.println("Making Flock Quack:");
                    System.out.println(flock.quack());
                    break;

                case 5:
                    System.out.println("Quack Counts:");
                    QuackIterator quackIterator = new QuackIterator(flock.getDucks());
                    while (quackIterator.hasNext()) {
                        IQuackable currentDuck = quackIterator.next();
                        System.out.println(currentDuck.getName() + ": " +
                                ((CounterDecorator) currentDuck).getQuackCount() + " quacks");
                    }
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

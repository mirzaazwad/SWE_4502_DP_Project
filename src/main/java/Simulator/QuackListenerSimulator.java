package Simulator;

import Observer.ConsoleObserver;
import Observer.FileObserver;
import Wrappers.QuackSubjectDecorator;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static Simulator.CounterSimulator.duckFactory;
import static Simulator.Main.*;

public class QuackListenerSimulator {
    public static ConsoleObserver quackListenerConsole=new ConsoleObserver();
    public static FileObserver quackListenerFile = new FileObserver("quack_log.txt");

    public static void init(){
        try {
            FileWriter fileWriter = new FileWriter("quack_log.txt", true);
            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            fileWriter.append("Accessed At: "+dtf.format(date) + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void create(){
        System.out.println("Enter Duck Type (mallard, marbled, alabio, rubber, wooden, goose): ");
        String duckType = scanner.nextLine().toLowerCase();
        System.out.println("Enter Duck Name: ");
        String duckName = scanner.nextLine();

        try {
            QuackSubjectDecorator duck = new QuackSubjectDecorator(duckFactory.createDuck(duckType, duckName));
            duck.subscribe(quackListenerConsole);
            duck.subscribe(quackListenerFile);
            ducks.add(duck);
            System.out.println("Duck created");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

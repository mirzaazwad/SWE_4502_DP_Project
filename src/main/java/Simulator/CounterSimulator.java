package Simulator;

import Factory.DuckFactory;
import Wrappers.DuckIterator;
import Wrappers.QuackSubjectDecorator;

import static Simulator.FlockSimulator.flock;

public class CounterSimulator {
    public static DuckFactory duckFactory = new DuckFactory();
    public static void quackCounts(){
        if(flock.getDucks().size()==0){
            System.out.println("No Ducks in Flock");
            return;
        }
        System.out.println("Quack Counts:");
        DuckIterator quackIterator = new DuckIterator(flock.getDucks());
        while (quackIterator.hasNext()) {
            QuackSubjectDecorator currentDuck = (QuackSubjectDecorator)quackIterator.next();
            System.out.println(currentDuck.getName() + ": " +
                    currentDuck.getDuck().getQuack_count() + " quacks");
        }
    }
}

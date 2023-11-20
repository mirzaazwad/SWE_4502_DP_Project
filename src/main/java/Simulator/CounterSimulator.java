package Simulator;

import Factory.DuckFactory;
import Wrappers.QuackIterator;
import Wrappers.QuackManagerDecorator;

import static Simulator.FlockSimulator.flock;

public class CounterSimulator {
    public static DuckFactory duckFactory = new DuckFactory();
    public static void quackCounts(){
        if(flock.getDucks().size()==0){
            System.out.println("No Ducks in Flock");
            return;
        }
        System.out.println("Quack Counts:");
        QuackIterator quackIterator = new QuackIterator(flock.getDucks());
        while (quackIterator.hasNext()) {
            QuackManagerDecorator currentDuck = (QuackManagerDecorator)quackIterator.next();
            System.out.println(currentDuck.getName() + ": " +
                    currentDuck.getDuck().getQuack_count() + " quacks");
        }
    }
}

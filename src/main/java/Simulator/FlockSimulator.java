package Simulator;

import Ducks.Flock;

import static Simulator.Main.ducks;
import static Simulator.Main.scanner;

public class FlockSimulator {
    public static Flock flock = new Flock();
    public static void duckQuack(){
        if(flock.getDucks().size()==0){
            System.out.println("No Ducks In Flock");
            return;
        }
        System.out.println("Make a Duck in Flock Quack");
        System.out.println(flock.getName());
        int flockIndex = scanner.nextInt();
        if(flockIndex>flock.getDucks().size()){
            System.out.println("Flock has only "+flock.getDucks().size()+" ducks");
            System.out.printf("Flock does not have %d ducks\n",flockIndex);
            return;
        }
        flock.getDucks().get(flockIndex - 1).quack();
    }

    public static void flockQuack(){
        if(flock.getDucks().size()==0){
            System.out.println("No Ducks In Flock");
            return;
        }
        System.out.println("Making Flock Quack:");
        System.out.println(flock.quack());
    }
    public static void addToFlock(){
        if(ducks.size()==0){
            System.out.println("No Ducks In Buffer");
            return;
        }
        System.out.println("Select Duck to Add to Flock:");
        for (int i = 1; i <= ducks.size(); i++) {
            System.out.printf("%d: " + ducks.get(i - 1).getName() + "\n", i);
        }
        int duckIndex = scanner.nextInt();
        if(duckIndex>ducks.size()){
            System.out.printf("There are only %d ducks in buffer\n",ducks.size());
            return;
        }
        flock.add(ducks.get(duckIndex - 1));
        System.out.println(ducks.get(duckIndex - 1).getName() + " added to the flock.");
        ducks.remove(duckIndex - 1);
    }
}

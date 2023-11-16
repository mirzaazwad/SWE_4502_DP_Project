package Ducks;

import Birds.IBird;
import DuckTracker.ILocator;

public class DuckAdapter implements IQuackable {
    private IBird bird;
    public DuckAdapter(IBird bird){
        this.bird=bird;
    }

    public String getName(){
        return this.bird.getName();
    }

    public String quack(){
        return this.bird.makeSound();
    }


}

package Ducks;

import Abstractions.IBird;
import Abstractions.IQuackable;

public class DuckAdapter implements IQuackable{
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

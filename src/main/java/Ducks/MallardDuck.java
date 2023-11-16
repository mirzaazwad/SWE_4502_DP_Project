package Ducks;

import DuckTracker.ILocator;

public class MallardDuck implements IQuackable {
    private String name;
    public MallardDuck(String name){
        this.name=name;
    }

    public String quack(){
        return "Quack Quack";
    }

    public String getName(){
        return this.name;
    }

}

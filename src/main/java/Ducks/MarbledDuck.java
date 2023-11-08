package Ducks;

import Abstractions.IQuackable;

public class MarbledDuck implements IQuackable {
    private String name;
    public MarbledDuck(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public String quack(){
        return "Quack Quack Quack";
    }
}

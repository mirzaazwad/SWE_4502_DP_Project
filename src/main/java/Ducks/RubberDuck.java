package Ducks;

import Quack.IQuackable;

public class RubberDuck implements IQuackable {
    private String name;
    public RubberDuck(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public String quack(){
        return "Squeak";
    }
}

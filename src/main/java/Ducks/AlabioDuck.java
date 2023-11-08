package Ducks;

import Quack.IQuackable;

public class AlabioDuck implements IQuackable {
    private String name;
    public AlabioDuck(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public String quack(){
        return "Alabian Quack";
    }
}

package Wrappers;

import Ducks.IQuackable;

public class CounterDecorator implements IQuackable{
    private IQuackable duck;
    private Integer quack_count;

    public CounterDecorator(IQuackable duck){
        this.duck=duck;
        this.quack_count=0;
    }

    public String getName(){
        return this.duck.getName();
    }
    public String quack(){
        this.quack_count++;
        return duck.quack();
    }

    public Integer getQuackCount(){
        return this.quack_count;
    }
}

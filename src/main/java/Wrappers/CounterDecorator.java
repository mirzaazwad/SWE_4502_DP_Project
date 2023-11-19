package Wrappers;

import Ducks.IQuackable;
import Observer.IQuackListener;

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
        return String.format(this.duck.quack()+"ed %d times",this.quack_count);
    }

    public Integer getQuack_count(){
        return this.quack_count;
    }
}

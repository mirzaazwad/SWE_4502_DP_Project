package Wrappers;

import Ducks.IQuackable;
import Observer.IQuackListener;
import Observer.QuackManager;

import java.util.ArrayList;

public class QuackManagerDecorator extends QuackManager implements IQuackable {
    private CounterDecorator duck;

    public QuackManagerDecorator(IQuackable duck){
        this.listeners=new ArrayList<IQuackListener>();
        this.duck=new CounterDecorator(duck);
    }

    public CounterDecorator getDuck(){
        return this.duck;
    }

    public String getName(){
        return this.duck.getName();
    }
    public String quack(){
        String quack=this.duck.quack();
        this.notify(quack);
        return quack;
    }
}

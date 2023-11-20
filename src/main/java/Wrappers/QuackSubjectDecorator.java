package Wrappers;

import Ducks.IQuackable;
import Observer.IQuackObserver;
import Observer.QuackSubject;

import java.util.ArrayList;

public class QuackSubjectDecorator extends QuackSubject implements IQuackable {
    private CounterDecorator duck;

    public QuackSubjectDecorator(IQuackable duck){
        this.listeners=new ArrayList<IQuackObserver>();
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

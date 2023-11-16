package Ducks;

import DuckTracker.ILocator;
import Wrappers.QuackIterator;

import java.util.ArrayList;
import java.util.List;

public class Flock implements IQuackable {
    private List<IQuackable> ducks;
    public Flock(){
        this.ducks=new ArrayList<IQuackable>();
    }

    public void add(IQuackable duck){
        this.ducks.add(duck);
    }

    public String quack(){
        QuackIterator quackIterator=new QuackIterator(ducks);
        String result="";
        while (quackIterator.hasNext()){
            IQuackable current_duck=quackIterator.next();
            result+=(current_duck.quack()+"\n");
        }
        return result;
    }

    public String getName(){
        QuackIterator quackIterator=new QuackIterator(ducks);
        String result="";
        while (quackIterator.hasNext()){
            IQuackable current_duck=quackIterator.next();
            result+=(current_duck.getName()+"\n");
        }
        return result;
    }
    public List<IQuackable> getDucks(){
        return this.ducks;
    }
}

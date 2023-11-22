package Ducks;
import Wrappers.DuckIterator;

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
        DuckIterator quackIterator=new DuckIterator(ducks);
        String result="";
        while (quackIterator.hasNext()){
            IQuackable current_duck=quackIterator.next();
            result+=(current_duck.quack()+"\n");
        }
        return result;
    }

    public String getName(){
        DuckIterator quackIterator=new DuckIterator(ducks);
        String result="";
        Integer i=1;
        while (quackIterator.hasNext()){
            IQuackable current_duck=quackIterator.next();
            result+=(i.toString()+". "+current_duck.getName()+"\n");
            i+=1;
        }
        return result;
    }

    public List<IQuackable> getDucks(){
        return this.ducks;
    }
}

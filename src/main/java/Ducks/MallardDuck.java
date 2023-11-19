package Ducks;

import Observer.IQuackListener;
import Observer.QuackManager;

public class MallardDuck implements IQuackable {
    private String name;
    private QuackManager quackManager;
    public MallardDuck(String name){
        this.quackManager=new QuackManager();
        this.name=name;
    }

    public void addSubscriber(IQuackListener quackListener){
        this.quackManager.subscribe(quackListener);
    }

    public String quack(){
        quackManager.notify(this.getName()+", Mallard Duck has Quacked");
        return "Quack";
    }

    public String getName(){
        return this.name;
    }

}

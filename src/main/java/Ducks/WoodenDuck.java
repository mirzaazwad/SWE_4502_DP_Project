package Ducks;

import Observer.IQuackListener;
import Observer.QuackManager;

public class WoodenDuck implements IQuackable {
    private String name;
    private QuackManager quackManager;
    public WoodenDuck(String name){
        this.quackManager=new QuackManager();
        this.name=name;
    }

    public void addSubscriber(IQuackListener quackListener){
        this.quackManager.subscribe(quackListener);
    }

    public String getName(){
        return this.name;
    }

    public String quack(){
        quackManager.notify(this.getName()+", Wooden Duck makes sound");
        return "";
    }
}

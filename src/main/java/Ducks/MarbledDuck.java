package Ducks;


import Observer.IQuackListener;
import Observer.QuackManager;

public class MarbledDuck implements IQuackable {
    private String name;
    private QuackManager quackManager;
    public MarbledDuck(String name){
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
        quackManager.notify(this.getName()+", Marbled Duck has Quacked");
        return "Quack";
    }
}

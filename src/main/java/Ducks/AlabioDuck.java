package Ducks;


import Observer.IQuackListener;
import Observer.QuackManager;

public class AlabioDuck implements IQuackable {
    private String name;
    private QuackManager quackManager;
    public AlabioDuck(String name){
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
        quackManager.notify(this.getName()+", Alabio Duck has Quacked");
        return "Quack";
    }

}

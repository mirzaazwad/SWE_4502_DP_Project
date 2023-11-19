package Ducks;

import Birds.IBird;
import Observer.IQuackListener;
import Observer.QuackManager;

public class DuckAdapter implements IQuackable {
    private IBird bird;
    private QuackManager quackManager;
    public DuckAdapter(IBird bird){
        this.quackManager=new QuackManager();
        this.bird=bird;
    }

    public void addSubscriber(IQuackListener quackListener){
        this.quackManager.subscribe(quackListener);
    }

    public String getName(){
        return this.bird.getName();
    }

    public String quack(){
        quackManager.notify(this.bird.getName()+", "+this.bird.getClass().getSimpleName()+" has "+this.bird.makeSound()+"ed");
        return this.bird.makeSound();
    }


}

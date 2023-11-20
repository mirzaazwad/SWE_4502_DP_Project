package Ducks;

import Birds.IBird;

public class DuckAdapter extends DuckIdentification implements IQuackable {
    private IBird bird;
    public DuckAdapter(IBird bird){
        super();
        this.bird=bird;
    }
    public String getName(){
        return this.bird.getName();
    }

    public String quack(){
        return this.getID()+". "+this.getName()+", "+this.getClass().getSimpleName()+"->"+this.bird.makeSound();
    }


}

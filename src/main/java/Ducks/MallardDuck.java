package Ducks;

public class MallardDuck extends DuckIdentification implements IQuackable {
    private String name;
    public MallardDuck(String name){
        super();
        this.name=name;
    }


    public String quack(){
        return this.getID()+". "+this.getName()+", "+this.getClass().getSimpleName()+"->"+"Quack";
    }

    public String getName(){
        return this.name;
    }

}

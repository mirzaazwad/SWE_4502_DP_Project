package Ducks;

public class MarbledDuck extends DuckIdentification implements IQuackable {
    private String name;
    public MarbledDuck(String name){
        super();
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public String quack(){
        return this.getID()+". "+this.getName()+", "+this.getClass().getSimpleName()+"->"+"Quack";
    }
}

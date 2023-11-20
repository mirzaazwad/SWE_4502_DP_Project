package Ducks;

public class WoodenDuck extends DuckIdentification implements IQuackable {
    private String name;
    public WoodenDuck(String name){
        super();
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

    public String quack(){
        return this.getID()+". "+this.getName()+", "+this.getClass().getSimpleName()+"->"+"No Sound";
    }
}

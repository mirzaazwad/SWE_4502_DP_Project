package Ducks;

public class AlabioDuck extends DuckIdentification implements IQuackable {
    private String name;
    public AlabioDuck(String name){
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

package Ducks;

public class AlabioDuck implements IQuackable {
    private String name;
    public AlabioDuck(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public String quack(){
        return this.getName()+", "+this.getClass().getSimpleName()+"->"+"Quack";
    }

}

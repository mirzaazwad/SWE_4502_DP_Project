package Ducks;

public class MarbledDuck implements IQuackable {
    private String name;
    public MarbledDuck(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public String quack(){
        return this.getName()+", "+this.getClass().getSimpleName()+"->"+"Quack";
    }
}

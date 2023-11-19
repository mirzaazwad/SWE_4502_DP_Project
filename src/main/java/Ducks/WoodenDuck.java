package Ducks;

public class WoodenDuck implements IQuackable {
    private String name;
    public WoodenDuck(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }

    public String quack(){
        return this.getName()+", "+this.getClass().getSimpleName()+"->"+"No Sound";
    }
}

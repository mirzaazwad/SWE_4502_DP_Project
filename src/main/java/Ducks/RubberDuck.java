package Ducks;

public class RubberDuck implements IQuackable {
    private String name;
    public RubberDuck(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }

    public String quack(){
        return this.getName()+", "+this.getClass().getSimpleName()+"->"+"Squeak";
    }
}

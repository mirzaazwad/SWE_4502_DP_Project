package Ducks;

public class MallardDuck implements IQuackable {
    private String name;
    public MallardDuck(String name){
        this.name=name;
    }


    public String quack(){
        return this.getName()+", "+this.getClass().getSimpleName()+"->"+"Quack";
    }

    public String getName(){
        return this.name;
    }

}

package Birds;

public class Goose implements IBird {
    private String name;
    public Goose(String name){
        this.name=name;
    }
    public String makeSound(){
        return "Honk";
    }

    public String getName(){
        return this.name;
    }
}

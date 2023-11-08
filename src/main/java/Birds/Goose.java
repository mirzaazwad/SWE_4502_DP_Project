package Birds;

import Abstractions.IBird;

public class Goose implements IBird {
    private String name;
    public Goose(String name){
        this.name=name;
    }
    public String makeSound(){
        return "Honk Honk";
    }

    public String getName(){
        return this.name;
    }
}

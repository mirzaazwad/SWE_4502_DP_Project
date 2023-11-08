import Abstractions.IQuackable;
import Birds.Goose;
import Ducks.*;

public class DuckFactory {
    public IQuackable createDuck(String duck,String name) throws Exception{
        if(duck.equals("mallard")){
            return new MallardDuck(name);
        }
        else if(duck.equals("marbled")){
            return new MarbledDuck(name);
        }
        else if(duck.equals("alabio")){
            return new AlabioDuck(name);
        }
        else if(duck.equals("rubber")){
            return new RubberDuck(name);
        }
        else if(duck.equals("wooden")){
            return new WoodenDuck(name);
        }
        else if(duck.equals("goose")){
            return new DuckAdapter(new Goose(name));
        }
        else{
            throw new Exception("Invalid Type");
        }
    }
}

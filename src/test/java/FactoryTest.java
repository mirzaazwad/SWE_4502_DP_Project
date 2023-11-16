import Ducks.IQuackable;
import Factory.DuckFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {
    @Test
    public void TestDuckFactory(){
        try{
            IQuackable duck=new DuckFactory().createDuck("mallard","Donald");
            assertEquals(duck.quack(),"Quack Quack");
            assertEquals(duck.getName(),"Donald");
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"");
        }
    }

    @Test
    public void TestDuckFactoryInvalid(){
        try{
            IQuackable duck=new DuckFactory().createDuck("new-type","Donald");
            assertEquals(duck.quack(),"Quack Quack");
            assertEquals(duck.getName(),"Donald");
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"Invalid Type");
        }
    }
}

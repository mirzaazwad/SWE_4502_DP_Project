import Ducks.IQuackable;
import Factory.DuckFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactoryTest {
    @Test
    public void TestDuckFactoryMallard(){
        try{
            IQuackable duck=new DuckFactory().createDuck("mallard","Donald");
            assertEquals(duck.quack(),"Donald, MallardDuck->Quack");
            assertEquals(duck.getName(),"Donald");
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"");
        }
    }

    @Test
    public void TestDuckFactoryRubber(){
        try{
            IQuackable duck=new DuckFactory().createDuck("rubber","Donald");
            assertEquals(duck.quack(),"Donald, RubberDuck->Squeak");
            assertEquals(duck.getName(),"Donald");
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"");
        }
    }

    @Test
    public void TestDuckFactoryMarbled(){
        try{
            IQuackable duck=new DuckFactory().createDuck("marbled","Donald");
            assertEquals(duck.quack(),"Donald, MarbledDuck->Quack");
            assertEquals(duck.getName(),"Donald");
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"");
        }
    }


    @Test
    public void TestDuckFactoryWooden(){
        try{
            IQuackable duck=new DuckFactory().createDuck("wooden","Donald");
            assertEquals(duck.quack(),"Donald, WoodenDuck->No Sound");
            assertEquals(duck.getName(),"Donald");
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"");
        }
    }


    @Test
    public void TestDuckFactoryAlabio(){
        try{
            IQuackable duck=new DuckFactory().createDuck("alabio","Donald");
            assertEquals(duck.quack(),"Donald, AlabioDuck->Quack");
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
            assertEquals(duck.quack(),"Quack");
            assertEquals(duck.getName(),"Donald");
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"Invalid Type");
        }
    }
}

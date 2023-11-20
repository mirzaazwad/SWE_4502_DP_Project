import Ducks.IQuackable;
import Factory.DuckFactory;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FactoryTest {
    @Test
    @Order(1)
    public void TestDuckFactoryAlabio(){
        try{
            IQuackable duck=new DuckFactory().createDuck("alabio","Donald");
            assertEquals(duck.quack(),"1. Donald, AlabioDuck->Quack");
            assertEquals(duck.getName(),"Donald");
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"");
        }
    }
    @Test
    @Order(2)
    public void TestDuckFactoryRubber(){
        try{
            IQuackable duck=new DuckFactory().createDuck("rubber","Donald");
            assertEquals(duck.quack(),"2. Donald, RubberDuck->Squeak");
            assertEquals(duck.getName(),"Donald");
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"");
        }
    }

    @Test
    @Order(3)
    public void TestDuckFactoryWooden(){
        try{
            IQuackable duck=new DuckFactory().createDuck("wooden","Donald");
            assertEquals(duck.quack(),"3. Donald, WoodenDuck->No Sound");
            assertEquals(duck.getName(),"Donald");
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"");
        }
    }

    @Test
    @Order(4)
    public void TestDuckFactoryMallard(){
        try{
            IQuackable duck=new DuckFactory().createDuck("mallard","Donald");
            assertEquals(duck.quack(),"4. Donald, MallardDuck->Quack");
            assertEquals(duck.getName(),"Donald");
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"");
        }
    }



    @Test
    @Order(5)
    public void TestDuckFactoryMarbled(){
        try{
            IQuackable duck=new DuckFactory().createDuck("marbled","Donald");
            assertEquals(duck.quack(),"5. Donald, MarbledDuck->Quack");
            assertEquals(duck.getName(),"Donald");
        }
        catch (Exception e){
            assertEquals(e.getMessage(),"");
        }
    }

    @Test
    @Order(6)
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

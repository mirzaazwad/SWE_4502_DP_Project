import Factory.CountingDuckFactory;
import Wrappers.CounterDecorator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountDuckFactoryTest {
    private Integer quacks;
    @BeforeEach
    public void init(){
        this.quacks=0;
    }

    public void setQuacks(Integer quacks){
        this.quacks=quacks;
    }

    @Test
    public void CountQuackFactoryValid10Quacks(){
        this.setQuacks(10);
        try{
            CounterDecorator quackCount=new CountingDuckFactory().createCountingDuck("mallard","Donald");
            for(int i=0;i<this.quacks;i++){
                quackCount.quack();
            }
            assertEquals(this.quacks,quackCount.getQuackCount());
        }
        catch (Exception e){
            assertEquals("",e.getMessage());
        }
    }

    @Test
    public void CountQuackFactoryValid20Quacks(){
        this.setQuacks(20);
        try{
            CounterDecorator quackCount=new CountingDuckFactory().createCountingDuck("mallard","Donald");
            for(int i=0;i<this.quacks;i++){
                quackCount.quack();
            }
            assertEquals(this.quacks,quackCount.getQuackCount());
        }
        catch (Exception e){
            assertEquals("",e.getMessage());
        }
    }

    @Test
    public void CountQuackFactoryInvalidQuacks(){
        try{
            CounterDecorator quackCount=new CountingDuckFactory().createCountingDuck("new-type","Donald");
        }
        catch (Exception e){
            assertEquals("Invalid Type",e.getMessage());
        }
    }
}

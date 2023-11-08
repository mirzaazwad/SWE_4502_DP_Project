import Ducks.MallardDuck;
import Wrappers.CounterDecorator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecoratorTest {
    @Test
    public void Test10Quacks(){
        MallardDuck duck=new MallardDuck("Donald");
        CounterDecorator countQuacks=new CounterDecorator(duck);
        for(int i=0;i<10;i++){
            countQuacks.quack();
        }
        Integer expected=10;
        assertEquals(expected,countQuacks.getQuackCount());
    }
}

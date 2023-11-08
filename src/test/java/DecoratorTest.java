import Ducks.MallardDuck;
import Wrappers.CounterDecorator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecoratorTest {
    private Integer quacks;
    @BeforeEach
    public void init(){
        this.quacks=0;
    }

    public void setQuacks(Integer quacks){
        this.quacks=quacks;
    }

    @Test
    public void Test10Quacks(){
        this.setQuacks(10);
        MallardDuck duck=new MallardDuck("Donald");
        CounterDecorator countQuacks=new CounterDecorator(duck);
        for(int i=0;i<this.quacks;i++){
            countQuacks.quack();
        }
        assertEquals(this.quacks,countQuacks.getQuackCount());
    }

    @Test
    public void Test20Quacks(){
        this.setQuacks(20);
        MallardDuck duck=new MallardDuck("Donald");
        CounterDecorator countQuacks=new CounterDecorator(duck);
        for(int i=0;i<this.quacks;i++){
            countQuacks.quack();
        }
        assertEquals(this.quacks,countQuacks.getQuackCount());
    }
}

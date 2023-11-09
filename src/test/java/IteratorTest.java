import Abstractions.IQuackable;
import Ducks.AlabioDuck;
import Ducks.MallardDuck;
import Ducks.MarbledDuck;
import Wrappers.QuackIterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class IteratorTest {
    private QuackIterator quackIterator;
    private List<String> duck_names;
    @BeforeEach
    public void init(){
        List<IQuackable> ducks=new ArrayList<IQuackable>();
        this.duck_names=new ArrayList<String>();
        this.duck_names.add("Donald");
        this.duck_names.add("Ronald");
        this.duck_names.add("Vivi");
        IQuackable mallard=new MallardDuck(duck_names.get(0));
        IQuackable marbled=new MarbledDuck(duck_names.get(1));
        IQuackable alabian=new AlabioDuck(duck_names.get(2));
        ducks.add(mallard);
        ducks.add(marbled);
        ducks.add(alabian);
        this.quackIterator=new QuackIterator(ducks);
    }
    @Test
    public void TestHasNextTrue(){
        assertTrue(quackIterator.hasNext());
    }

    @Test
    public void TestHasNextFalse(){
        quackIterator.next();
        quackIterator.next();
        quackIterator.next();
        assertFalse(quackIterator.hasNext());
    }

    @Test
    public void TestNext(){
        List<IQuackable>quack=new ArrayList<IQuackable>();
        quack.add(quackIterator.next());
        quack.add(quackIterator.next());
        quack.add(quackIterator.next());
        for(int i=0;i<3;i++){
            assertEquals(quack.get(i).getName(),this.duck_names.get(i));
        }
    }
}

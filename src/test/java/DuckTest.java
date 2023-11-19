import Ducks.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DuckTest {
    @Test
    public void TestMarbledDuck(){
        MarbledDuck marbledDuck=new MarbledDuck("Ronald");
        assertEquals("Quack",marbledDuck.quack());
        assertEquals("Ronald",marbledDuck.getName());
    }

    @Test
    public void TestMallardDuck(){
        MallardDuck mallardDuck=new MallardDuck("Donald");
        assertEquals("Quack",mallardDuck.quack());
        assertEquals("Donald",mallardDuck.getName());
    }

    @Test
    public void TestAlabioDuck(){
        AlabioDuck alabioDuck=new AlabioDuck("McDonald");
        assertEquals("Quack",alabioDuck.quack());
        assertEquals("McDonald",alabioDuck.getName());
    }

    @Test
    public void TestRubberDuck(){
        RubberDuck rubberDuck=new RubberDuck("Ducky");
        assertEquals("Squeak",rubberDuck.quack());
        assertEquals("Ducky",rubberDuck.getName());
    }

    @Test
    public void WoodenDuck(){
        WoodenDuck woodenDuck=new WoodenDuck("Bad Ducky");
        assertEquals("",woodenDuck.quack());
        assertEquals("Bad Ducky",woodenDuck.getName());
    }
}

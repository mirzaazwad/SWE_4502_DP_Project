import Ducks.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DuckTest {
    @Test
    public void TestMarbledDuck(){
        MarbledDuck marbledDuck=new MarbledDuck("Ronald");
        assertEquals("5. Ronald, MarbledDuck->Quack",marbledDuck.quack());
        assertEquals("Ronald",marbledDuck.getName());
    }

    @Test
    public void TestMallardDuck(){
        MallardDuck mallardDuck=new MallardDuck("Donald");
        assertEquals("2. Donald, MallardDuck->Quack",mallardDuck.quack());
        assertEquals("Donald",mallardDuck.getName());
    }

    @Test
    public void TestAlabioDuck(){
        AlabioDuck alabioDuck=new AlabioDuck("McDonald");
        assertEquals("4. McDonald, AlabioDuck->Quack",alabioDuck.quack());
        assertEquals("McDonald",alabioDuck.getName());
    }

    @Test
    public void TestRubberDuck(){
        RubberDuck rubberDuck=new RubberDuck("Ducky");
        assertEquals("3. Ducky, RubberDuck->Squeak",rubberDuck.quack());
        assertEquals("Ducky",rubberDuck.getName());
    }

    @Test
    public void WoodenDuck(){
        WoodenDuck woodenDuck=new WoodenDuck("Bad Ducky");
        assertEquals("1. Bad Ducky, WoodenDuck->No Sound",woodenDuck.quack());
        assertEquals("Bad Ducky",woodenDuck.getName());
    }
}

import Ducks.IQuackable;
import Ducks.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class CompositeTest {
    private static Flock flock;
    private static List<String> duck_names;

    @BeforeAll
    public static void init() {
        flock = new Flock();
        duck_names = new ArrayList<String>();
        duck_names.add("Donald");
        duck_names.add("Ronald");
        duck_names.add("Vivi");
        duck_names.add("Ducky");
        duck_names.add("Bad Ducky");
        IQuackable mallard = new MallardDuck(duck_names.get(0));
        IQuackable marbled = new MarbledDuck(duck_names.get(1));
        IQuackable alabian = new AlabioDuck(duck_names.get(2));
        IQuackable rubber = new RubberDuck(duck_names.get(3));
        IQuackable wooden = new WoodenDuck(duck_names.get(4));
        flock.add(mallard);
        flock.add(marbled);
        flock.add(alabian);
        flock.add(rubber);
        flock.add(wooden);
    }

    @Test
    public void TestQuack() {
        assertEquals("1. Donald, MallardDuck->Quack\n" +
                "2. Ronald, MarbledDuck->Quack\n" +
                "3. Vivi, AlabioDuck->Quack\n" +
                "4. Ducky, RubberDuck->Squeak\n" +
                "5. Bad Ducky, WoodenDuck->No Sound\n", flock.quack());
    }

    @Test
    public void TestGetName() {
        String expected = "";
        Integer i = 1;
        for (String dummy_duck : duck_names) {
            expected += i.toString() + ". " + dummy_duck + "\n";
            i += 1;
        }
        assertEquals(expected, flock.getName());
    }

}

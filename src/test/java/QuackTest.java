import Quack.MuteQuack;
import Quack.Quack;
import Quack.Squeak;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuackTest {
    @Test
    public void TestMuteQuack(){
        MuteQuack muteQuack=new MuteQuack();
        assertEquals("",muteQuack.quack());
    }

    @Test
    public void TestQuack(){
        Quack quackSound=new Quack();
        assertEquals("Quack Quack",quackSound.quack());
    }

    @Test
    public void TestSqueak(){
        Squeak squeak=new Squeak();
        assertEquals("Squeeaaaak",squeak.quack());
    }
}

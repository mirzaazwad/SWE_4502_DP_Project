import Birds.Goose;
import Ducks.DuckAdapter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AdapterTest {
    @Test
    public void TestGoose(){
        Goose goose=new Goose("Goose McLaughin");
        DuckAdapter duckAdapter=new DuckAdapter(goose);
        assertEquals("Goose McLaughin",duckAdapter.getName());
        assertEquals("1. Goose McLaughin, DuckAdapter->Honk",duckAdapter.quack());
    }
}

package qa.feline;

import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FelineParameterizedKittensWithArgTest {

    private final int checkedKittensCount;
    private final int expectedKittensCount;

    public FelineParameterizedKittensWithArgTest(int checkedKittensCount, int expectedKittensCount) {
        this.checkedKittensCount = checkedKittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensWithArgData() {
        return new Object[][] {
                {0, 0}, //может ли быть 0 котят? зависит от контекста, по-идее может.
                {1, 1},
                {5, 5}, //какое максимальное значение котят должно быть?
                {33, 33}, //речь про котят от одной кошки или о котятах в питомнике/в ореале?
        };
    }

    @Test
    public void getKittensWithArgShowTheSameKittensCount(){
        Feline feline = new Feline();
        int actualKittensCount = feline.getKittens(checkedKittensCount);
        Assert.assertEquals("Ожидаемое количество котят не совпадает с получаемым.", expectedKittensCount, actualKittensCount);
    }
}

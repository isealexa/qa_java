package qa.lion;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionMockGetFoodTest {

    @Mock
    Feline feline;

    @Test
    public void getFoodShouldGetFootWithArgPredator() throws Exception {
        Lion lion = new Lion("Самка", feline);
        boolean notExceptionOrError = true;
        try {
            lion.getFood();
            Mockito.verify(feline).getFood("Хищник");
        } catch (Exception | Error exEr) {
            notExceptionOrError = false;
        }
        Assert.assertTrue("Кажется метод getFood() в классе Lion не вызывает метод getFood(Хищник) или вызывает неправильно.", notExceptionOrError);
    }

    @Test
    public void getFoodShowListFoodOfPredator() throws Exception {
        Lion lion = new Lion("Самец", feline);
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expectedListFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualListFood = lion.getFood();
        Assert.assertEquals("Метод getFood() в классе Lion возвращает не то значение.", expectedListFood, actualListFood);
    }
}

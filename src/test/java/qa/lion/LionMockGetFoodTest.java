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
        Lion lion = new Lion(feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void getFoodShowListFoodOfPredator() throws Exception {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expectedListFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualListFood = lion.getFood();
        Assert.assertEquals("Метод getFood() в классе Lion, он возвращает не то значение.", expectedListFood, actualListFood);
    }
}

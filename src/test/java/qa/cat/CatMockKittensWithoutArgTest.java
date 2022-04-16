package qa.cat;

import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatMockKittensWithoutArgTest {

    @Mock
    Feline feline;

    @Test
    public void getFoodShouldGetEatMeat() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }

    @Test
    public void getFoodShowListFoodOfPredator() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expectedListFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualListFood = cat.getFood();
        Assert.assertEquals("Метод getFood() в классе Cat возвращает не то значение.", expectedListFood, actualListFood);
    }
}

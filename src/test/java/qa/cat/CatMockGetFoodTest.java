package qa.cat;

import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatMockGetFoodTest {

    @Mock
    Feline mockFeline;

    //Название теста: getFood() должен вызвать метод eatMeat() и покзать список еды хищника: "Животные", "Птицы", "Рыба"
    @Test
    public void getFoodShouldCalledEatMeatAndShowListFoodOfPredator() throws Exception {
        Cat cat = new Cat(mockFeline);
        Mockito.when(mockFeline.eatMeat()).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        List<String> expectedListFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualListFood = new ArrayList<>();
        boolean notExceptionOrError = true;
        try {
            actualListFood = cat.getFood();
            Mockito.verify(mockFeline).eatMeat();
        } catch (Exception | Error exEr) {
            notExceptionOrError = false;
        }
        Assert.assertTrue("Метод getFood() в классе Cat либо не вызывает eatMeat(), либо делает это неправильно", notExceptionOrError);
        Assert.assertEquals("Метод getFood() в классе Cat возвращает не то значение.", expectedListFood, actualListFood);
    }
}

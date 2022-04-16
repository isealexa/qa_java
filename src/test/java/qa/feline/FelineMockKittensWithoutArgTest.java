package qa.feline;

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
public class FelineMockKittensWithoutArgTest{

    @Mock
    Feline feline;

    @Test
    public void getKittensWithoutArgShouldGetKittensWithArgOne(){
        Mockito.when(feline.getKittens()).thenCallRealMethod();
        feline.getKittens();
        Mockito.verify(feline).getKittens(1);
    }

    @Test
    public void getKittensWithoutArgShowKittensCountOne(){
        Mockito.when(feline.getKittens(Mockito.anyInt())).thenReturn(1);
        Mockito.when(feline.getKittens()).thenCallRealMethod();
        int expectedKittensCount = 1;
        int actualKittensCount = feline.getKittens();
        Assert.assertEquals("Ошибка в методе getKittens(), он должен возвращать одного котёнка.", expectedKittensCount, actualKittensCount);
    }

    @Test
    public void eatMeatShouldGetFoodWithArgPredator() throws Exception {
        Mockito.when(feline.eatMeat()).thenCallRealMethod();
        feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public  void eatMeatShowListFoodOfPredator() throws Exception {
        Mockito.when(feline.getFood(Mockito.anyString())).thenReturn(Arrays.asList("Животные", "Птицы", "Рыба"));
        Mockito.when(feline.eatMeat()).thenCallRealMethod();
        List<String> expectedListFood = Arrays.asList("Животные", "Птицы", "Рыба");
        List<String> actualListFood = feline.eatMeat();
        Assert.assertEquals("Метод eatMeat() в классе Feline, он возвращает не то значение.", expectedListFood, actualListFood);
    }
}

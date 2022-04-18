package qa.feline;

import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FelineMockEatMeatTest {

    @Mock
    Feline feline;

    //Здесь нужно частично мокать класс Feline, потому что я проверяю работу метода eatMeat(),
    //а он как раз вызывает другой метод, который я здесь не проверяю(проверяю в другом тесте), поэтому
    //я и мокаю метод getFood("Хищник"), а для проверяемого feline.eatMeat() делаю реальный вызов через CallRealMethod

    @Test
    public  void eatMeatShowListFoodOfPredator() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Mockito.when(feline.eatMeat()).thenCallRealMethod();
        List<String> expectedListFood = List.of("Животные", "Птицы", "Рыба");
        List<String> actualListFood = new ArrayList<>();
        boolean notExceptionOrError = true;
        try {
            actualListFood = feline.eatMeat();
            Mockito.verify(feline).getFood("Хищник");
        } catch (Exception | Error exEr) {
            notExceptionOrError = false;
        }
        Assert.assertTrue("В методе eatMeat класса Feline либо нет вызова getFood(Хищник), либо он вызван не с тем значением", notExceptionOrError);
        Assert.assertEquals("Метод eatMeat() в классе Feline возвращает не то значение.", expectedListFood, actualListFood);
    }
}

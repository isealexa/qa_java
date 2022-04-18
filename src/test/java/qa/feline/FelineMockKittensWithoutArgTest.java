package qa.feline;

import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineMockKittensWithoutArgTest{

    //Навание теста: getKittens() должен вызвать getKittens(1) и вернуть количество котят 1.
    //Здесь не нужна параметризация, так как getKittens() не принимает никаких аргументов.
    //Здесь нужно частично мокать класс Feline, потому что я проверяю работу метода getKittens(),
    //а он как раз вызывает другой метод, который я здесь не проверяю(проверяю в другом тесте), поэтому
    //я и мокаю метод getKittens(int kittensCount)
    @Test
    public void getKittensWithoutArgShouldCalledGetKittensWithArgOneAndShowKittensCountOne(){
        Feline feline = new Feline();
        Feline felineMock = Mockito.mock(Feline.class);
        Mockito.when(felineMock.getKittens()).thenCallRealMethod();
        int expectedKittensCount = feline.getKittens(1);
        int actualKittensCount = 0;
        boolean getKittensCalled = true;
        try {
            felineMock.getKittens();
            Mockito.verify(felineMock).getKittens(1);
            actualKittensCount = feline.getKittens();
        } catch (Exception | Error exEr) {
            getKittensCalled = false;
        }
        Assert.assertTrue("Похоже в классе Feline метод getKittens() либо не вызывает getKittens(1), либо вызывает его с другим аргументом", getKittensCalled);
        Assert.assertEquals("Ошибка в методе getKittens(), он должен возвращать одного котёнка.", expectedKittensCount, actualKittensCount);
    }
}

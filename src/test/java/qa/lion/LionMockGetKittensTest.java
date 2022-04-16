package qa.lion;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class LionMockGetKittensTest {

    @Mock
    Feline feline;

    @Test
    public void getKittensShowIntKittensCount() {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int expectedKittensCount = 1;
        int actualKittensCount = lion.getKittens();
        Assert.assertEquals("Метод getKittens() в классе Lion должен был вернуть одного котёнка", expectedKittensCount, actualKittensCount);
    }
}

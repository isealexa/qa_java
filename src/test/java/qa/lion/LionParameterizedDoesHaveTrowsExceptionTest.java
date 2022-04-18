package qa.lion;

import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

@RunWith(Parameterized.class)
public class LionParameterizedDoesHaveTrowsExceptionTest {

    private final String checkedIncorrectValue;

    public LionParameterizedDoesHaveTrowsExceptionTest(String checkedIncorrectValue) {
        this.checkedIncorrectValue = checkedIncorrectValue;
    }

    @Parameterized.Parameters
    public static Object[][] getLionData() {
        return new Object[][]{
                {""},
                {"самец"},
                {"самка"},
                {"Female"},
                {"Male"},
                {"каракатица"},
                {"животное ещё не решило"},
        };
    }

    @Test(expected = Exception.class)
    public void doesHaveManeForIncorrectValueShowException() throws Exception {
        Feline feline = new Feline();
        Lion lion = new Lion(checkedIncorrectValue, feline);
        lion.doesHaveMane();
    }
}

package qa.lion;

import com.example.Lion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class LionDoesHaveManeTextExceptionTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void doesHaveManeForIncorrectValueShowCorrectExceptionMessage() throws Exception {
        exceptionRule.expect(Exception.class);
        exceptionRule.expectMessage("Используйте допустимые значения пола животного - Самец или Самка");
        Lion lion = new Lion("А то ли сообщение вернётся?");
    }
}

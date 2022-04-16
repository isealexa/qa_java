package qa.feline;

import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

public class FelineGetFamilyShowTest {

    @Test
    public void getFamilyShowTextFelineInRu(){
        Feline feline = new Feline();
        String expectedText = "Кошачьи";
        String actualText = feline.getFamily();
        Assert.assertEquals("Ошибка в методе getFamily(), вернулось не то значение.", expectedText, actualText);
    }

    @Test
    public void getKittensWithNegativeArgShowException(){
        Feline feline = new Feline();
        boolean hasException = false;
        try {
            feline.getKittens(-1);
        } catch (IllegalArgumentException exception) {
            hasException = true;
        }
        Assert.assertTrue("В методе getKittens(int kittensCount) отсутствует проверка на отрицательные числа.", hasException);
    }
}

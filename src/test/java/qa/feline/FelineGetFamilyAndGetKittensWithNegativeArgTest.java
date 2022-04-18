package qa.feline;

import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

//Название класса тестов: в классе Feline проверяем методы getFamily() и getKittens(int kittensCount) c отрицательным аргументом
public class FelineGetFamilyAndGetKittensWithNegativeArgTest {

    @Test
    public void getFamilyShowTextFelineInRu(){
        Feline feline = new Feline();
        String expectedText = "Кошачьи";
        String actualText = feline.getFamily();
        Assert.assertEquals("Ошибка в методе getFamily(), вернулось не то значение.", expectedText, actualText);
    }

    //Название теста: getKittens(-1) должен вернуть исключение
    @Test
    public void getKittensWithNegativeArgReturnException(){
        Feline feline = new Feline();
        boolean hasException = false;
        try {
            feline.getKittens(-1);
        } catch (IllegalArgumentException exception) {
            hasException = true;
        }
        catch (Exception exception) {
            hasException = true;
        }
        Assert.assertTrue("В методе getKittens(int kittensCount) отсутствует проверка на отрицательные числа.", hasException);
    }
}

package qa.lion;

import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class LionDoesHaveManeTextExceptionTest {

    //Навание теста: метод doesHaveMane() для некорректного значения должно показывать корректное сообщение об ошибке
    @Test
    public void doesHaveManeForIncorrectValueShowCorrectExceptionMessage() {
        Feline feline = new Feline();
        String expectedMessage = "Используйте допустимые значения пола животного - Самец или Самка";
        String actualMessage = null;
        ArrayList<String> listOfExpectedWords = new ArrayList<>();
        ArrayList<String> listOfActualWords = new ArrayList<>();
        ArrayList<Integer> index = new ArrayList<>();
        ArrayList<String>  listOfDiff = new ArrayList<>();
        String expectedWords = "";
        String actualWords = "";
        String stringDiff = "";
        String moreString = "ожидаемой";
        String lessString = "полученной";
        boolean notDiff = true;
        boolean hasException = false;

        try {
            new Lion("Некорректное значение", feline);
        } catch (Exception | Error exEr) {
            hasException = true;
            actualMessage = exEr.getMessage();

            if (!expectedMessage.equals(actualMessage)) {
                String[] splitExpectedMessage = expectedMessage.split(" ");
                String[] splitActualMessage = actualMessage.split(" ");
                int lengthMessage = splitExpectedMessage.length;

                if (splitExpectedMessage.length < splitActualMessage.length) {
                    notDiff = false;
                    for (int j = splitExpectedMessage.length; j < splitActualMessage.length; j++) {
                        listOfDiff.add(splitActualMessage[j]);
                        moreString = "полученной";
                        lessString = "ожидаемой";
                    }
                    stringDiff = "В " + moreString + " строке больше слов, чем в " + lessString + " cтроке на: " + String.join(", ", listOfDiff.toString()) + ", ";
                }

                if (splitExpectedMessage.length > splitActualMessage.length) {
                    notDiff = false;
                    for (int j = splitActualMessage.length; j < splitExpectedMessage.length; j++) {
                        listOfDiff.add(splitExpectedMessage[j]);
                        lengthMessage = splitActualMessage.length;
                    }
                    stringDiff = "В " + moreString + " строке больше слов, чем в " + lessString + " cтроке на: " + String.join(", ", listOfDiff.toString()) + ", ";
                }

                for (int i = 0; i < lengthMessage; i++) {
                    if (!splitExpectedMessage[i].equals(splitActualMessage[i])) {
                        listOfExpectedWords.add(String.valueOf(splitExpectedMessage[i]));
                        listOfActualWords.add(String.valueOf(splitActualMessage[i]));
                        index.add(i);
                    }
                }
                expectedWords = String.join(", ", listOfExpectedWords.toString());
                actualWords = String.join(", ", listOfActualWords.toString());
            }
        }
        Assert.assertTrue("В этом тесте мы ждали, что класс Lion(Некорректное значение, feline) вернёт исключение, но его не случилось", hasException);
        Assert.assertNotNull("Исключение класса Lion(Некорректное значение, feline) должно было вернуть сообщение '" + expectedMessage + "'. Но полученное сообщение равно Null", actualMessage);
        Assert.assertTrue("Исключение класса Lion(Некорректное значение, feline) должно было вернуть сообщение '" + expectedMessage + "'. Но полученное сообщение пустое или состоит из пробелов", !(actualMessage.isBlank()));
        Assert.assertEquals("Исключение класса Lion(Некорректное значение, feline) должно было вернуть сообщение '" + expectedMessage + "' " + stringDiff + ", в словах под номерами " + index + " нашлись опечатки: ",expectedWords, actualWords);
        Assert.assertTrue("" + stringDiff + ". ", notDiff);
    }
}
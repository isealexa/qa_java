package qa.cat;

import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;

public class CatGetSoundTest {

    @Test
    public void getSoundShowMeowInRu(){
        Feline feline = new Feline();
        Cat cat = new Cat(feline);
        String expectedSoundText = "Мяу";
        String actualSoundText = cat.getSound();
        Assert.assertEquals("Коты звучат не так. Котам положено мяукать.", expectedSoundText, actualSoundText);
    }
}

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class AccountTest {
    private final String name;
    private final boolean expectedCheckResult;

    public AccountTest(String name, boolean expectedCheckResult) {
        this.name = name;
        this.expectedCheckResult = expectedCheckResult;
    }
    @Parameterized.Parameters(name = "{index}: Name ({0})")
    public static Object[][] getColorsData() {
        return new Object[][]{
                {"", false},
                {".", false},
                {"        ", false},
                {"k ", false},
                {"h f", true},
                {"h fd", true},
                {"gjgjgg gjgjgjgjgjjg", true},//19 символов
                {"gjgjgg gjgjgjgjgjjgl", false},//20 символов
                {" Petr Valiev", false},//2 пробела, Имя с пробелом в начале
                {"Petr Vali ", false},// 2 пробела, Имя с пробелом в конце
                {" Petr Vali ", false},// Имя с пробелом в конце и в начале
                {" PetrVali", true}, // 1 пробел в начале
                {" PetrVali", true},// 1 пробел в конце
                {"ТимотейШевроле", false},
                {"aaaaa aaaaa", true},
                {"a bvcdggggg", true},
                {"Petr   Valiev", false},
                {null, false},
        };
    }

    @Test
    public void shouldMakeOrderTest() {
        Assert.assertEquals(expectedCheckResult, new Account(name).checkNameToEmboss());
    }
}

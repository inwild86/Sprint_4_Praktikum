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
                {"  ", false},
                {"k ", false},
                {"h f", true},
                {"gjgjgg gjgjgjgjgjjgjgjgjgjgjgjgjg", false},
                {" Petr Valiev", false},
                {"ТимотейШевроле", false},
                {"Petr Valiev ", false},
                {"aaaaa aaaaa", true},
                {"a bvcdggggg", true},
                {"Petr  Valiev", false},
        };
    }

    @Test
    public void shouldMakeOrderTest() {
        Assert.assertEquals(expectedCheckResult, new Account(name).checkNameToEmboss());
    }
}

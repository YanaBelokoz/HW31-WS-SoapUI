package Utils;

import AllUseModels.Models;
import org.testng.Assert;

import java.util.List;

public class Validator {
    public Validator validateStatusCode(int actualCode, int expectedCode) {
        Assert.assertEquals(actualCode, expectedCode, String.format(
                "\nStatus code is: '%s'. \nExpected: %s, actualCode, expectedCode"));
        return this;
    }

    public Validator validateModelsName(String actualName, String expectedName) {
        Assert.assertEquals(actualName, expectedName, String.format(
                "\nModels Name is: '%s'. \nExpected: %s", actualName, expectedName));
        return this;
    }

    public Validator validateModelsCount(List<Models> models, int expected) {
        Assert.assertEquals(models.size(), expected);
        return this;
    }
}

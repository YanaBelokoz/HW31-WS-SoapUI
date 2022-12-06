import AllUseModels.Models;
import AllUseModels.Query;
import Service.AllService;
import Utils.ResponseModels;
import Utils.Validator;
import io.restassured.response.Response;
import org.testng.TestNGAntTask;
import org.testng.annotations.Test;

public class ModelsTest {
    public Validator validator = new Validator();
    private final AllService allService = new AllService();
    private final ResponseModels responseModels = new ResponseModels();

    @Test (description = "Positive check creation models")
    public void verifyPostCreateModel () {
        String testName = "FirstTest";
        ResponseModels responseCreateEntity = allService.createModels(Models.builder().name(testName).build());
        Models response = responseModels.getAsModelsClass(responseCreateEntity);
        validator
                .validateModelsName(responseCreateEntity.getStatusCode(),SC_CREATED)
                .validateModelsName(response.name, testName);

        allService.deleteModels(response.modelsId);
    }

    @Test(description = "Positive check search model")
    public void verifyGetSearchModels () {
        int expectedSize = 2;
        ResponseModels response = allService.getModels(new Query(1, true, expectedSize));
        validator
                .validateStatusCode(response.getStatusCode(), SC_TRUE)
                .validateModelsCount(responseModels.getAsModelsClassArray(response), expectedSize);
    }

    @Test (description = "Negative check creation a model")
    public void verifyPostErrorCreateModel() {
        ResponseModels responseCreateEntity = allService.createModels(Models.builder().build());
        validator
                .validateStatusCode(responseCreateEntity.getStatusCode(), SC_BAD_REQUEST);
    }

    @Test (description = "Positive check delete model")
    public void verifyDeleteModel() {
        ResponseModels responseCreateEntity = allService.createModels(Models.builder().name("TestName").build());
        Models responce = responseModels.getAsModelsClass(responseCreateEntity);
        Integer modelId = responce.modelsId;
        allService
                .deleteModels(responce.modelsId);
        Response responseCheckEntity = allService.getModelsById(new Query(), modelId);
        validator
                .validateStatusCode(responseCreateEntity.getStatusCode(), SC_NOT_FOUND);
    }
}
